package universita.robot.language.implementation.generic.token;

import universita.robot.language.core.lexer.Token;

public interface PositionedTokenScanner<T extends Token> extends TokenScanner<T> {
    int getLine();
}
