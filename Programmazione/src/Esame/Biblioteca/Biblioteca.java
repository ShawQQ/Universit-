package Esame.Biblioteca;

public class Biblioteca {
    private final Libro[] libri;
    private final Libro[] borrowed;
    private int currentLibri;
    private int currentBorrow;
    private final float mora;

    public Biblioteca(int max, float mora){
        if(max <= 0) throw new IllegalArgumentException("Numero massimo libri non valido");
        if(mora <= 0) throw new IllegalArgumentException("Mora non valida");
        this.libri = new Libro[max];
        this.borrowed = new Libro[max];
        this.mora = mora;
    }

    public boolean aggiungiLibro(Libro l){
        if(l == null) throw new IllegalArgumentException("Libro non puo essere null");
        if(this.isFull()) return false;
        this.libri[currentLibri++] = l;
        return true;
    }

    public String[][] daiTutti(){
        String[][] result = new String[this.currentLibri][];
        for(int i = 0; i < currentLibri; i++){
            Libro libro = this.libri[i];
            result[i] = new String[]{libro.getTitolo(), libro.getAutore()};
        }
        return result;
    }
    public boolean prestaLibro(String titolo, String autore){
        Libro l = new Libro(titolo, autore);
        if(this.contains(l) == 0) return false;
        if(this.available(l) == 0) return false;
        this.borrowed[currentBorrow++] = l;
        return true;
    }

    public float restituisciLibro(String titolo, String autore, int giorniDiRitardo){
        if(giorniDiRitardo < 0) throw new IllegalArgumentException("Giorni di ritardo non validi");
        Libro l = new Libro(titolo, autore);
        if(this.contains(l) == 0) return -1;
        if(this.available(l) > 0) return -1;
        restituisciLibro(l);
        return giorniDiRitardo * this.mora;
    }

    private void restituisciLibro(Libro l){
        int bookIndex = 0;
        while(bookIndex < this.currentBorrow && !this.borrowed[bookIndex].equals(l)){
            bookIndex++;
        }
        for(int i = bookIndex; i < this.currentBorrow - 1; i++){
            this.borrowed[i] = this.borrowed[i + 1];
        }
        this.currentBorrow--;
    }

    private int available(Libro l) {
        int counter = this.contains(l);
        for(int i = 0; i < this.currentBorrow; i++){
            if(this.borrowed[i].equals(l)) counter--;
        }
        return counter;
    }

    private int contains(Libro l) {
        int counter = 0;
        for(int i = 0; i < this.currentLibri; i++){
            if(libri[i].equals(l)) counter++;
        }
        return counter;
    }


    private boolean isFull(){
        return this.currentLibri == libri.length;
    }
}
