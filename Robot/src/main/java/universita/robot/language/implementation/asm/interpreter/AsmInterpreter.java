package universita.robot.language.implementation.asm.interpreter;

import universita.robot.language.core.interpreter.Interpreter;
import universita.robot.language.core.parser.ASTNode;
import universita.robot.language.implementation.asm.parser.node.AsmBinaryOperatorNode;
import universita.robot.language.implementation.asm.parser.node.AsmInstructionNode;
import universita.robot.language.implementation.asm.parser.node.AsmJumpTargetNode;
import universita.robot.language.implementation.asm.parser.node.AsmOperandNode;
import universita.robot.vm.core.InputOutput;
import universita.robot.vm.core.WritableContext;
import universita.robot.vm.implementation.Register;

public class AsmInterpreter implements Interpreter<AsmInstructionNode> {
    private final WritableContext<String> ctx;
    private InputOutput<Integer> pc;
    public AsmInterpreter(WritableContext<String> ctx, InputOutput<Integer> pc) {
        this.ctx = ctx;
        this.pc = pc;
    }

    @Override
    public void execute(AsmInstructionNode instr) {
        switch(instr){
            case AsmInstructionNode.AsmBinaryInstructionNode i -> this.executeBinaryInstruction(i);
            case AsmInstructionNode.AsmJumpInstructionNode j ->  this.executeJumpInstruction(j);
        }
    }

    private void executeBinaryInstruction(AsmInstructionNode.AsmBinaryInstructionNode i) {
        switch(i.o()){
            case AsmBinaryOperatorNode.AsmAddNode _ -> executeAdd(i.l(), i.r());
        }
    }

    private void executeAdd(AsmOperandNode l, AsmOperandNode r) {
        int lValue = this.resolveOperand(l);
        int rValue = this.resolveOperand(r);
        this.writeOperand(l, lValue + rValue);
    }

    private void writeOperand(AsmOperandNode l, int val) {
        switch(l){
            case AsmOperandNode.AsmLiteralOperand _ -> throw new IllegalStateException("Costante dove registro atteso");
            case AsmOperandNode.AsmRegisterOperand reg -> this.ctx.write(reg.name(), val);
        }
    }

    private int resolveOperand(AsmOperandNode l) {
        return switch(l){
            case AsmOperandNode.AsmLiteralOperand literal -> literal.value();
            case AsmOperandNode.AsmRegisterOperand register -> this.ctx.read(register.name(), Integer.class);
        };
    }

    private void executeJumpInstruction(AsmInstructionNode.AsmJumpInstructionNode j) {
        switch(j.t()){
            case AsmJumpTargetNode.AsmLabelReferenceNode _ ->
                throw new IllegalStateException("Label non risolte");
            case AsmJumpTargetNode.AsmLabelResolvedNode res -> this.pc.write(res.index());
        }
    }
}
