package Tutorato.Settimana7;

public class CassaPerPagamenti {
    private double totalPagamenti;

    public void aggiungiPagamento(Pagamento p){
        if(p == null) throw new IllegalArgumentException("Pagamento non valido");
        this.addTotale(p.daiImporto());
    }

    public double calcolaTotale(){
        return this.totalPagamenti;
    }

    public void addTotale(double importo){
        this.totalPagamenti += importo;
    }
}
