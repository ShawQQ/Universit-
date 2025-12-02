package Laboratorio.Triangolo;

public class Triangolo {
    private final double l1;
    private final double l2;
    private final double l3;

    public Triangolo(double l1, double l2, double l3) {
        if(!isValid(l1, l2, l3)) throw new IllegalArgumentException("Lati non validi");
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
    }

    public double perimetro(){
        return l1+l2+l3;
    }
    public double semiperimetro(){
        return this.perimetro() / 2;
    }
    public double area(){
        return Math.sqrt(semiperimetro()*(semiperimetro() - l1)*(semiperimetro() - l2)*(semiperimetro() - l3));
    }

    private boolean isValid(double l1, double l2, double l3){
        if(l1 <= 0 || l2 <= 0 || l3 <= 0) return false;
        if(l1 + l2 < l3 || l2 + l3 < l1 || l1 + l3 < l2) return false;
        return true;
    }
}
