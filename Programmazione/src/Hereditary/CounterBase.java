package Hereditary;

public class CounterBase extends Counter{
    private final int base;

    public CounterBase(int base){
        this.base = base;
    }

    public int getBase(){
        return this.base;
    }

    public int getNext(){
        int counter = this.getCounter();
        if(counter == this.getBase()) this.setCounter(0);
        return super.getNext();
    }
}
