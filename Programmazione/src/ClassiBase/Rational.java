package ClassiBase;

public class Rational {
    private final int numerator;
    private final int denominator; //sempre > 0

    public Rational(){
        this(0, 1);
    }
    public Rational(int numerator){
        this(numerator, 1);
    }
    public Rational(int numerator, int denominator){
        //TODO: gestire errore denominatore = 0
        if(denominator < 0){
            numerator = -numerator;
            denominator = -denominator;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator(){
        return this.numerator;
    }
    public int getDenominator(){
        return this.denominator;
    }
    public double toDouble(){
        return (double) this.getNumerator() / this.getDenominator();
    }

    public Rational negate(){
        return new Rational(-this.getNumerator(), this.getDenominator());
    }
    public Rational inverse(){
        return new Rational(this.getDenominator(), this.getNumerator());
    }

    public Rational multiply(Rational other){
        return new Rational(
                this.getNumerator() * other.getNumerator(),
                this.getDenominator() * other.getDenominator()
        );
    }
    public Rational divide(Rational other){
        return this.multiply(other.inverse());
    }
    public Rational add(Rational other){
        return new Rational(
                this.getNumerator() * other.getDenominator() + other.getNumerator() * this.getDenominator(),
                this.getDenominator() * other.getNumerator()
        );
    }
    public Rational subtract(Rational other){
        return this.add(other.negate());
    }

    public Rational simplify(){
        int mcd = this.getMcd();
        return new Rational(this.getNumerator() / mcd, this.getDenominator() / mcd);
    }

    public int compare(Rational y){
        int first = this.getNumerator() * y.getDenominator();
        int second = this.getDenominator() * y.getNumerator();
        if(first == second) return 0;
        return first > second ? 1 : -1;
    }

    private int getMcd(){
        int a = Math.max(this.numerator, this.denominator);
        int b = Math.min(this.numerator, this.denominator);
        while(b != 0){
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    public String toString(){
        return this.getNumerator() + "/" + this.getDenominator();
    }
}
