package Laboratorio.Libreria;

public class Libro {
	private final String title;
	private final String author;
	private final int pageNumber;
	private final double price;

	public Libro(String title, String author, int pageNumber, double price) {
		if(title == null || title.isEmpty() || author == null || author.isEmpty() || pageNumber <= 0 || price < 0){
			throw new IllegalArgumentException("Parametri non validi");
		}
		this.title = title;
		this.author = author;
		this.pageNumber = pageNumber;
		this.price = price;
	}
	public String getTitle(){
		return this.title;
	}
	public String getAuthor(){
		return this.author;
	}
	public int getPageNumber(){
		return this.pageNumber;
	}
	public double getPrice() {
		return this.price;
	}

	public double priceByPage(){
		return this.pageNumber / this.price;
	}

	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || this.getClass() != o.getClass()) return false;
		Libro libro = (Libro) o;
		return 	title.equals(libro.getTitle()) &&
				author.equals(libro.getAuthor());
	}

	public String toString() {
		return this.getTitle() + " - "+this.getAuthor() + ", " + this.getPageNumber()+"pp, "+this.getPrice()+"€";
	}
}
