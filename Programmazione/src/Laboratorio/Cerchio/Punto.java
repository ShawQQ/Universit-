package Laboratorio.Cerchio;

public class Punto {
    private double x;
    private double y;

    public Punto(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void move(double x, double y){
        this.x += x;
        this.y += y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return this.y;
    }

    public String toString(){
        return "("+this.getX()+", "+this.getY()+")";
    }
}
