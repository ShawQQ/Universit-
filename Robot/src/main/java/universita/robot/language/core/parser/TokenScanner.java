package universita.robot.language.core.parser;

import universita.robot.language.core.lexer.Token;

public interface TokenScanner<T extends Token> {
    T peek();
    void advance();
    boolean canConsume();
}
