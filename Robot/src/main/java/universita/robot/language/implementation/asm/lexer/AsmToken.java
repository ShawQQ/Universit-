package universita.robot.language.implementation.asm.lexer;

import universita.robot.language.core.lexer.Token;

public sealed interface AsmToken extends Token
        permits AsmToken.Add, AsmToken.Jmp,
                AsmToken.Operand, AsmToken.Label, AsmToken.LabelDefinition {

    record Add() implements AsmToken {}
    record Jmp() implements AsmToken {}
    record Operand<V extends AsmOperandValue>(V value) implements AsmToken {}
    record Label(String name) implements AsmToken {}
    record LabelDefinition(String name) implements AsmToken {}
}
