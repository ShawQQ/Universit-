package Laboratorio.Insiemi;

public class Insieme {
    private final int[] elements;
    private int currentNumberElements;

    public Insieme(int size){
        if(size <= 0) throw new IllegalArgumentException("");
        this.elements = new int[size];
        this.currentNumberElements = 0;
    }

    public int cardinalita(){
        return this.currentNumberElements;
    }
    private int get(int i){
        return this.elements[i];
    }
    public boolean add(int element){
        if(this.isFull()) return false;
        if(this.in(element)) return false;
        if(element <= 0) return false;
        this.elements[this.currentNumberElements++] = element;
        return true;
    }
    public Insieme unione(Insieme other){
        Insieme result = new Insieme(this.cardinalita() + other.cardinalita());
        for(int i = 0; i < this.cardinalita(); i++){
            result.add(this.get(i));
        }
        for(int i = 0; i < other.cardinalita(); i++){
            if(!result.in(other.get(i))){
                result.add(other.get(i));
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "{ ";
        for(int i = 0; i < this.cardinalita(); i++){
            result += this.get(i)+" ";
        }
        result += "}";
        return result;
    }
    public boolean in(int element){
        for(int i = 0; i < this.cardinalita(); i++){
            if(this.elements[i] == element) return true;
        }
        return false;
    }

    private boolean isFull(){
        return this.elements.length == this.cardinalita();
    }
}
