package universita.robot.language.core.parser;

import universita.robot.language.core.exception.ParserException;

@FunctionalInterface
public interface Parser<N extends ASTNode, S> {
    N parse(S scanner) throws ParserException;
}
