package universita.robot.language.core.compiler;

import universita.robot.language.core.exception.LanguageException;
import universita.robot.language.core.parser.ASTNode;
import universita.robot.language.implementation.asm.lexer.AsmLexer;
import universita.robot.language.implementation.asm.lexer.AsmToken;
import universita.robot.language.implementation.asm.linker.AsmLinker;
import universita.robot.language.implementation.asm.parser.AsmParser;
import universita.robot.language.implementation.asm.parser.node.AsmASTNode;
import universita.robot.language.implementation.asm.parser.node.AsmStatementNode;
import universita.robot.language.implementation.generic.source.PositionedSourceScanner;
import universita.robot.language.implementation.generic.source.PositionedSourceScannerString;
import universita.robot.language.implementation.generic.token.PositionedToken;
import universita.robot.language.implementation.generic.token.PositionedTokenScanner;
import universita.robot.language.implementation.generic.token.PositionedTokenScannerList;
import universita.robot.language.implementation.generic.token.TokenScanner;

import java.util.List;

public final class CompilerFactory {
    private CompilerFactory() {}

    public static Compiler<String, AsmStatementNode> forAsm(){
        return CompilerFactory::compileAsm;
    }
    private static ExecutableProgram<AsmStatementNode> compileAsm(String source){
        if(source == null) throw new NullPointerException("Source null");
        try{
            AsmLexer lexer = new AsmLexer();
            AsmParser parser = new AsmParser();
            AsmLinker linker = new AsmLinker();

            List<PositionedToken<AsmToken>> tokens = lexer.tokenize(new PositionedSourceScannerString(source));
            PositionedTokenScanner<AsmToken> tokenScanner = new PositionedTokenScannerList<>(tokens);
            AsmASTNode.AsmProgramNode result = linker.link(parser.parse(tokenScanner));
            return new ListExecutableProgram<>(result.nodes());
        }catch(LanguageException e){
            throw e;
        }
    }
}
