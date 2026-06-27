package universita.robot.language.implementation.asm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import universita.robot.language.core.exception.LexerException;
import universita.robot.language.core.lexer.Lexer;
import universita.robot.language.core.lexer.SourceScanner;
import universita.robot.language.core.lexer.SourceScannerString;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Lexer test suite")
public class AsmLexerTest {
    private Lexer<AsmToken> lexer;
    private List<AsmToken> result;
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
        SourceScanner<?> scanner = new SourceScannerString(program);
        this.result = this.lexer.tokenize(scanner);
        List<AsmToken> correct = List.of(
          AsmToken.ADD,
          AsmToken.OPERAND,
          AsmToken.OPERAND
        );
        assertArrayEquals(correct.toArray(), this.result.toArray());
    }
    @Test
    @DisplayName("Test n operandi tokenizzati correttamente")
    public void testMultipleAddTwoOperandRegisterCorrect(){
        String program = "ADD R1,R3\nADD R2,R4\nADD R3,R1";
        SourceScanner<?> scanner = new SourceScannerString(program);
        this.result = this.lexer.tokenize(scanner);
        List<AsmToken> correct = List.of(
                AsmToken.ADD,
                AsmToken.OPERAND,
                AsmToken.OPERAND,
                AsmToken.ADD,
                AsmToken.OPERAND,
                AsmToken.OPERAND,
                AsmToken.ADD,
                AsmToken.OPERAND,
                AsmToken.OPERAND
        );
        assertArrayEquals(correct.toArray(), this.result.toArray());
    }
    @Test
    @DisplayName("Test due operandi immediati tokenizzati correttamente")
    public void testAddTwoOperandImmediate(){
        String program = "ADD 1,4";
        SourceScanner<?> scanner = new SourceScannerString(program);
        this.result = this.lexer.tokenize(scanner);
        List<AsmToken> correct = List.of(
                AsmToken.ADD,
                AsmToken.OPERAND,
                AsmToken.OPERAND
        );
        assertArrayEquals(correct.toArray(), this.result.toArray());
    }
    @Test
    @DisplayName("Test n operandi immediati tokenizzati correttamente")
    public void testMultipleAddTwoOperandImmediateCorrect(){
        String program = "ADD 4,7\nADD 1,5\nADD 3,4";
        SourceScanner<?> scanner = new SourceScannerString(program);
        this.result = this.lexer.tokenize(scanner);
        List<AsmToken> correct = List.of(
                AsmToken.ADD,
                AsmToken.OPERAND,
                AsmToken.OPERAND,
                AsmToken.ADD,
                AsmToken.OPERAND,
                AsmToken.OPERAND,
                AsmToken.ADD,
                AsmToken.OPERAND,
                AsmToken.OPERAND
                );
        assertArrayEquals(correct.toArray(), this.result.toArray());
    }
    @Test
    @DisplayName("Test due operandi misti tokenizzati correttamente")
    public void testAddTwoOperandRegisterAndImmediate(){
        String program = "ADD R1,4";
        SourceScanner<?> scanner = new SourceScannerString(program);
        this.result = this.lexer.tokenize(scanner);
        List<AsmToken> correct = List.of(
                AsmToken.ADD,
                AsmToken.OPERAND,
                AsmToken.OPERAND
        );
        assertArrayEquals(correct.toArray(), this.result.toArray());
    }
    @Test
    @DisplayName("Test n operandi misti tokenizzati correttamente")
    public void testMultipleAddTwoOperandRegisterAndImmediateCorrect(){
        String program = "ADD R3,7\nADD R5,5\nADD R1,4";
        SourceScanner<?> scanner = new SourceScannerString(program);
        this.result = this.lexer.tokenize(scanner);
        List<AsmToken> correct = List.of(
                AsmToken.ADD,
                AsmToken.OPERAND,
                AsmToken.OPERAND,
                AsmToken.ADD,
                AsmToken.OPERAND,
                AsmToken.OPERAND,
                AsmToken.ADD,
                AsmToken.OPERAND,
                AsmToken.OPERAND
        );
        assertArrayEquals(correct.toArray(), this.result.toArray());
    }
    @Test
    @DisplayName("Definizione label non valida")
    public void testThrowsIfLabelIsInvalidLexeme(){
        String program = "label: label:";
        SourceScanner<?> scanner = new SourceScannerString(program);
        assertThrows(LexerException.class, () -> this.lexer.tokenize(scanner));
    }
    @Test
    @DisplayName("JMP tokenizzato correttamente")
    void testJmpWithLabelCorrect(){
        String program = "JMP label";
        SourceScanner<?> scanner = new SourceScannerString(program);
        this.result = this.lexer.tokenize(scanner);
        List<AsmToken> correct = List.of(
                AsmToken.JMP,
                AsmToken.LABEL
        );
        assertArrayEquals(correct.toArray(), this.result.toArray());
    }
    @Test
    @DisplayName("Definizione label tokenizzata correttamente")
    void testLabelDefinitionCorrect(){
        String program = "label:\n JMP label";
        SourceScanner<?> scanner = new SourceScannerString(program);
        this.result = this.lexer.tokenize(scanner);
        List<AsmToken> correct = List.of(
                AsmToken.LABEL_DEFINTION,
                AsmToken.JMP,
                AsmToken.LABEL
        );
        assertArrayEquals(correct.toArray(), this.result.toArray());
    }
}
