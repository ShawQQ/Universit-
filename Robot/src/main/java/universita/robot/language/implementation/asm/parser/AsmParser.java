package universita.robot.language.implementation.asm.parser;

import universita.robot.language.core.exception.ParserException;
import universita.robot.language.implementation.asm.lexer.AsmOperandValue;
import universita.robot.language.implementation.asm.parser.node.*;
import universita.robot.language.implementation.generic.PositionedParser;
import universita.robot.language.implementation.generic.PositionedTokenScanner;
import universita.robot.language.implementation.asm.lexer.AsmToken;

import java.util.ArrayList;
import java.util.List;

public class AsmParser implements PositionedParser<AsmASTNode.AsmProgramNode, AsmToken> {
    private PositionedTokenScanner<AsmToken> scanner;
    @Override
    public AsmASTNode.AsmProgramNode parse(PositionedTokenScanner<AsmToken> scanner) throws ParserException {
        this.scanner = scanner;
        AsmASTNode.AsmProgramNode program;
        try{
             program = this.parseProgram();
        }catch(ParserException e){
            throw e;
        }
        if(this.scanner.canConsume()){
            throw new ParserException("Token in eccesso dopo termine programma", scanner.getLine());
        }
        return program;
    }

    /**
     * Program ::= Statement
     */
    private AsmASTNode.AsmProgramNode parseProgram() throws ParserException {
        List<AsmStatementNode> statements = new ArrayList<>();
        while(this.scanner.canConsume()){
            statements.add(this.parseStatement());
            this.scanner.advance();
        }
        return new AsmASTNode.AsmProgramNode(statements);
    }

    /**
     * Statement ::= LabelDefinition | Instruction
     */
    private AsmStatementNode parseStatement() throws ParserException {
        AsmToken token = this.scanner.peek();
        return switch(token){
            case AsmToken.LabelDefinition t -> this.parseLabelDefinition();
            case AsmToken.Add _,
                 AsmToken.Jmp _ -> this.parseInstruction();
            case AsmToken.Label _,
                 AsmToken.Operand<?> _ -> throw this.createParseError();
        };
    }

    /**
     * Instruction ::= BinaryInstruction | JumpInstruction
     */
    private AsmInstructionNode parseInstruction() throws ParserException{
        AsmToken token = this.scanner.peek();
        return switch(token){
            case AsmToken.Add _ -> this.parseBinaryInstruction();
            case AsmToken.Jmp _ -> this.parseJmpInstruction();
            case AsmToken.Label _,
                 AsmToken.LabelDefinition _,
                 AsmToken.Operand<?> _ -> throw this.createParseError();
        };
    }

    /**
     * JumpInstruction ::= JMP JumpTarget
     */
    private AsmInstructionNode parseJmpInstruction() throws ParserException {
        AsmToken token = this.scanner.peek();
        if(!(token instanceof AsmToken.Jmp)) throw this.createParseError();
        this.scanner.advance();
        return new AsmInstructionNode.AsmJumpInstructionNode(this.parseJumpTarget());
    }

    /**
     * JumpTarget ::= LABEL
     */
    private AsmJumpTargetNode parseJumpTarget() throws ParserException {
        AsmToken token = this.scanner.peek();
        return switch(token){
            case AsmToken.Label label -> new AsmJumpTargetNode.AsmLabelRefenceNode(label.name());
            case AsmToken.Add _,
                 AsmToken.Jmp _,
                 AsmToken.LabelDefinition _,
                 AsmToken.Operand<?> _ -> throw this.createParseError();
        };
    }

    /**
     * BinaryInstruction ::= BinaryOperator Operand Operand
     */
    private AsmInstructionNode.AsmBinaryInstructionNode parseBinaryInstruction() throws ParserException {
        AsmBinaryOperatorNode o = this.parseBinaryOperator();
        this.scanner.advance();
        AsmOperandNode l = this.parseOperand();
        this.scanner.advance();
        AsmOperandNode r = this.parseOperand();
        this.scanner.advance();
        return new AsmInstructionNode.AsmBinaryInstructionNode(o, l, r);
    }

    /**
     * BinaryOperator ::= ADD
     */
    private AsmBinaryOperatorNode parseBinaryOperator() throws ParserException {
        AsmToken token = this.scanner.peek();
        return switch(token){
            case AsmToken.Add _ -> new AsmBinaryOperatorNode.AsmAddNode();
            case AsmToken.Jmp _,
                 AsmToken.Label _,
                 AsmToken.LabelDefinition _,
                 AsmToken.Operand<?> _ -> throw this.createParseError();
        };
    }

    /**
     * LabelDefinition   ::= LABEL_DEFINITION
     */
    private AsmStatementNode.AsmLabelDefinitionNode parseLabelDefinition() throws ParserException {
        if(!(this.scanner.peek() instanceof AsmToken.LabelDefinition token)) throw this.createParseError();
        return new AsmStatementNode.AsmLabelDefinitionNode((token.name()));
    }

    /**
     * Operand ::= OPERAND
     */
    private AsmOperandNode parseOperand() throws ParserException {
        if(!(this.scanner.peek() instanceof AsmToken.Operand<?> token)) throw this.createParseError();
        return switch(token.value()){
            case AsmOperandValue.Register r -> new AsmOperandNode.AsmRegisterOperand(r.name());
            case AsmOperandValue.Literal  l -> new AsmOperandNode.AsmLiteralOperand(l.value());
        };
    }

    private ParserException createParseError() {
        return new ParserException("Errore parsing", this.scanner.getLine());
    }
}
