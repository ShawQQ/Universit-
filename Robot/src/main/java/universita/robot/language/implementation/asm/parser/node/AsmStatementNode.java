package universita.robot.language.implementation.asm.parser.node;

import universita.robot.language.core.parser.ASTNode;

public sealed interface AsmStatementNode extends AsmASTNode
        permits AsmStatementNode.AsmLabelDefinitionNode, AsmInstructionNode {
    record AsmLabelDefinitionNode(String label) implements AsmStatementNode {}
}
