package Esame.Coda;

/**
 * Rappresenta una coda di Visita per con una capacità statica
 * @see Visita#Visita per implementazione degli elementi della coda
 */
public class Coda implements ICoda {
	private Visita[] queue;
	private int currentIndex;

	/**
	 * Instanzia una coda con capacità massima pari a n
	 * @param n capacità massima della coda
	 */
	public Coda(int n){
		if(n < 0){
			throw new RuntimeException("Capacità non valida");
		}
		this.queue = new Visita[n];
		this.currentIndex = 0;
	}

	public boolean inserimento(Visita v) {
		if(v == null || this.currentIndex == this.queue.length) return false;
		this.queue[this.currentIndex++] = v;
		return true;
	}

	public Visita estrazione() {
		if(this.currentIndex == 0) return null;
		Visita currentVisit = this.queue[0];
		this.cancellazione(currentVisit.getNome(), currentVisit.getCognome());
		return currentVisit;
	}

	public boolean cancellazione(String nome, String cognome) {
		Visita toSearch = new Visita(nome, cognome);
		int indexToRemove = this.getIndexOfVisita(toSearch);
		if(indexToRemove < 0) return false;
		this.eliminateAndReorderQueue(indexToRemove);
		return true;
	}

	public int getNumero() {
		return this.currentIndex;
	}

	private int getIndexOfVisita(Visita toSearch) {
		int index = -1;
		for(int i = 0; i < this.currentIndex; i++){
			if(this.queue[i].equals(toSearch)){
				index = i;
				break;
			}
		}
		return index;
	}

	//elimina l'elemento situato nell'indice start, spostando tutto gli elementi della coda di una posizione
	private void eliminateAndReorderQueue(int start){
		for(int i = start; i < this.currentIndex - 1; i++){
			this.queue[i] = this.queue[i + 1];
		}
		//l'ultimo elemento della coda diventa viene impostato a null, trovandosi ora nell'indice currentIndex - 1
		this.queue[currentIndex] = null;
		this.currentIndex--;
	}
}
