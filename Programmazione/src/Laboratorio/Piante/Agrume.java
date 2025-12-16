package Laboratorio.Piante;

public class Agrume extends Pianta implements Potabile{
    private int acidita;
    public Agrume(int giorniDiInnaffiare, int acidita) {
        super(giorniDiInnaffiare);
        if(acidita <= 0) throw new IllegalArgumentException();
        this.acidita = acidita;
    }

    @Override
    public void potare(int g) {

    }
}
