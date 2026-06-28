package universita.robot.language.implementation.generic;

import universita.robot.language.core.exception.ParserException;
import universita.robot.language.core.lexer.Token;
import universita.robot.language.core.parser.ASTNode;
import universita.robot.language.core.parser.Parser;
import universita.robot.language.core.parser.TokenScanner;

public interface PositionedParser<N extends ASTNode, T extends Token> extends Parser<N, T> {
    N parse(PositionedTokenScanner<T> scanner) throws ParserException;

    @Override
    default N parse(TokenScanner<T> scanner) throws ParserException{
        if(scanner instanceof PositionedTokenScanner<T>){
            PositionedTokenScanner<T> s = (PositionedTokenScanner<T>) scanner;
            return parse(s);
        }
        throw new ParserException("Scanner non valido per questo tipo di parser");
    }
}
