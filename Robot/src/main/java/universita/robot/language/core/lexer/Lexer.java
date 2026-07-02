package universita.robot.language.core.lexer;

import universita.robot.language.core.exception.LexerException;

import java.util.List;

@FunctionalInterface
public interface Lexer<T extends Token, S> {
    List<T> tokenize(S s) throws LexerException;
}
