package Laboratorio.Ferramenta;

public abstract class Articolo {
	private final double prezzoUnitario;
	private int quantita;
	private final double um;

	public Articolo(double um, double prezzoUnitario, int quantita){
		if(prezzoUnitario <= 0) throw new IllegalArgumentException("Il prezzo non puo' essere minore di 0");
		if(quantita <= 0) throw new IllegalArgumentException("La quantita' non puo' essere minore di 0");
		if(um <= 0) throw new IllegalArgumentException("La misura non puo' essere minore di 0");
		this.prezzoUnitario = prezzoUnitario;
		this.quantita = quantita;
		this.um = um;
	}

	public double getPrezzoUnitario(){
		return this.prezzoUnitario;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public double getUm() {
		return um;
	}

	public double getTotal(){
		return this.getTotal(this.quantita);
	}
	public double getTotal(int qta){
		return this.getPrezzoUnitario() * qta;
	}

	/**
	 * Due articoli sono uguali se sono lo stesso tipo di articolo e hanno la stessa unita' di misura e lo stesso prezzo
	 * @param o articolo da confrontare
	 * @return true se i due articoli sono uguali, false altrimenti
	 */
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Articolo articolo = (Articolo) o;
		return Double.compare(articolo.um, um) == 0 && Double.compare(articolo.prezzoUnitario, prezzoUnitario) == 0;
	}
}
