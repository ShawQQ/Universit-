package universita.robot.language.implementation.generic.source;

public class PositionedSourceScannerString implements PositionedSourceScanner<String> {
    private final String source;
    private int line;
    private int pos;

    public PositionedSourceScannerString(String source) {
        this.source = source;
        this.line = 1;
        this.pos = 0;
    }

    @Override
    public String getSource() {
        return this.source;
    }

    @Override
    public char peek() {
        if (!canConsume()) throw new IllegalStateException("Stringa sorgente terminata");
        return this.source.charAt(this.pos);
    }

    @Override
    public void advance() {
        if(this.isNewLine(this.peek())) this.line++;
        this.pos++;
    }

    @Override
    public boolean isEndOfLine() {
        while(this.canConsume()){
            if(this.isNewLine(this.peek())) return true;
            this.advance();
        }
        return false;
    }

    private boolean isNewLine(char c) {
        return c == '\n';
    }

    @Override
    public boolean canConsume(){
        return this.pos < this.length();
    }

    @Override
    public int getLine() {
        return this.line;
    }

    private int length(){
        return this.getSource().length();
    }
}
