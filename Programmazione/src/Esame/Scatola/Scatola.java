package Esame.Scatola;

public class Scatola {
    private final Scatola[] scatole;
    private final float volume;
    private int currentScatole;

    public Scatola(float v, int n){
        if(v <= 0){
            throw new IllegalArgumentException("Volume non valido");
        }
        if(n <= 0){
            throw new IllegalArgumentException("Numero di scatole non valido");
        }
        this.volume = v;
        this.scatole = new Scatola[n];
        this.currentScatole = 0;
    }

    public int numero(){
        return this.currentScatole;
    }
    public float getVolume(){
        return this.volume;
    }
    public Scatola[] getScatole(){
        return this.scatole;
    }
    public boolean aggiungi(Scatola s){
        Scatola[] currentScatole = this.getScatole();
        if(s == null || s.equals(this)){
            return false;
        }
        if(this.numero() == currentScatole.length || this.libero() == 0){
            return false;
        }
        this.scatole[this.currentScatole++] = s;
        return true;
    }

    public float libero(){
        float totalOccupied = 0;
        Scatola[] currentScatole = this.getScatole();
        for(int i = 0; i < this.numero(); i++){
            totalOccupied += currentScatole[i].getVolume();
        }
        float result = this.getVolume() - totalOccupied;
        return result > Double.MIN_VALUE ? result : 0;
    }

    public String toString(){
        return this.numero() + " " + this.getVolume();
    }

    public boolean equals(Object s){
        if(s == null) return false;
        if(!(s instanceof Scatola)) return false;
        Scatola o = (Scatola)s;
        return o.scatole.length == this.scatole.length;
    }
}
