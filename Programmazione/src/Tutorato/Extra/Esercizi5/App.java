package Tutorato.Extra.Esercizi5;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    /**
     * ---- prima parte del compito ----
     * Osserva la classe Treno e crea altre classi simili per rappresentare altri mezzi di trasporto,
     * 1. Auto (con attributi come targa String, modello String, numero di porte int, capacità del serbatoio float)
     * 2. Aereo (con attributi come codiceAereo String, modelloAereo String, numeroPosti int, autonomiaVolo int)
     * 3. Nave (con attributi come nomeNave String, tipoNave String, tonnellaggio int, numeroCabine int)
     * 
     * ---- seconda parte del compito ----
     * Crea nella classe App i seguenti metodi:
     * 1. un metodo creaAuto che accetta i parametri necessari per creare un'istanza di Auto e la restituisce.
     * 2. un metodo naveNonNull che accetta una istanza di Nave come parametro e torna true se l'istanza non è null, altrimenti false.
     * 3. un metodo raggruppaAerei che prende in input due istanze di Aereo e le restituisce in un array di Aereo.
     * 
     * ATTENZIONE non è necessario implementare i metodi, basta solo scrivere la firma e gestire il return con valori di default.
     */



    /**
     * ---- metodo creaTreno di esempio ----
     * @param codiceTreno
     * @param modelloTreno
     * @param numeroCarrozze
     * @param numeroPosti
     * @return
     */
    public Treno creaTreno(String codiceTreno, String modelloTreno, int numeroCarrozze, int numeroPosti) {
        Treno trenoCreato = new Treno(codiceTreno, modelloTreno, numeroCarrozze, numeroPosti);
        return trenoCreato;
    }
}