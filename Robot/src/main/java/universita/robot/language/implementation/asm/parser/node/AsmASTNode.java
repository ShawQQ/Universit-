package universita.robot.language.implementation.asm.parser.node;

import universita.robot.language.core.parser.ASTNode;

import java.util.List;

public sealed interface AsmASTNode extends ASTNode
        permits AsmASTNode.AsmProgramNode, AsmBinaryOperatorNode, AsmJumpTargetNode, AsmOperandNode, AsmStatementNode {
    record AsmProgramNode(List<AsmStatementNode> tokens) implements AsmASTNode {}
}
