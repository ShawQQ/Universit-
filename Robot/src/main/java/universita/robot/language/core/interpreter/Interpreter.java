package universita.robot.language.core.interpreter;

import universita.robot.language.core.parser.ASTNode;

@FunctionalInterface
public interface Interpreter<N extends ASTNode> {
    void execute(N node);
}
