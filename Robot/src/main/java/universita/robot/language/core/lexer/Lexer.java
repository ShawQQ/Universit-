package universita.robot.language.core.lexer;

import universita.robot.language.core.exception.LexerException;

import java.util.List;

public interface Lexer<T extends Token> {
    List<T> tokenize(SourceScanner<?> s) throws LexerException;
}
