package universita.robot.language.implementation.asm.parser.node;

public sealed interface AsmJumpTargetNode extends AsmASTNode
        permits AsmJumpTargetNode.AsmLabelReferenceNode, AsmJumpTargetNode.AsmLabelResolvedNode {
    record AsmLabelReferenceNode(String name) implements AsmJumpTargetNode {}
    record AsmLabelResolvedNode(int index) implements AsmJumpTargetNode {}
}
