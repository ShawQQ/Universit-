package Hereditary;

public class Elisse extends Figura{
    private final double semMin;
    private final double semMax;
    public Elisse(double x, double y, double semMin, double semMax) {
        super(x, y);
        this.semMax = semMax;
        this.semMin = semMin;
    }
    public double getSemiAsseMinore(){
        return this.semMin;
    }
    public double getSemiAsseMaggiore(){
        return this.semMax;
    }
    public double area() {
        return Math.PI * this.getSemiAsseMaggiore() * this.getSemiAsseMinore();
    }
    public double perimetro() {
        return 2 * Math.PI * Math.sqrt((Math.pow(this.getSemiAsseMaggiore(), 2) + Math.pow(this.getSemiAsseMinore(), 2)) / 2);
    }
}
