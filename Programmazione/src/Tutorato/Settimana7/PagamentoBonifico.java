package Tutorato.Settimana7;

public class PagamentoBonifico extends Pagamento{
    private final String iban;
    private final boolean isIstantaneo;
    public PagamentoBonifico(double importo, String iban) {
        this(importo, iban, false);
    }
    public PagamentoBonifico(double importo, String iban, boolean isIstantaneo){
        super(importo);
        if(!isValidIban(iban)) throw new IllegalArgumentException("Iban non valido");
        this.iban = iban;
        this.isIstantaneo = isIstantaneo;
    }

    public static boolean isValidIban(String iban) {
        if(iban == null) return false;
        if(iban.length() != 27) return false;
        if(!(iban.startsWith("IT"))) return false;
        if(!Character.isLetter(iban.charAt(4))) return false;
        for(int i = 2; i < iban.length(); i++){
            if(i == 4) continue;
            if(Character.isLetter(iban.charAt(i))) return false;
        }
        return true;
    }

    @Override
    public double daiImporto() {
        return this.isIstantaneo ? this.getImporto() : this.getImporto() * 1.10;
    }

    public String getIban() {
        return iban;
    }
}
