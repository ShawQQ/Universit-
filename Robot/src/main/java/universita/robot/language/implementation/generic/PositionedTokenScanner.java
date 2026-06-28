package universita.robot.language.implementation.generic;

import universita.robot.language.core.lexer.Token;
import universita.robot.language.core.parser.TokenScanner;

public interface PositionedTokenScanner<T extends Token> extends TokenScanner<T> {
    int getLine();
}
