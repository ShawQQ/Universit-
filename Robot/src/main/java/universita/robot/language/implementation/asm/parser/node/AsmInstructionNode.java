package universita.robot.language.implementation.asm.parser.node;

public sealed interface AsmInstructionNode extends AsmStatementNode
        permits AsmInstructionNode.AsmBinaryInstructionNode, AsmInstructionNode.AsmJumpInstructionNode {
    record AsmBinaryInstructionNode(AsmBinaryOperatorNode o,AsmOperandNode l, AsmOperandNode r) implements AsmInstructionNode {}
    record AsmJumpInstructionNode(AsmJumpTargetNode t) implements AsmInstructionNode {}
}
