package Laboratorio.Lotteria;

public class Biglietto {
    private static int currentNumber = 0;
    private final int number;
    private final String name;

    public Biglietto(){
        this("");
    }
    public Biglietto(String name){
        Biglietto.currentNumber++;
        this.name = name;
        this.number = currentNumber;
    }

    public static int getCurrentNumber() {
        return currentNumber;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return this.name+": "+this.number;
    }
}
