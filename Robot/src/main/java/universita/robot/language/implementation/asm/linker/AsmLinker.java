package universita.robot.language.implementation.asm.linker;

import universita.robot.language.core.exception.LinkerException;
import universita.robot.language.core.linker.Linker;
import universita.robot.language.implementation.asm.parser.node.AsmASTNode;
import universita.robot.language.implementation.asm.parser.node.AsmInstructionNode;
import universita.robot.language.implementation.asm.parser.node.AsmJumpTargetNode;
import universita.robot.language.implementation.asm.parser.node.AsmStatementNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AsmLinker implements Linker<AsmASTNode.AsmProgramNode> {
    private AsmASTNode.AsmProgramNode root;
    private Map<String, Integer> labels;
    public AsmLinker(){
        this.labels = new HashMap<>();
    }
    @Override
    public AsmASTNode.AsmProgramNode link(AsmASTNode.AsmProgramNode root) {
        this.root = root;
        this.labels = collectLabel();
        List<AsmStatementNode> resolved = this.resolveStatement();
        return new AsmASTNode.AsmProgramNode(resolved);
    }

    private List<AsmStatementNode> resolveStatement() {
        return this.root.nodes().stream()
                .filter(AsmInstructionNode.class::isInstance)
                .map(instr -> this.resolveInstruction((AsmInstructionNode)instr))
                .toList();
    }

    private AsmStatementNode resolveInstruction(AsmInstructionNode instr) {
        return switch(instr){
            case AsmInstructionNode.AsmBinaryInstructionNode binary -> binary;
            case AsmInstructionNode.AsmJumpInstructionNode jmp ->
                    new AsmInstructionNode.AsmJumpInstructionNode(this.resolveJump(jmp));
        };
    }

    private AsmJumpTargetNode resolveJump(AsmInstructionNode.AsmJumpInstructionNode jmp) {
        return switch(jmp.t()){
            case AsmJumpTargetNode.AsmLabelReferenceNode ref -> this.resolveJumpReference(ref);
            case AsmJumpTargetNode.AsmLabelResolvedNode _ ->
                    throw new IllegalStateException("JMP già risolti");
        };
    }

    private AsmJumpTargetNode resolveJumpReference(AsmJumpTargetNode.AsmLabelReferenceNode ref) {
        Integer i = this.labels.get(ref.name());
        if(i == null) throw this.createLinkerError("Label non definita: %s".formatted(ref.name()));
        return new AsmJumpTargetNode.AsmLabelResolvedNode(i);
    }

    private Map<String, Integer> collectLabel() {
        int i = 0;
        Map<String, Integer> found = new HashMap<>();
        for(AsmStatementNode statementNode : this.root.nodes()){
            switch(statementNode){
                case AsmInstructionNode _ -> i++;
                case AsmStatementNode.AsmLabelDefinitionNode label -> {
                    if(found.containsKey(label.label()))
                        throw this.createLinkerError("Incontrata label duplicata");
                    found.put(label.label(), i);
                }
            }
        }
        return found;
    }

    private LinkerException createLinkerError(String msg) {
        return new LinkerException(msg);
    }
}
