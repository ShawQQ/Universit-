package universita.robot.language.implementation.asm;

import universita.robot.language.core.lexer.Token;

public enum AsmToken implements Token {
    ADD,
    JMP,
    OPERAND,
    LABEL_DEFINTION,
    LABEL,
}
