package universita.robot.language.implementation.asm.lexer;

import universita.robot.language.core.lexer.SourceScanner;
import universita.robot.language.core.exception.LexerException;
import universita.robot.language.implementation.generic.PositionedLexer;
import universita.robot.language.implementation.generic.PositionedSourceScanner;
import universita.robot.language.implementation.generic.PositionedToken;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class AsmLexer implements PositionedLexer<PositionedToken<AsmToken>> {
    private final List<Character> separatorList;
    private PositionedSourceScanner<?> scanner;
    private Map<String, Supplier<AsmToken>> mnemonics;
    public AsmLexer(){
        this.separatorList = List.of(
                '\t',
                ' ',
                ',',
                '\n'
        );
        this.mnemonics = Map.of(
            "ADD", AsmToken.Add::new,
            "JMP", AsmToken.Jmp::new
        );
    }
    @Override
    public List<PositionedToken<AsmToken>> tokenize(PositionedSourceScanner<?> s) throws LexerException {
        if(s == null) throw new NullPointerException("Scanner non valido");
        this.scanner = s;
        List<PositionedToken<AsmToken>> tokens = new ArrayList<>();
        while(scanner.canConsume()){
            char c = scanner.peek();
            if(this.isSeparator(c)){
                this.scanner.advance();
                continue;
            }
            if(Character.isLetterOrDigit(c)){
                String lexeme = this.getNextLexeme();
                tokens.add(new PositionedToken<>(this.matchLexeme(lexeme), scanner.getLine()));
            }else{
                throw this.createLexerException("Carattere non valido: %c".formatted(c));
            }
        }

        return tokens;
    }

    private AsmToken matchLexeme(String lexeme) throws LexerException {
        if(this.mnemonics.containsKey(lexeme)) return this.mnemonics.get(lexeme).get();
        if(this.isLabelDefinition(lexeme)) return new AsmToken.LabelDefinition(lexeme);
        if(this.isRegister(lexeme)) return new AsmToken.Operand<>(new AsmOperandValue.Register(lexeme));
        if(this.isLiteral(lexeme)) return new AsmToken.Operand<>(new AsmOperandValue.Literal(Integer.parseInt(lexeme)));
        if(this.isLabel(lexeme)) return new AsmToken.Label(lexeme);
        throw this.createLexerException("Operazione non valida: %s".formatted(lexeme));
    }

    private boolean isLabelDefinition(String lexeme) {
        if(this.scanner.canConsume() && this.scanner.peek() == ':'){
            this.scanner.advance();
            if(this.isLabel(lexeme) && this.scanner.isEndOfLine()) return true;
            throw this.createLexerException("Definizione label non valida");
        }
        return false;
    }

    private boolean isLabel(String lexeme) {
        if(lexeme.isEmpty()) return false;
        if(!Character.isLetter(lexeme.charAt(0))) return false;
        return lexeme.chars().allMatch(Character::isLetterOrDigit);
    }

    private boolean isLiteral(String lexeme) {
        if(lexeme.isEmpty()) return false;
        return lexeme.chars().allMatch(Character::isDigit);
    }

    private boolean isRegister(String lexeme) {
        if(lexeme.length() < 2) return false;
        return lexeme.charAt(0) == 'R' && lexeme.chars().skip(1).allMatch(Character::isDigit);
    }

    private String getNextLexeme() {
        StringBuilder lexeme = new StringBuilder();
        while(this.scanner.canConsume() && Character.isLetterOrDigit(this.scanner.peek())){
            lexeme.append(this.scanner.peek());
            this.scanner.advance();
        }
        return lexeme.toString();
    }

    private boolean isSeparator(char c) {
        return this.separatorList.contains(c);
    }

    private LexerException createLexerException(String msg){
        return new LexerException(msg, this.scanner.getLine());
    }
}
