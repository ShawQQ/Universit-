package Laboratorio.Piante;

public abstract class Pianta {
    private int giorniDiInnaffiare;

    public Pianta(int giorniDiInnaffiare){
        if(giorniDiInnaffiare <= 0) throw new IllegalArgumentException("");
        this.giorniDiInnaffiare = giorniDiInnaffiare;
    }
}
