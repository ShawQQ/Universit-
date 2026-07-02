package universita.robot.language.implementation.asm.parser.node;

public sealed interface AsmStatementNode extends AsmASTNode
        permits AsmInstructionNode, AsmStatementNode.AsmLabelDefinitionNode {
    record AsmLabelDefinitionNode(String label) implements AsmStatementNode {}
}
