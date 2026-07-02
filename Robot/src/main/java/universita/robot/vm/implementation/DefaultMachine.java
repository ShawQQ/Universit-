package universita.robot.vm.implementation;

import universita.robot.language.core.compiler.ExecutableProgram;
import universita.robot.language.core.interpreter.Interpreter;
import universita.robot.language.core.parser.ASTNode;
import universita.robot.vm.core.Context;
import universita.robot.vm.core.InputOutput;
import universita.robot.vm.core.Machine;

import java.util.List;

public class DefaultMachine<N extends ASTNode> implements Machine {
    private final Interpreter<N> interpreter;
    private final ExecutableProgram<N> program;
    private final Context ctx;
    private InputOutput<Integer> pc;

    public DefaultMachine(
            Interpreter<N> interpreter,
            ExecutableProgram<N> program,
            Context ctx,
            InputOutput<Integer> pc
    ) {
        this.interpreter = interpreter;
        this.program = program;
        this.ctx = ctx;
        this.pc = pc;
    }

    @Override
    public void step() {
        if(!this.validPc())
            throw new IllegalStateException("Program counter non valido");
        int currentInstr = this.pc.read();
        this.interpreter.execute(this.program.instructionAt(currentInstr));
        if(this.pc.read().equals(currentInstr)){
            this.pc.write(currentInstr + 1);
        }
        this.ctx.notifyObserver();
    }

    private boolean validPc() {
        int index = this.pc.read();
        return index >= 0 && index < this.program.length();
    }
}
