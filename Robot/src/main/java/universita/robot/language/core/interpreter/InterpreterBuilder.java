package universita.robot.language.core.interpreter;

import universita.robot.language.core.parser.ASTNode;
import universita.robot.language.implementation.asm.interpreter.AsmInterpreter;
import universita.robot.language.implementation.asm.parser.node.AsmInstructionNode;
import universita.robot.language.implementation.asm.parser.node.AsmStatementNode;
import universita.robot.vm.core.Context;
import universita.robot.vm.core.InputOutput;
import universita.robot.vm.core.WritableContext;

public class InterpreterBuilder {
    private Context ctx;
    private InputOutput<Integer> pc;

    public InterpreterBuilder withContext(Context ctx){
        this.ctx = ctx;
        return this;
    }

    public InterpreterBuilder withPc(InputOutput<Integer> pc){
        this.pc = pc;
        return this;
    }

    @SuppressWarnings("unchecked")
    public Interpreter<AsmStatementNode> forAsm(){
        if(this.ctx == null) throw new IllegalStateException("Context obbligatorio per questo interprete");
        if(this.pc == null) throw new IllegalStateException("Program Counter obbligatorio per questo interprete");
        if(!(this.ctx instanceof WritableContext<?>))
            throw new IllegalStateException("Context non valido per questo interprete");
        WritableContext<String> context = (WritableContext<String>) this.ctx;
        return new AsmInterpreter(context, this.pc);
    }
}
