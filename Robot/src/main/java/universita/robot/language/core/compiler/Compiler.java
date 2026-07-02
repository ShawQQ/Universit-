package universita.robot.language.core.compiler;

import universita.robot.language.core.parser.ASTNode;

@FunctionalInterface
public interface Compiler<S, N extends ASTNode> {
    N compile(S source);
}
