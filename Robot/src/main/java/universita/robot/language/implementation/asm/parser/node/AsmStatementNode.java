package universita.robot.language.implementation.asm.parser.node;

public sealed interface AsmStatementNode extends AsmASTNode
        permits AsmStatementNode.AsmLabelDefinitionNode, AsmInstructionNode {
    record AsmLabelDefinitionNode(String label) implements AsmStatementNode {}
}
