package Hereditary;

public class Counter {
    private int counter;

    public int getCounter(){
        return this.counter;
    }
    public void setCounter(int counter){
        this.counter = counter;
    }
    public int getNext(){
        return this.counter++;
    }
}
