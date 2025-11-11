package ClassiBase;

public class ContoCorrente {
    private double saldo;
    private double maxSaldo;

    public ContoCorrente(double startSaldo){
        this.saldo = startSaldo;
        this.maxSaldo = startSaldo;
    }

    public void deposita(double qty){
        this.saldo += qty;
        if(this.saldo > this.maxSaldo) {
            this.maxSaldo = this.saldo;
        }
    }
    public void preleva(double qty){
        if(qty > this.saldo) return;
        this.saldo -= qty;
    }
    public double getSaldo(){
        return this.saldo;
    }
    public double getSaldoMassimo(){
        return this.maxSaldo;
    }
}
