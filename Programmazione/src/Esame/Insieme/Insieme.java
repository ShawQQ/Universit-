package Esame.Insieme;

/**
 * Rappresenta un insieme finito di numeri interi. L'insieme non permette l'inserimento di valori duplicati. Dopo ogni
 * inserzione, l'insieme viene ordinato in ordine crescente.
 */
public class Insieme {
	private int[] values;
	private int totalElements;
	private Sorter sorter;
	/**
	 * Instazia un nuovo insieme con al più n elementi
	 * @throws RuntimeException se il parametro n è negativo
	 * @param n numero di elementi dell'insieme
	 */
	public Insieme(int n){
		if(n < 0) throw new RuntimeException("n non puo' essere negativo");
		this.values = new int[n];
		this.totalElements = 0;
		this.sorter = new SelectionSorter();
	}

	public int dimensioneTotale(){
		return this.values.length;
	}
	public int dimensione(){
		return this.totalElements;
	}

	/**
	 * Aggiunge un elemento x all'insieme. Dopo che l'elemento è stato aggiunto, l'insieme viene ordinato in ordine
	 * crescente
	 * @param x elemento da aggiungere
	 * @return true se l'elemento e' stato aggiunto con successo, false altrimenti
	 */
	public boolean aggiungi(int x){
		//non avremo mai il caso totalElements > this.values.length
		if(this.dimensione() == this.dimensioneTotale()) return false;
		if(this.contiene(x)) return false;
		this.values[totalElements++] = x;
		this.sorter.sort(this.values, totalElements);
		return true;
	}

	/**
	 * Rimuove, se presento, l'intero x dall'insieme.
	 * @param x elemento da rimuovere
	 * @return true se l'elemento è stato rimosso con successo, false altrimenti
	 */
	public boolean rimuovi(int x){
		int elementIndex = this.search(x);
		if(elementIndex == -1) return false;
		//mantenendo l'insieme ordinato dopo ogni inserimento possiamo semplicemente spostare gli elementi a sinistra
		//di una posizione
		for(int i = elementIndex; i < this.dimensione() - 1; i++){
			this.values[i] = this.values[i + 1];
		}
		this.totalElements--;
		return true;
	}

	public boolean contiene(int x) {
		return this.search(x) != -1;
	}

	/**
	 * Effettua l'intersezione di due insiemi
	 * @param that insieme su cui effettuare l'intersezione
	 * @return un nuovo insieme dato dall'intersezione di questo insieme e dall'insieme dato come parametro
	 */
	public Insieme intersezione(Insieme that){
		Insieme newInsieme = new Insieme(Math.max(this.values.length, that.values.length));
		for(int i = 0; i < Math.min(this.totalElements, that.totalElements); i++){
			if(that.contiene(this.values[i])){
				newInsieme.aggiungi(this.values[i]);
			}
		}
		return newInsieme;
	}

	/**
	 * Effettua l'unione di due insiemi
	 * @param that insieme su cui effettuare l'unione
	 * @return un nuovo insieme dato dall'unione di questo insieme e dall'insieme dato come parametro
	 */
	public Insieme unione(Insieme that){
		Insieme newInsieme = new Insieme(this.values.length + that.values.length);
		newInsieme.aggiungiArray(this.values, this.totalElements);
		newInsieme.aggiungiArray(that.values, that.totalElements);
		return newInsieme;
	}

	/**
	 * effettua la ricerca dell'elemento x all'interno dell'insieme. Mantenendo sempre l'insieme ordinato, si può
	 * effettuare una ricerca binaria al posto di scorrere l'intero insieme
	 * @param x elemento da cercare
	 * @return l'indice in cui è situato l'elemento x se presente, -1 altrimenti
	 */
	private int search(int x) {
		//se non ci sono elementi nell'insieme la ricerca andrà sicuramente a vuoto
		if(totalElements == 0) return -1;
		int i = 0;
		int j = totalElements - 1;
		int middle = (i+j) / 2;
		while(i != j && this.values[middle] != x){
			if(this.values[middle] < x){
				i = middle + 1;
			}else{
				j = middle - 1;
			}
			middle = (i+j)/2;
		}
		return this.values[middle] == x ? middle : -1;
	}

	/**
	 * Aggiunge i primi n elementi di un array all'insieme
	 * @param add array di elementi da aggiungere
	 * @param n numero di elementi da aggiungere
	 * @return true se tutti gli elementi sono stati inseriti, false altrimenti
	 */
	private boolean aggiungiArray(int[] add, int n){
		for(int i = 0; i < n; i++){
			boolean result = this.aggiungi(add[i]);
			if(!result) return false;
		}
		return true;
	}
}
