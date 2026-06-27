package universita.robot.language.core.lexer;

public class SourceScannerString implements SourceScanner<String> {
    private final String source;
    private int line;
    private int pos;

    public SourceScannerString(String source) {
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
        this.pos++;
    }

    @Override
    public boolean canConsume(){
        return this.pos < this.length();
    }

    @Override
    public int getLine() {
        return this.line;
    }

    @Override
    public void incrementLine() {
        this.line++;
    }

    private int length(){
        return this.getSource().length();
    }
}
