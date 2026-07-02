package universita.robot.vm.core;

@FunctionalInterface
public interface Observer {
    void notify(Context ctx);
}
