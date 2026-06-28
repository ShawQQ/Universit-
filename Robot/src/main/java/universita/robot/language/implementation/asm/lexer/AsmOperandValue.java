package universita.robot.language.implementation.asm.lexer;

public sealed interface AsmOperandValue
        permits AsmOperandValue.Register, AsmOperandValue.Literal{
    record Register(String name) implements AsmOperandValue {}
    record Literal(int value) implements AsmOperandValue {}
}
