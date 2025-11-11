package ClassiBase;

public class Recipiente {
    private int volume;
    private int contenuto;
    private boolean aperto;

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
        if(!this.aperto) return;
        this.contenuto = Math.min(this.contenuto + quantita, this.volume);
    }
    public void rimuovi(int quantita){
        if(!this.aperto) return;
        this.contenuto = Math.max(this.contenuto - quantita, 0);
    }

    public void apri(){
        this.aperto = true;
    }
    public void chiudi(){
        this.aperto = false;
    }
}
