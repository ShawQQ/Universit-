package universita.robot.language.implementation.asm.parser.node;

public sealed interface AsmBinaryOperatorNode extends AsmASTNode
        permits AsmBinaryOperatorNode.AsmAddNode{
    record AsmAddNode() implements AsmBinaryOperatorNode {}
}
