package Laboratorio.Piante;

public class Ornamentale extends Pianta implements Potabile{
    private Colore colore;
    public Ornamentale(int giorniDiInnaffiare, Colore colore) {
        super(giorniDiInnaffiare);
        if(colore == null) throw new IllegalArgumentException("");
        this.colore = colore;
    }

    @Override
    public void potare(int g) {

    }
}
