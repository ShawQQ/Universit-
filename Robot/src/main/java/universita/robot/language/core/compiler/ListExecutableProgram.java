package universita.robot.language.core.compiler;

import universita.robot.language.core.parser.ASTNode;

import java.util.List;

public class ListExecutableProgram<N extends ASTNode> implements ExecutableProgram<N>{
    private final List<N> instructions;

    public ListExecutableProgram(List<N> instructions) {
        this.instructions = instructions;
    }

    @Override
    public N instructionAt(int index) {
        return this.instructions.get(index);
    }

    @Override
    public int length() {
        return this.instructions.size();
    }
}
