package universita.robot.language.implementation.asm;

import universita.robot.language.core.lexer.Lexer;
import universita.robot.language.core.lexer.SourceScanner;
import universita.robot.language.core.exception.LexerException;

import java.util.ArrayList;
import java.util.List;

public class AsmLexer implements Lexer<AsmToken> {
    private final List<Character> separatorList;
    private SourceScanner<?> scanner;
    public AsmLexer(){
        this.separatorList = List.of(
                '\t',
                ' ',
                ','
        );
    }
    @Override
    public List<AsmToken> tokenize(SourceScanner<?> s) throws LexerException {
        if(s == null) throw new NullPointerException("Scanner non valido");
        this.scanner = s;
        List<AsmToken> tokens = new ArrayList<>();
        while(scanner.canConsume()){
            char c = scanner.peek();
            if(this.isSeparator(c)){
                this.scanner.advance();
                continue;
            }
            if(this.isNewLine(c)){
                this.scanner.incrementLine();
                this.scanner.advance();
                continue;
            }
            if(Character.isLetterOrDigit(c)){
                String lexeme = this.getNextLexeme();
                tokens.add(matchLexeme(lexeme));
            }else{
                throw new LexerException("Carattere non valido: %c".formatted(c), scanner.getLine());
            }
        }

        return tokens;
    }

    private boolean isNewLine(char c) {
        return c == '\n';
    }

    private AsmToken matchLexeme(String lexeme) throws LexerException {
        return switch(lexeme){
            case "ADD" -> AsmToken.ADD;
            case "JMP" -> AsmToken.JMP;
            default -> {
                if(this.scanner.canConsume() && this.scanner.peek() == ':'){
                    this.scanner.advance();
                    if(this.isLabel(lexeme) && this.isEndOfLine()) yield AsmToken.LABEL_DEFINTION;
                    throw new LexerException("Definizione label non valida", scanner.getLine());
                }
                if(this.isOperand(lexeme)) yield AsmToken.OPERAND;
                if(this.isLabel(lexeme)) yield AsmToken.LABEL;
                throw new LexerException("Operazione non valida: %s".formatted(lexeme), scanner.getLine());
            }
        };
    }

    private boolean isEndOfLine() {
        while(this.scanner.canConsume()){
            if(this.isNewLine(this.scanner.peek())) return true;
            this.scanner.advance();
        }
        return false;
    }

    private boolean isLabel(String lexeme) {
        if(lexeme.isEmpty()) return false;
        if(!Character.isLetter(lexeme.charAt(0))) return false;
        return lexeme.chars().allMatch(Character::isLetterOrDigit);
    }

    private boolean isOperand(String lexeme) {
        return this.isRegister(lexeme) || this.isLiteral(lexeme);
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
}
