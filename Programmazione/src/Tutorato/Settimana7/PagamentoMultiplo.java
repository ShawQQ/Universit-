package Tutorato.Settimana7;

public class PagamentoMultiplo extends Pagamento{
    public PagamentoMultiplo(Pagamento[] pagamenti) {
        super(0);
        if(pagamenti == null || pagamenti.length == 0) throw new IllegalArgumentException("Array pagamenti non validi");
        for(int i = 0; i < pagamenti.length; i++){
            this.addImporto(pagamenti[i].daiImporto());
        }
    }

    @Override
    public double daiImporto() {
        return super.getImporto();
    }
}
