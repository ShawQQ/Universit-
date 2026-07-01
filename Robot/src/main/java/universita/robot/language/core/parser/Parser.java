package universita.robot.language.core.parser;

import universita.robot.language.core.exception.ParserException;

public interface Parser<N extends ASTNode, S> {
    N parse(S scanner) throws ParserException;
}
