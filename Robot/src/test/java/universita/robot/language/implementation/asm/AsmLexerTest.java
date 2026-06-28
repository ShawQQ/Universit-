package universita.robot.language.implementation.asm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import universita.robot.language.core.exception.LexerException;
import universita.robot.language.core.lexer.SourceScanner;
import universita.robot.language.implementation.generic.PositionedSourceScannerString;
import universita.robot.language.implementation.generic.PositionedLexer;
import universita.robot.language.implementation.generic.PositionedToken;
import universita.robot.language.implementation.asm.lexer.AsmLexer;
import universita.robot.language.implementation.asm.lexer.AsmOperandValue;
import universita.robot.language.implementation.asm.lexer.AsmToken;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Lexer test suite")
public class AsmLexerTest {
    private PositionedLexer<PositionedToken<AsmToken>> lexer;
    private List<PositionedToken<AsmToken>> result;
    @BeforeEach
    public void beforeEach(){
        this.lexer = new AsmLexer();
        this.result = Collections.emptyList();
    }
    @BeforeEach
    public void displayTestName(TestInfo testInfo){
        System.out.println("Eseguendo: %s".formatted(testInfo.getDisplayName()));
    }
    @Test
    @DisplayName("Test due operandi tokenizzati correttamente")
    public void testAddTwoOperandRegisterCorrect(){
        String program = "ADD R1, R3";
        SourceScanner<?> scanner = new PositionedSourceScannerString(program);
        this.result = this.lexer.tokenize(scanner);
        List<PositionedToken<AsmToken>> correct = List.of(
              new PositionedToken<>(new AsmToken.Add(), 1),
              new PositionedToken<>(new AsmToken.Operand<>(new AsmOperandValue.Register("R1")), 1),
              new PositionedToken<>(new AsmToken.Operand<>(new AsmOperandValue.Register("R3")), 1)
        );
        assertArrayEquals(correct.toArray(), this.result.toArray());
    }
    @Test
    @DisplayName("Test n operandi tokenizzati correttamente")
    public void testMultipleAddTwoOperandRegisterCorrect(){
        String program = "ADD R1,R3\nADD R2,R4\nADD R3,R1";
        SourceScanner<?> scanner = new PositionedSourceScannerString(program);
        this.result = this.lexer.tokenize(scanner);
        List<PositionedToken<AsmToken>> correct = List.of(
            new PositionedToken<>(new AsmToken.Add(), 1),
            new PositionedToken<>(new AsmToken.Operand<>(new AsmOperandValue.Register("R1")), 1),
            new PositionedToken<>(new AsmToken.Operand<>(new AsmOperandValue.Register("R3")), 1),
            new PositionedToken<>(new AsmToken.Add(), 2),
            new PositionedToken<>(new AsmToken.Operand<>(new AsmOperandValue.Register("R2")), 2),
            new PositionedToken<>(new AsmToken.Operand<>(new AsmOperandValue.Register("R4")), 2),
            new PositionedToken<>(new AsmToken.Add(), 3),
            new PositionedToken<>(new AsmToken.Operand<>(new AsmOperandValue.Register("R3")), 3),
            new PositionedToken<>(new AsmToken.Operand<>(new AsmOperandValue.Register("R1")), 3)
        );
        assertArrayEquals(correct.toArray(), this.result.toArray());
    }
    @Test
    @DisplayName("Test due operandi immediati tokenizzati correttamente")
    public void testAddTwoOperandImmediate(){
        String program = "ADD 1,4";
        SourceScanner<?> scanner = new PositionedSourceScannerString(program);
        this.result = this.lexer.tokenize(scanner);
        List<PositionedToken<AsmToken>> correct = List.of(
            new PositionedToken<>(new AsmToken.Add(), 1),
            new PositionedToken<>(new AsmToken.Operand<>(new AsmOperandValue.Literal(1)), 1),
            new PositionedToken<>(new AsmToken.Operand<>(new AsmOperandValue.Literal(4)), 1)
        );
        assertArrayEquals(correct.toArray(), this.result.toArray());
    }
    @Test
    @DisplayName("Test n operandi immediati tokenizzati correttamente")
    public void testMultipleAddTwoOperandImmediateCorrect(){
        String program = "ADD 4,7\nADD 1,5\nADD 3,4";
        SourceScanner<?> scanner = new PositionedSourceScannerString(program);
        this.result = this.lexer.tokenize(scanner);
        List<PositionedToken<AsmToken>> correct = List.of(
            new PositionedToken<>(new AsmToken.Add(), 1),
            new PositionedToken<>(new AsmToken.Operand<>(new AsmOperandValue.Literal(4)), 1),
            new PositionedToken<>(new AsmToken.Operand<>(new AsmOperandValue.Literal(7)), 1),
            new PositionedToken<>(new AsmToken.Add(), 2),
            new PositionedToken<>(new AsmToken.Operand<>(new AsmOperandValue.Literal(1)), 2),
            new PositionedToken<>(new AsmToken.Operand<>(new AsmOperandValue.Literal(5)), 2),
            new PositionedToken<>(new AsmToken.Add(), 3),
            new PositionedToken<>(new AsmToken.Operand<>(new AsmOperandValue.Literal(3)), 3),
            new PositionedToken<>(new AsmToken.Operand<>(new AsmOperandValue.Literal(4)), 3)
        );
        assertArrayEquals(correct.toArray(), this.result.toArray());
    }
    @Test
    @DisplayName("Test due operandi misti tokenizzati correttamente")
    public void testAddTwoOperandRegisterAndImmediate(){
        String program = "ADD R1,4";
        SourceScanner<?> scanner = new PositionedSourceScannerString(program);
        this.result = this.lexer.tokenize(scanner);
        List<PositionedToken<AsmToken>> correct = List.of(
            new PositionedToken<>(new AsmToken.Add(), 1),
            new PositionedToken<>(new AsmToken.Operand<>(new AsmOperandValue.Register("R1")), 1),
            new PositionedToken<>(new AsmToken.Operand<>(new AsmOperandValue.Literal(4)), 1)
        );
        assertArrayEquals(correct.toArray(), this.result.toArray());
    }
    @Test
    @DisplayName("Test n operandi misti tokenizzati correttamente")
    public void testMultipleAddTwoOperandRegisterAndImmediateCorrect(){
        String program = "ADD R3,7\nADD R5,5\nADD R1,4";
        SourceScanner<?> scanner = new PositionedSourceScannerString(program);
        this.result = this.lexer.tokenize(scanner);
        List<PositionedToken<AsmToken>> correct = List.of(
            new PositionedToken<>(new AsmToken.Add(), 1),
            new PositionedToken<>(new AsmToken.Operand<>(new AsmOperandValue.Register("R3")), 1),
            new PositionedToken<>(new AsmToken.Operand<>(new AsmOperandValue.Literal(7)), 1),
            new PositionedToken<>(new AsmToken.Add(), 2),
            new PositionedToken<>(new AsmToken.Operand<>(new AsmOperandValue.Register("R5")), 2),
            new PositionedToken<>(new AsmToken.Operand<>(new AsmOperandValue.Literal(5)), 2),
            new PositionedToken<>(new AsmToken.Add(), 3),
            new PositionedToken<>(new AsmToken.Operand<>(new AsmOperandValue.Register("R1")), 3),
            new PositionedToken<>(new AsmToken.Operand<>(new AsmOperandValue.Literal(4)), 3)
        );
        assertArrayEquals(correct.toArray(), this.result.toArray());
    }
    @Test
    @DisplayName("Definizione label non valida")
    public void testThrowsIfLabelIsInvalidLexeme(){
        String program = "label: label:";
        SourceScanner<?> scanner = new PositionedSourceScannerString(program);
        assertThrows(LexerException.class, () -> this.lexer.tokenize(scanner));
    }
    @Test
    @DisplayName("JMP tokenizzato correttamente")
    void testJmpWithLabelCorrect(){
        String program = "JMP label";
        SourceScanner<?> scanner = new PositionedSourceScannerString(program);
        this.result = this.lexer.tokenize(scanner);
        List<PositionedToken<AsmToken>> correct = List.of(
            new PositionedToken<>(new AsmToken.Jmp(), 1),
            new PositionedToken<>(new AsmToken.Label("label"), 1)
        );
        assertArrayEquals(correct.toArray(), this.result.toArray());
    }
    @Test
    @DisplayName("Definizione label tokenizzata correttamente")
    void testLabelDefinitionCorrect(){
        String program = "label:\n JMP label";
        SourceScanner<?> scanner = new PositionedSourceScannerString(program);
        this.result = this.lexer.tokenize(scanner);
        List<PositionedToken<AsmToken>> correct = List.of(
            new PositionedToken<>(new AsmToken.LabelDefinition("label"), 1),
            new PositionedToken<>(new AsmToken.Jmp(), 2),
            new PositionedToken<>(new AsmToken.Label("label"), 2)
        );
        assertArrayEquals(correct.toArray(), this.result.toArray());
    }
}
