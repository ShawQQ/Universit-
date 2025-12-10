package Laboratorio.Cerchio;

public class Cerchio implements SuperficieChiusa {
    private Punto centro;
    private double raggio;

    public Cerchio(Punto centro, double raggio){
        if(centro == null) throw new IllegalArgumentException("Centro non valido");
        if(raggio <= 0) throw new IllegalArgumentException("Raggio non valido");
        this.centro = centro;
        this.raggio = raggio;
    }
    public Cerchio(double raggio){
        this(new Punto(0, 0), raggio);
    }

    public double getRaggio(){
        return this.raggio;
    }
    public Punto getCentro(){
        return this.centro;
    }
    public double getArea(){
        return Math.PI*Math.pow(this.raggio, 2);
    }
    public void move(double x, double y){
        this.centro.move(x, y);
    }

    public String toString(){
        return "Cerchio di raggio "+this.getRaggio()+"e centro "+this.getCentro();
    }
}
