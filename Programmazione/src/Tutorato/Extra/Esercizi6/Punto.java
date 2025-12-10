package Tutorato.Extra.Esercizi6;

public class Punto {
    // Un punto nel piano cartesiano bidimensionale
    // possiede due coordinate: x e y di tipo double
    // che espone tramite i metodi getX() e getY()
    private double x;
    private double y;

    public Punto(double x, double y) {
        // inizializza le coordinate del punto
        this.x = x;
        this.y = y;
    }

    public double getX() {
        // restituisce la coordinata x del punto
        return this.x; // placeholder
    }

    public double getY() {
        // restituisce la coordinata y del punto
        return this.y; // placeholder
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Punto punto = (Punto) o;
        return Punto.doubleEquals(this.getX(), ((Punto) o).getX()) && Punto.doubleEquals(this.getY(), ((Punto) o).getY());
    }

    public static boolean doubleEquals(double a, double b) {
        // **ATTENZIONE**
        // metodo di utilità per confrontare due valori double
        // considerando una tolleranza di 1e-9
        // USATE QUESTO METODO PER I CONFRONTI TRA DOUBLE NELLE VOSTRE IMPLEMENTAZIONI
        // invece di fare confronti diretti con ==
        // si chiama così da qualunque punto del codice: Punto.doubleEquals(a, b)
        return Math.abs(a - b) < 1e-9;
    }
}
