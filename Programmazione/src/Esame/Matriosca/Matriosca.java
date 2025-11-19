package Esame.Matriosca;

public class Matriosca {
	private float volume;
	private String name;
	private Matriosca contiene;

	/**
	 * Instanzia una nuova matriosca con volume v e nome n
	 * @param v volume della matriosca
	 * @param n nome della matriosca
	 */
	public Matriosca(float v, String n) {
		if(v <= 0){
			throw new IllegalArgumentException("Volume non valido");
		}
		if(n == null){
			throw new IllegalArgumentException("Il nome non puo' essere nullo");
		}
		this.volume = v;
		this.name = n;
	}

	/**
	 * Inserisce la matriosca s all'interno dell'oggetto
	 * @param s matriosca da inserire
	 * @return true se la matriosca è stata inserita correttamente, false altrimenti
	 */
	public boolean inserisci(Matriosca s){
		if(s == null || this.equals(s)) return false;
		if(this.hasSomethingInside()) return false;
		if(s.volumeTotale() >= this.getVolume()) return false;
		this.contiene = s;
		return true;
	}

	/**
	 * Ritorna il volume della matriosca
	 * @return volume della matriosca
	 */
	public float getVolume(){
		return this.volume;
	}

	/**
	 * Ritorna il volume totale della matriosca, ovvero il volume della matriosca + il volume totale della matriosca
	 * al suo interno (se presente)
	 * @return volume totale della matriosca
	 */
	public float volumeTotale(){
		float volume = this.volume;
		if(this.hasSomethingInside()){
			volume += this.contiene.volumeTotale();
		}
		return volume;
	}

	public String toString() {
		return this.name + (this.hasSomethingInside() ? (" " + this.contiene.toString()) : "");
	}

	/**
	 * Controlla se la matriosca ne contiene un'altra al suo interno
	 * @return se la matriosca ne contiene un'altra, false altrimenti
	 */
	private boolean hasSomethingInside(){
		return contiene != null;
	}
}
