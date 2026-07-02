package universita.robot.vm.implementation;

import universita.robot.vm.core.InputOutput;

public class Register<V> implements InputOutput<V> {
    private V val;

    public Register(V defaultValue){
        this.val = defaultValue;
    }
    @Override
    public V read() {
        return this.val;
    }

    @Override
    public void write(V value) {
        this.val = value;
    }

    @Override
    public String toString() {
        return this.val.toString();
    }
}
