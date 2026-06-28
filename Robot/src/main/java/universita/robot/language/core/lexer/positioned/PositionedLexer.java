package universita.robot.language.core.lexer.positioned;

import universita.robot.language.core.lexer.Lexer;
import universita.robot.language.core.lexer.Token;

public interface PositionedLexer<T extends Token> extends Lexer<PositionedToken<T>> {
}
