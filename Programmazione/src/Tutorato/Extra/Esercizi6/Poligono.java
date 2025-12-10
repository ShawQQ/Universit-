package Tutorato.Extra.Esercizi6;

public class Poligono {
    // Un poligono nel piano cartesiano bidimensionale
    // possiede una lista di vertici di tipo Punto
    // obbligatoriamente passati nel costruttore
    // deve avere almeno tre vertici diversi tra loro
    private Punto[] vertici;

    public Poligono(Punto[] vertici) {
        // tutti i punti diversi tra loro e almeno tre
        if(vertici.length < 3) throw new IllegalArgumentException("I vertici devono essere almeno 3");
        for(int i = 0; i < vertici.length; i++){
            for(int j = i + 1; j < vertici.length; j++){
                if(vertici[j].equals(vertici[i])) throw new IllegalArgumentException("Non possono esserci punti uguali");
            }
        }
        this.vertici = vertici;
    }

    public Poligono(Segmento[] lati) {
        // tutti i punti diversi tra loro e almeno tre
        // inon deve essere possibile costruire un poligono con i lati passati
        // significa che mi aspetto che i lati siano consecutivi e che l'ultimo lato chiuda il poligono con il primo
        if(lati.length < 3) throw new IllegalArgumentException("I lati devono essere almeno 3");
        if(!lati[0].getInizio().equals(lati[lati.length - 1].getFine())) throw new IllegalArgumentException("Il poligono non e' chiuso");
        this.vertici = new Punto[lati.length];
        for(int i = 1; i < lati.length; i++){
            if(!lati[i].getInizio().equals(lati[i - 1].getFine())) throw new IllegalArgumentException("i lati non sono consecutivi");
            this.vertici[i - 1] = lati[i].getInizio();
        }
        this.vertici[this.numeroVertici() - 1] = lati[0].getInizio();
    }

    public double perimetro() {
        // restituisce il perimetro del poligono
        // calcolato come somma delle lunghezze dei segmenti tra i vertici consecutivi
        // e tra l'ultimo vertice e il primo
        double perimetro = 0;
        Segmento[] lati = this.getLati();
        for(int i = 0; i < lati.length; i++){
            perimetro += lati[i].lunghezza();
        }
        return perimetro;
    }

    public Segmento[] getLati() {
        // restituisce un array di Segmento che rappresentano i lati del poligono
        Segmento[] segmenti = new Segmento[this.numeroVertici()];
        for(int i = 1; i < this.numeroVertici(); i++){
            segmenti[i - 1] = new Segmento(
                    new Punto(this.vertici[i - 1].getX(), this.vertici[i - 1].getY()),
                    new Punto(this.vertici[i].getX(), this.vertici[i].getY())
            );
        }
        segmenti[this.numeroVertici() - 1] = new Segmento(
                new Punto(this.vertici[this.numeroVertici() - 1].getX(), this.vertici[this.numeroVertici() - 1].getY()),
                new Punto(this.vertici[0].getX(), this.vertici[0].getY())
        );
        return segmenti;
    }

    public int numeroVertici() {
        // restituisce il numero di vertici del poligono
        return this.vertici.length;
    }

    public boolean isEquilatero() {
        // restituisce true se il poligono è equilatero (tutti i lati uguali), false altrimenti
        Segmento[] lati = this.getLati();
        for(int i = 1; i < lati.length; i++){
            if(!lati[i].equals(lati[i-1])) return false;
        }
        return true;
    }
}
