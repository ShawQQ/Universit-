package Esame.Biblioteca;

public class Libro {
    private final String titolo;
    private final String autore;

    public Libro(String titolo, String autore) {
        if(titolo == null || titolo.isEmpty()) throw new IllegalArgumentException("Titolo non valido");
        if(autore == null || autore.isEmpty()) throw new IllegalArgumentException("Autore non valido");
        this.titolo = titolo;
        this.autore = autore;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return this.getAutore().equals(libro.getAutore()) && this.getTitolo().equals(libro.getTitolo());
    }

    @Override
    public int hashCode() {
        return getTitolo().hashCode() + getAutore().hashCode() + 17;
    }
}
