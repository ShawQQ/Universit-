package universita.robot.language.implementation.generic.source;

public interface PositionedSourceScanner<S> extends SourceScanner<S> {
    int getLine();
}
