package Tutorato.Settimana7;

public class PagamentoPaypal extends Pagamento{
    private final String email;
    private final double commissione;
    public PagamentoPaypal(double importo, String email, double commissione) {
        super(importo);
        if(!isValidEmail(email)) throw new IllegalArgumentException("Email non valida");
        if(commissione < 0) throw new IllegalArgumentException("Commissione non valida");
        this.email = email;
        this.commissione = Math.min(commissione, importo);
    }

    private boolean isValidEmail(String email) {
        if(!email.contains("@")) return false;
        String domain = email.split("@")[1];
        return domain.split("\\.").length >= 2;
    }

    public PagamentoPaypal(double importo, String email){
        this(importo, email, 0);
    }

    @Override
    public double daiImporto() {
        return this.getImporto() * (1 + this.getCommissione() / 100);
    }

    public String getEmail() {
        return email;
    }

    public double getCommissione() {
        return commissione;
    }
}
