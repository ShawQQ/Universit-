package Tutorato.Settimana7;

public class App {
    public static void main(String[] args) throws Exception {

        /*** Decommenta per testare la tua implementazione ***/


        CassaPerPagamenti cassa = new CassaPerPagamenti();
        PagamentoBonifico bonifico = new PagamentoBonifico(100.0, "IT60X0542811101000000123456", false);
        PagamentoPaypal paypal = new PagamentoPaypal(50.0, "email@unica.it", 2.0);
        PagamentoContanti contanti = new PagamentoContanti(20.49);
        cassa.aggiungiPagamento(bonifico);
        cassa.aggiungiPagamento(paypal);
        cassa.aggiungiPagamento(contanti);
        System.out.println("Totale pagamenti: " + cassa.calcolaTotale());
        System.out.println("Totale pagamenti atteso: 181.0!");

    }
}