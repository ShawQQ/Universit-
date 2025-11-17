package Hereditary;

public abstract class Figura {
    private final double x;
    private final double y;

    public Figura(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public abstract double area();
    public abstract double perimetro();
}
