package Laboratorio;

public class Dado {
    private final int faces;
    private int lastFaceRoll;

    public Dado(int faces){
        if(faces < 4) throw new IllegalArgumentException("Numero di facce non valido");
        this.faces = faces;
    }

    public int getFaces(){
        return this.faces;
    }
    public int getLastFaceRoll(){
        return this.lastFaceRoll;
    }
    public int roll(){
        this.lastFaceRoll = (int)(Math.random() * faces)+1;
        return this.lastFaceRoll;
    }

    public String toString(){
        return ""+this.getLastFaceRoll();
    }
}
