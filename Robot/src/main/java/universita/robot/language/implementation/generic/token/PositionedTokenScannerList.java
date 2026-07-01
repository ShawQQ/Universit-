package universita.robot.language.implementation.generic.token;

import universita.robot.language.core.lexer.Token;

import java.util.List;

public class PositionedTokenScannerList<T extends Token> implements PositionedTokenScanner<T> {
    private final List<PositionedToken<T>> tokens;
    private int pos;

    public PositionedTokenScannerList(List<PositionedToken<T>> tokens) {
        if(tokens == null) throw new IllegalArgumentException("Lista token nulla");
        this.tokens = tokens;
        this.pos = 0;
    }

    @Override
    public T peek() {
        if(!this.canConsume()) throw new IllegalStateException("Lista token esaurita");
        return this.tokens.get(this.pos).token();
    }

    @Override
    public void advance() {
        if(!this.canConsume()) throw new IllegalStateException("Lista token esaurita");
        this.pos++;
    }

    @Override
    public boolean canConsume() {
        return this.pos < this.tokens.size();
    }

    @Override
    public int getLine() {
        if(!this.canConsume()) throw new IllegalStateException("Lista token esaurita");
        return this.tokens.get(this.pos).line();
    }
}
