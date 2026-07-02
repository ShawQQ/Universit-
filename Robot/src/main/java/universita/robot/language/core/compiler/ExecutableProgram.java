package universita.robot.language.core.compiler;

import universita.robot.language.core.parser.ASTNode;

public interface ExecutableProgram<N extends ASTNode> {
    N instructionAt(int index);
    int length();
}
