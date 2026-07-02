package universita.robot.vm.core;

public interface Context {
    void addObserver(Observer observer);
    void notifyObserver();
}
