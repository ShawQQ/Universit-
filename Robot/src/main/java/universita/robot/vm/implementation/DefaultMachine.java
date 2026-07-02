package universita.robot.vm.implementation;

import universita.robot.language.core.interpreter.Interpreter;
import universita.robot.vm.core.Context;
import universita.robot.vm.core.InputOutput;
import universita.robot.vm.core.Machine;

import java.util.List;

public class DefaultMachine implements Machine {
    private Interpreter<?> interpreter;
    private InputOutput<Integer> pc;

    public DefaultMachine(Interpreter<?> interpreter, InputOutput<Integer> pc) {
        this.interpreter = interpreter;
        this.pc = pc;
    }

    @Override
    public void step() {

    }
}
