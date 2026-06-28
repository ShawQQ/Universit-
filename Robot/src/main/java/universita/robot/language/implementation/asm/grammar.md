Program           ::= Statement

Statement         ::= LabelDefinition | Instruction

LabelDefinition   ::= LABEL_DEFINITION

Instruction       ::= BinaryInstruction | JumpInstruction

BinaryInstruction ::= BinaryOperator Operand Operand

BinaryOperator     ::= ADD

JumpInstruction   ::= JMP JumpTarget

JumpTarget        ::= LABEL

Operand           ::= OPERAND