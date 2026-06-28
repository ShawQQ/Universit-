package universita.robot.language.implementation.asm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import universita.robot.language.implementation.asm.lexer.AsmOperandValue;
import universita.robot.language.implementation.asm.lexer.AsmToken;
import universita.robot.language.implementation.asm.parser.AsmParser;
import universita.robot.language.implementation.asm.parser.node.*;
import universita.robot.language.implementation.generic.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("AsmParser test suite")
public class AsmParserTest {
    private PositionedParser<AsmASTNode.AsmProgramNode, AsmToken> parser;
    private AsmASTNode.AsmProgramNode result;
    @BeforeEach
    public void beforeEach(){
        this.parser = new AsmParser();
    }
    @BeforeEach
    public void displayTestName(TestInfo testInfo){
        System.out.println("Eseguendo: %s".formatted(testInfo.getDisplayName()));
    }

    @Test
    @DisplayName("Test generico parser")
    public void testAsmParserGenericProgram(){
        AsmASTNode.AsmProgramNode correct = new AsmASTNode.AsmProgramNode(
                List.of(new AsmInstructionNode.AsmBinaryInstructionNode(
                        new AsmBinaryOperatorNode.AsmAddNode(),
                        new AsmOperandNode.AsmRegisterOperand("R1"),
                        new AsmOperandNode.AsmLiteralOperand(4))
                )
        );
        List<PositionedToken<AsmToken>> tokenList = List.of(
                new PositionedToken<>(new AsmToken.Add(), 1),
                new PositionedToken<>(new AsmToken.Operand<>(new AsmOperandValue.Register("R1")), 1),
                new PositionedToken<>(new AsmToken.Operand<>(new AsmOperandValue.Literal(4)), 1)
        );
        PositionedTokenScanner<AsmToken> scanner = new PositionedTokenScannerList<>(tokenList);
        this.result = parser.parse(scanner);
        assertArrayEquals(correct.nodes().toArray(), this.result.nodes().toArray());
    }
}
