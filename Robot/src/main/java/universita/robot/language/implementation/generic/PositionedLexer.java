package universita.robot.language.implementation.generic;

import universita.robot.language.core.exception.LexerException;
import universita.robot.language.core.lexer.Lexer;
import universita.robot.language.core.lexer.SourceScanner;
import universita.robot.language.core.lexer.Token;

import java.util.List;

public interface PositionedLexer<T extends Token> extends Lexer<T> {
    List<T> tokenize(PositionedSourceScanner<?> s) throws LexerException;

    @Override
    default List<T> tokenize(SourceScanner<?> s) throws LexerException {
        if(s instanceof PositionedSourceScanner<?>){
            PositionedSourceScanner<?> scanner = (PositionedSourceScanner<?>) s;
            return tokenize(scanner);
        }
        throw new LexerException("Scanner non valido per questo tipo di lexer");
    }
}
