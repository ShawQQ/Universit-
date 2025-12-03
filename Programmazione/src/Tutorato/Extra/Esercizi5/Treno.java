package Tutorato.Extra.Esercizi5;

public class Treno {

    private String codiceTreno;
    private String modelloTreno;
    private int numeroCarrozze;
    private int numeroPosti;

    public Treno(String codiceTreno, String modelloTreno, int numeroCarrozze, int numeroPosti) {
        if(codiceTreno == null || codiceTreno.isEmpty()) {
            throw new IllegalArgumentException("Codice treno non può essere nullo o vuoto");
        }
        if(modelloTreno == null || modelloTreno.isEmpty()) {
            throw new IllegalArgumentException("Modello treno non può essere nullo o vuoto");
        }
        if(numeroCarrozze <= 0) {
            throw new IllegalArgumentException("Numero di carrozze deve essere maggiore di zero");
        }
        if(numeroPosti <= 0) {
            throw new IllegalArgumentException("Numero di posti deve essere maggiore di zero");
        }
        // la keyword this viene utilizzata per distinguere tra gli attributi della classe
        // e i parametri del costruttore che hanno lo stesso nome
        this.codiceTreno = codiceTreno;
        this.modelloTreno = modelloTreno;
        this.numeroCarrozze = numeroCarrozze;
        this.numeroPosti = numeroPosti;
    }

}
