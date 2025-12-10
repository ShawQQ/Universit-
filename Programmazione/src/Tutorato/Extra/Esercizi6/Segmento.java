package Tutorato.Extra.Esercizi6;

public class Segmento {
    // Un segmento nel piano cartesiano bidimensionale
    // possiede due estremi di tipo Punto
    // obbligatoriamente passati nell'unico costruttore
    // i punti devono essere diversi tra loro e non nulli
    private Punto inizio;
    private Punto fine;

    public Segmento(Punto inizio, Punto fine) {
        if(inizio == null) throw new IllegalArgumentException("Punto iniziale non puo' essere null");
        if(fine == null) throw new IllegalArgumentException("Punto finale non puo' essere null");
        if(inizio.equals(fine)) throw new IllegalArgumentException("I due punti non posso essere uguali");
        // inizializza gli estremi del segmento
        this.inizio = inizio;
        this.fine = fine;
    }

    public double lunghezza() {
        // restituisce la lunghezza del segmento calcolata con la formula della distanza euclidea
        return Math.sqrt(Math.pow(this.fine.getX() - this.inizio.getX(),2) + Math.pow(this.fine.getY() - this.inizio.getY(),2)); // placeholder
    }

    public Punto getInizio() {
        // restituisce il punto iniziale del segmento
        return this.inizio; // placeholder
    }

    public Punto getFine() {
        // restituisce il punto finale del segmento
        return this.fine; // placeholder
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Segmento segmento = (Segmento) o;
        return Punto.doubleEquals(this.lunghezza(), segmento.lunghezza());
    }
}
