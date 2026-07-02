package universita.robot.language.core.compiler;

import universita.robot.language.core.parser.ASTNode;

@FunctionalInterface
public interface Compiler<S, N extends ASTNode> {
    ExecutableProgram<N> compile(S source);
}
