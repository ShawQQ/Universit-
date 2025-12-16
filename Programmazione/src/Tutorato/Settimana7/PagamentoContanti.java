package Tutorato.Settimana7;

public class PagamentoContanti extends Pagamento{
    public PagamentoContanti(double importo) {
        super(importo);
    }

    @Override
    public double daiImporto() {
        double cent = this.getCentFromImport();
        return cent > 0.5 ? cent : Math.floor(this.getImporto());
    }

    private double getCentFromImport() {
        return (int)this.getImporto() - this.getImporto();
    }
}
