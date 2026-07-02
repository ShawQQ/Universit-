package universita.robot;

import universita.robot.game.core.ConcreteRobot;
import universita.robot.language.core.compiler.CompilerFactory;
import universita.robot.language.core.compiler.ExecutableProgram;
import universita.robot.language.core.interpreter.Interpreter;
import universita.robot.language.core.interpreter.InterpreterBuilder;
import universita.robot.language.implementation.asm.parser.node.AsmStatementNode;
import universita.robot.vm.core.Context;
import universita.robot.vm.core.InputOutput;
import universita.robot.vm.core.Machine;
import universita.robot.vm.implementation.DefaultMachine;
import universita.robot.vm.implementation.Register;
import universita.robot.vm.implementation.RegisterContext;

import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String source = "ADD R1,4\n to:\n ADD R1,7\n JMP to";
        Context ctx = new RegisterContext(Map.of(
                "R1", new Register<>(0),
                "R2", new Register<>(0)
        ));
        ctx.addObserver(new ConcreteRobot());
        InputOutput<Integer> pc = new Register<>(0);
        ExecutableProgram<AsmStatementNode> program = CompilerFactory.forAsm().compile(source);
        InterpreterBuilder interpreterBuilder = new InterpreterBuilder();
        Interpreter<AsmStatementNode> interpreter = interpreterBuilder
                .withContext(ctx)
                .withPc(pc)
                .forAsm();
        Machine machine = new DefaultMachine<>(interpreter, program,ctx,pc);
        for(int i = 0; i <= 3; i++){
            try{
                machine.step();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}