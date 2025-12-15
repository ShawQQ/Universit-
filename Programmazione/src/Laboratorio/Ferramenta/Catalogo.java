package Laboratorio.Ferramenta;

public class Catalogo {
	private Articolo[] articoli;
	private int currentArticoli;

	public Catalogo(){

	}
	public Catalogo(Articolo[] articoli){
		if(articoli == null || articoli.length == 0) throw new IllegalArgumentException("Articoli non validi");
		this.articoli = articoli;
		this.currentArticoli = articoli.length;
	}
	public Catalogo(int n){
		if(n <= 0) throw new IllegalArgumentException("Numero massimo articoli non valido");
		this.articoli = new Articolo[n];
		this.currentArticoli = 0;
	}


	public int getNumeroArticoli() {
		return this.currentArticoli;
	}

	public double valore(){
		double total = 0;
		for(int i = 0; i < this.getNumeroArticoli(); i++){
			total += this.articoli[i].getTotal();
		}
		return total;
	}

	/**
	 * Aggiunge un articolo al catalogo. Ritorna true se l'articolo viene aggiunto correttamente. Se l'articolo è già
	 * presente all'interno del catalogo, viene aumentata la quantita. Se il catalogo risulta pieno, l'articolo non viene
	 * aggiunto e viene ritornato false. Se l'articolo è null viene lanciata una NullPointerException
	 * @param articolo articolo da aggiungere
	 * @throws NullPointerException se articolo è null
	 * @return true se l'articolo viene aggiunto correttamente, false altrimenti
	 */
	public boolean caricamento(Articolo articolo){
		if(articolo == null) throw new NullPointerException("Articolo non puo' essere null");
		int articoloIndex = this.contains(articolo);
		if(articoloIndex != -1){
			this.articoli[articoloIndex].updateQuantita(articolo.getQuantita());
		}else{
			if(this.isFull()) return false;
			this.articoli[this.currentArticoli++] = articolo;
		}
		return true;
	}

	/**
	 * Rimuove un articolo dal catalogo, ritornando il totale della vendita, ovvero la quantita dell'articolo * il prezzo
	 * unitario. Se l'articolo non è presente all'interno del catalogo, viene lanciata una IllegalArgumentException.
	 * Se la quantita' richiesta dell'articolo supera quella attualmente presente all'interno dell'articolo, viene lanciata
	 * una IllegalArguementException. Se l'articolo è null, viene lanciata una NullPointerException.
	 * @param articolo articolo da rimuovere
	 * @throws NullPointerException se l'articolo è null
	 * @throws IllegalArgumentException se l'articolo non è presente all'interno del catalogo o se la quantita' richiesta
	 * supera quella disponibile
	 * @return il totale della vendita
	 */
	public double vendita(Articolo articolo){
		if(articolo == null) throw new NullPointerException("Articolo non puo' essere null");
		int articoloIndex = this.contains(articolo);
		if(articoloIndex == -1) throw new IllegalArgumentException("L'articolo non è presente in catalogo");
		Articolo art = this.articoli[articoloIndex];
		if(art.getQuantita() < articolo.getQuantita())
			throw new IllegalArgumentException("La quantita richiesta non è disponibile");
		double total = art.getTotal(articolo.getQuantita());
		art.updateQuantita(-articolo.getQuantita());
		if(art.getQuantita() == 0){
			this.removeElement(articoloIndex);
		}
		return total;
	}

	/**
	 * Rimuove l'articolo presente in posizione i
	 * @param articoloIndex indice dell'elemento da rimuovere
	 */
	private void removeElement(int articoloIndex) {
		for(int i = articoloIndex; i < this.getNumeroArticoli() - 1; i++){
			this.articoli[i] = this.articoli[i + 1];
		}
		this.currentArticoli--;
	}

	/**
	 * Controlla se un articolo è già presente all'interno del catalogo. Se l'articolo è presente viene ritornato l'indice
	 * dove si trova, altrimenti viene ritornato -1
	 * @param articolo da controllare
	 * @return l'indice dell'articolo se presente, -1 altrimenti
	 */
	private int contains(Articolo articolo) {
		for(int i = 0; i < this.currentArticoli; i++){
			if(this.articoli[i].equals(articolo)) return i;
		}
		return -1;
	}

	/**
	 * Dice se il catalogo è pieno, ovvero se non possono essere piu' aggiunti altri elementi
	 * @return true se il catalogo è pieno, false altrimenti
	 */
	public boolean isFull(){
		return this.articoli.length == this.currentArticoli;
	}
}
