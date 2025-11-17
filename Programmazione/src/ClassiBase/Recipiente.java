package ClassiBase;

public class Recipiente{
    private int volume;
    private int contenuto;

    public Recipiente(int quantita){
        this.volume = quantita;
        this.contenuto = 0;
    }

    public int getContenuto(){
        return this.contenuto;
    }
    public int getVolume(){
        return this.volume;
    }
    public int getCapacita(){
        return this.volume - this.contenuto;
    }

    public void aggiungi(int quantita){
        if(quantita < 0) throw new IllegalArgumentException("Quantità non valida");
        this.contenuto = Math.min(this.contenuto + quantita, this.volume);
    }
    public void rimuovi(int quantita){
        this.contenuto = Math.max(this.contenuto - quantita, 0);
    }
}
