package ClassiBase;

public class RecipienteConTappo extends Recipiente{
    private boolean aperto;

    public RecipienteConTappo(int quantita) {
        super(quantita);
        this.aperto = false;
    }

    public boolean getAperto(){
        return this.aperto;
    }
    public void setAperto(boolean aperto){
        this.aperto = aperto;
    }

    public void aggiungi(int quantita){
        if(this.getAperto()) super.aggiungi(quantita);
    }
    public void rimuovi(int quantita){
        if(this.getAperto()) super.rimuovi(quantita);
    }
}
