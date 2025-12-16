package Tutorato.Settimana7;

public abstract class Pagamento {
    private double importo;
    public Pagamento(double importo){
        if(!isValid(importo)) throw new IllegalArgumentException("Importo non valido");
        this.importo = importo;
    }

    public double getImporto() {
        return importo;
    }
    public void addImporto(double importo){
        if(!isValid(importo)) throw new IllegalArgumentException("Importo non valido");
        this.importo += importo;
    }

    public abstract double daiImporto();
    private boolean isValid(double importo){
        return importo > 0.01;
    }
}
