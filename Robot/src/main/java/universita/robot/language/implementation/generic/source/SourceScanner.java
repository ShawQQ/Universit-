package universita.robot.language.implementation.generic.source;

public interface SourceScanner<S> {
    S getSource();
    char peek();
    void advance();
    boolean canConsume();
    boolean isEndOfLine();
}
