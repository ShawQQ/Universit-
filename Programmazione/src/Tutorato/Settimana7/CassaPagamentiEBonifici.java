package Tutorato.Settimana7;

public class CassaPagamentiEBonifici extends CassaPerPagamenti {
    private String iban;
    public CassaPagamentiEBonifici(String iban){
        if(!PagamentoBonifico.isValidIban(iban)) throw new IllegalArgumentException("Bonifico non valido");
        this.iban = iban;
    }

    public PagamentoBonifico faiBonifico(double importo){
        if(this.calcolaTotale() < importo) throw new IllegalArgumentException("Importo bonifico non valido");
        this.addTotale(-importo);
        return new PagamentoBonifico(importo, this.iban);
    }
}
