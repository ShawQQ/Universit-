package universita.robot.language.implementation.asm.parser.node;

import universita.robot.language.core.parser.ASTNode;

public sealed interface AsmJumpTargetNode extends AsmASTNode
        permits AsmJumpTargetNode.AsmLabelRefenceNode {
    record AsmLabelRefenceNode(String name) implements AsmJumpTargetNode {}
}
