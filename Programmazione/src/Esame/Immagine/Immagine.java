package Esame.Immagine;

public class Immagine {
	private boolean[][] pixels;

	public Immagine(int n) {
		if(n <= 0){
			throw new IllegalArgumentException("Dimensione immagine non valida");
		}
		this.pixels = new boolean[n][n];
	}

	/**
	 * Ritorna le dimensioni dell'immagine
	 * @return dimensioni dell'immagine
	 */
	public int getDimensione(){
		return this.pixels.length;
	}

	/**
	 * Ritorna il valore del pixel situato nell'indice (i,j)
	 * @param i primo indice
	 * @param j secondo indice
	 * @throws IllegalArgumentException se uno dei due indici è minore di 0 o superiore alla dimensione massima dell'immagine
	 * @return il valore del pixel situato nell'indice (i,j)
	 */
	public boolean getPixel(int i, int j){
		if(isOutOfBound(i, j)){
			throw new IllegalArgumentException("Indici non validi");
		}
		return this.pixels[i][j];
	}

	/**
	 * Imposta il valore del pixel situato nell'indice (i,j)
	 * @param i primo indice
	 * @param j secondo indice
	 * @param v valore da impostare
	 * @return true se il valore del pixel situato nell'indice (i,j) è stato impostato correttamente, false altrimenti
	 */
	public boolean setPixel(int i, int j, boolean v){
		if(isOutOfBound(i, j)) return false;
		this.pixels[i][j] = v;
		return true;
	}

	/**
	 * Genera una nuova Immagine come and dei valori di questa immagine e dell'immagine passata come parametro
	 * @param a Immagine su cui applicare l'and
	 * @return una nuova Immagine i cui valori sono dati dall'and tra questa Immagine e l'Immagine a
	 */
	public Immagine maschera(Immagine a){
		if(a.getDimensione() != this.getDimensione()){
			throw new IllegalArgumentException("Le dimensioni delle immagini non coincidono");
		}
		Immagine newImmagine = new Immagine(this.getDimensione());
		for(int i = 0; i < this.getDimensione(); i++){
			for(int j = 0; j < this.getDimensione(); j++){
				boolean pixelVal = this.getPixel(i, j) && a.getPixel(i, j);
				newImmagine.setPixel(i, j, pixelVal);
			}
		}
		return newImmagine;
	}

	/**
	 * Genera una nuova immagine come la negazione di questa
	 * @return Immagine con i valori negati
	 */
	public Immagine negativa(){
		Immagine newImmagine = new Immagine(this.getDimensione());
		for(int i = 0; i < this.getDimensione(); i++){
			for(int j = 0; j < this.getDimensione(); j++){
				newImmagine.setPixel(i, j, !this.getPixel(i, j));
			}
		}
		return newImmagine;
	}

	/**
	 * Conta il numero di pixel true che sono nel quadrato con centro r e c e lato 2k+1
	 * @param r primo centro
	 * @param c secondo centro
	 * @param k parametro del lato
	 * @throws IllegalArgumentException se il quadrato si trova fuori dall'immagine
	 * @return numero di pixel contenuti nel quadrato
	 */
	public int focus(int r, int c, int k){
		int side = 2*k+1;
		//controllo se le quattro coordinate del quadrato sono valide
		if(
			isOutOfBound(r - side, c - side) ||
			isOutOfBound(r - side, c + side) ||
			isOutOfBound(r + side, c - side) ||
			isOutOfBound(r + side, c + side)
		){
			throw new IllegalArgumentException("Coordinate quadrato non valide");
		}
		return side*side;
	}

	/**
	 * Controlla se la coppia di indici (i,j) è fuori dai limiti dell'immagine
	 * @param i primo indice
	 * @param j secondo indice
	 * @return true se la coppia è fuori dai limiti dell'immagine, false altrimenti
	 */
	private boolean isOutOfBound(int i, int j){
		if(i <= 0 || i >= this.getDimensione()) return true;
		if(j <= 0 || j >= this.getDimensione()) return true;
		return false;
	}
}
