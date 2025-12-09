package Tutorato.Settimana6;

public class Stanza {
    private final float altezza;
    private final float lunghezza;
    private final float larghezza;
    private final int finestre;
    private final int porte;
    private final int preseDiCorrente;
    private final boolean acquaCorrente;
    private final boolean accessoEsterno;

    public Stanza(
            float altezza,
            float lunghezza,
            float larghezza,
            int porte,
            int finestre,
            int preseDiCorrente,
            boolean acquaCorrente,
            boolean accessoEsterno
    ) {
        if(porte <= 0) throw new IllegalArgumentException("Numero porte non valido");
        if(altezza <= 0) throw new IllegalArgumentException("Altezza non valida");
        if(lunghezza <= 0) throw new IllegalArgumentException("Lunghezza non valida");
        if(larghezza <= 0) throw new IllegalArgumentException("Larghezza non valida");
        this.altezza = altezza;
        this.lunghezza = lunghezza;
        this.larghezza = larghezza;
        this.finestre = finestre;
        this.porte = porte;
        this.preseDiCorrente = preseDiCorrente;
        this.acquaCorrente = acquaCorrente;
        this.accessoEsterno = accessoEsterno;
    }

    public Stanza(float altezza, float lunghezza, float larghezza, int porte){
        this(altezza, lunghezza, larghezza, porte, 0);
    }
    public Stanza(float altezza, float lunghezza, float larghezza, int porte, int finestre){
        this(altezza, lunghezza, larghezza, porte, finestre, 0);
    }
    public Stanza(float altezza, float lunghezza, float larghezza, int porte, int finestre, int preseDiCorrente){
        this(altezza, lunghezza, larghezza, porte, finestre, preseDiCorrente, false);
    }
    public Stanza(float altezza, float lunghezza, float larghezza, int porte, int finestre, int preseDiCorrente, boolean acquaCorrente){
        this(altezza, lunghezza, larghezza, porte, finestre, preseDiCorrente, acquaCorrente, false);
    }

    public float getAltezza() {
        return altezza;
    }

    public float getLunghezza() {
        return lunghezza;
    }

    public float getLarghezza() {
        return larghezza;
    }

    public int getFinestre() {
        return finestre;
    }

    public int getPorte() {
        return porte;
    }

    public int getPreseDiCorrente() {
        return preseDiCorrente;
    }

    public boolean isAcquaCorrente() {
        return acquaCorrente;
    }

    public boolean isAccessoEsterno() {
        return accessoEsterno;
    }
    /**
     * Una stanza ha le seguenti proprietà, definite dal costruttore
     * altezza - float
     * lunghezza - float
     * larghezza - float
     * n finestre - int
     * n porte - int
     * prese di corrente - int
     * accesso ad acqua corrente - boolean
     * accesso ad esterno - boolean
     * 
     * definire il costruttore tenendo a mente questi vincoli:
     * le dimensioni float > 0
     * n porte > 0
     * 
     * una volta creata una stanza, questa non è più modificabile.
     * tutte le proprietà sono private, ma espone x ciascuna di essa un getter
     */
}
