package universita.robot.language.implementation.asm.parser.node;

public sealed interface AsmOperandNode extends AsmASTNode
        permits AsmOperandNode.AsmRegisterOperand, AsmOperandNode.AsmLiteralOperand{
    record AsmRegisterOperand(String name) implements AsmOperandNode {}
    record AsmLiteralOperand(int value) implements AsmOperandNode {}
}
