package universita.robot.vm.core;

public interface InputOutput<V> {
    V read();
    void write(V value);
}
