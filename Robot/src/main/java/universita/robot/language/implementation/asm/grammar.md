Program           ::= Statement

Statement         ::= LabelDefinition | Instruction

LabelDefinition   ::= LABEL_DEFINITION

Instruction       ::= BinaryInstruction | JumpInstruction

BinaryInstruction ::= BinaryOperator WritableOperand Operand

BinaryOperator     ::= ADD

JumpInstruction   ::= JMP JumpTarget

JumpTarget        ::= LABEL

WritableOperand   ::= REGISTER

Operand           ::= REGISTER | LITERAL