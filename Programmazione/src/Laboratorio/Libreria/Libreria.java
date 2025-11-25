package Laboratorio.Libreria;

public class Libreria {
	private Libro[] books;
	private int currentBooks;
	public Libreria(int n){
		if(n <= 0) throw new IllegalArgumentException("Dimensione libreria non valida");
		this.books = new Libro[n];
	}

	public int maxSize(){
		return this.books.length;
	}
	public int currentSize(){
		return this.currentBooks;
	}
	public boolean isFull(){
		return this.currentSize() == this.maxSize();
	}
	public Libro getBook(int i) {
		if(i < 0 || i >= this.currentSize()) throw new IllegalArgumentException("Indice non valido");
		return this.books[i];
	}
	public boolean setBook(Libro l){
		if(l == null || this.isFull()) return false;
		this.books[this.currentBooks++] = l;
		return true;
	}
	public Libro search(String title){
		for(int i = 0; i < this.currentSize(); i++){
			if(this.getBook(i).getTitle().equals(title)) return this.getBook(i);
		}
		return null;
	}
	public Libro search(Libro l){
		for(int i = 0; i < this.currentSize(); i++){
			if(this.getBook(i).equals(l)) return this.getBook(i);
		}
		return null;
	}
	public String toString(){
		String fullName = "";
		for(int i = 0; i < this.currentSize(); i++){
			fullName += this.getBook(i)+"\n";
		}
		return fullName;
	}
}
