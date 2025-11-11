package ClassiBase;

public class Complex {
    private final double real;
    private final double imaginary;

    public Complex(){
        this(0, 0);
    }

    public Complex(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal(){
        return this.real;
    }
    public double getImaginary(){
        return this.imaginary;
    }

    public Complex add(Complex other){
        return new Complex(
        this.getReal() + other.getReal(),
    this.getImaginary() + other.getImaginary()
        );
    }
    public Complex substraction(Complex other){
        return this.add(other.negation());
    }
    public Complex negation(){
        return new Complex(-this.getReal(), -this.getImaginary());
    }
    public Complex multiply(Complex other){
        double real = (this.getReal() * other.getReal()) - (this.getImaginary() * other.getImaginary());
        double imaginary = (this.getImaginary() * other.getReal()) + (this.getReal() * other.getImaginary());
        return new Complex(real, imaginary);
    }
    public Complex division(Complex other){
        return this.multiply(other.reversal());
    }
    public double module(){
        return Math.sqrt(this.getQuadraticSum());
    }
    public Complex reversal(){
        return new Complex(
        this.getReal() / this.getQuadraticSum(),
    this.getImaginary() / this.getQuadraticSum()
        );
    }
    public Complex conjugate(){
        return new Complex(this.getReal(), -this.getImaginary());
    }

    private double getQuadraticSum(){
        return this.getReal() * this.getReal() + this.getImaginary() * this.getImaginary();
    }
    public String toString(){
        String imaginarySign = this.getImaginary() >= 0 ? "+" : "-";
        return this.getReal() + imaginarySign + Math.abs(this.getImaginary()) + "i";
    }
}
