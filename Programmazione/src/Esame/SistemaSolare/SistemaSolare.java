package Esame.SistemaSolare;

public class SistemaSolare {
	private Pianeta[] pianeti;
	private int currentNumberOfPianeti;

	public SistemaSolare(int n){
		if(n <= 0) throw new IllegalArgumentException("Numero pianeti non valido");
		this.pianeti = new Pianeta[n];
		this.currentNumberOfPianeti = 0;
	}

	/**
	 * Aggiunge un nuovo pianeta al sistema solare, nella posizione corrispondente seguendo l'ordinamento per distanza
	 * dalla stella.
	 * @param p Il pianeta da aggiungere
	 * @return true se il pianeta viene aggiunto correttamente, false altrimenti
	 */
	public boolean nuovo(Pianeta p){
		if(p == null || this.isFull()) return false;
		this.pianeti[this.currentNumberOfPianeti++] = p;
		this.sort();
		return true;
	}
	public Pianeta getPianeta(int n){
		if(n < 0 || n >= this.getNumero()) return null;
		return this.pianeti[n];
	}

	private boolean isFull(){
		return this.pianeti.length == this.getNumero();
	}

	public int getNumero() {
		return currentNumberOfPianeti;
	}
	public Pianeta getMaxPianeta(){
		if(this.getNumero() == 0) return null;
		Pianeta max = this.getPianeta(0);
		for(int i = 1; i < this.getNumero(); i++){
			Pianeta current = this.getPianeta(i);
			if(max.getMassa() < current.getMassa()){
				max = current;
			}
		}
		return max;
	}

	/**
	 * Ordina il sistema solare secondo la distanza della stella. L'ordinamento &grave; crescente, la stella pi&ugrave;
	 * vicina si trover&agrave; nella posizione 0 dell'array. Essendo l'array ordinato a ogni inserimento, l'unico ele
	 * mento che non si trover&agrave; nella posizione corretta sar&agrave; sempre e solamente l'ultimo elemento
	 * dell'array.
	 */
	private void sort(){
		int insertedIndex = this.getNumero() - 1;
		int compareIndex = insertedIndex - 1;
		Pianeta toOrder = this.getPianeta(insertedIndex);
		Pianeta last = this.getPianeta(compareIndex);
		while(last != null && toOrder.compare(last) < 0){
			this.swap(insertedIndex, compareIndex);
			insertedIndex--;
			compareIndex--;
			last = this.getPianeta(compareIndex);
		}
	}

	private void swap(int i, int j) {
		Pianeta tmp = this.getPianeta(i);
		this.pianeti[i] = this.pianeti[j];
		this.pianeti[j] = tmp;
	}
}
