package universita.robot.language.core.parser;

import universita.robot.language.core.exception.ParserException;
import universita.robot.language.core.lexer.Token;

import java.util.List;

public interface Parser<N extends ASTNode, T extends Token> {
    N parse(TokenScanner<T> scanner) throws ParserException;
}
