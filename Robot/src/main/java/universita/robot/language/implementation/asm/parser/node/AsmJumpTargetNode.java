package universita.robot.language.implementation.asm.parser.node;

public sealed interface AsmJumpTargetNode extends AsmASTNode
        permits AsmJumpTargetNode.AsmLabelRefenceNode {
    record AsmLabelRefenceNode(String name) implements AsmJumpTargetNode {}
}
