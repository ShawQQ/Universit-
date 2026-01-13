package Esame.Cavallo;

public class CorsaDiCavalli {
	private boolean hasFinished;
	private boolean hasStarted;
	private final Cavallo[] cavalli;
	private final float[] currentDistance;
	private int currentCavalli;
	private final float length;

	/**
	 * Instanzia una nuova corsa di cavalli. Una corsa di cavalli &egrave; caratterizzata da
	 * <ul>
	 *     <li>I cavalli che la corrono</li>
	 *     <li>La sua lunghezza</li>
	 *     <li>Il suo stato(gara iniziata, gara finita)</li>
	 * </ul>
	 * Il costruttore accetta due parametri: un intero per definire quanti cavalli al
	 * massimo possono partecipare a questa gara e un float per definire la lunghezza del percorso.
	 * @param maxCavalli numero massimo di cavalli che possono partecipare
	 * @param length lunghezza del percorso.
	 */
	public CorsaDiCavalli(int maxCavalli, float length){
		if(maxCavalli <= 0) throw new IllegalArgumentException("Numero cavalli non valido");
		if(length <= 0) throw new IllegalArgumentException("Lunghezza percorso non valida");
		this.length = length;
		this.cavalli = new Cavallo[maxCavalli];
		this.currentDistance = new float[maxCavalli];
		this.currentCavalli = 0;
	}

	public boolean garaIniziata(){
		return this.hasStarted;
	}
	public boolean garaFinita(){
		return this.hasFinished;
	}
	public float getLength(){
		return this.length;
	}

	/**
	 * Aggiungi, se possibile, un cavallo alla corsa attuale. Un cavallo pu&ograve; venire aggiunto se:
	 * <ul>
	 *     <li>La gara non &egrave; gi&agrave; iniziata</li>
	 *     <li>La gara non risulta piena</li>
	 *     <li>Il cavallo non &egrave; gi&agrave; presente all'interno della gara</li>
	 * </ul>
	 * @param c cavallo da aggiungere
	 * @throws IllegalArgumentException se c &egrave; null o la gara &egrave; gi&grave; iniziata
	 * @return true se il cavallo &egrave; stato aggiunto, false altrimenti
	 */
	public boolean aggiungiCavallo(Cavallo c){
		if(c == null) throw new IllegalArgumentException("Cavallo non valido");
		if(this.garaIniziata()) throw new IllegalArgumentException("La gara e' gia' iniziata");
		if(this.isFull()) return false;
		if(this.contains(c.getNome()) != -1) return false;
		this.cavalli[currentCavalli++] = c;
		c.setNumeroPartecipazioni(c.getNumeroPartecipazioni() + 1);
		return true;
	}

	/**
	 * Avanza un cavallo nel percorso di gara. Se la gara non &egrave; iniziata, la inizia. Se il cavallo supera
	 * il traguardo la conclude
	 * @param nomeCavallo cavallo da avanzare
	 * @param distanza percorsa dal cavallo
	 * @throws IllegalArgumentException se il cavallo non &egrave; presente, se la gara &egrave; finita o se la distanza
	 * &egrave; minore o uguale a 0
	 */
	public void avanzaCavallo(String nomeCavallo, float distanza){
		int cavalloIndex = this.contains(nomeCavallo);
		if(cavalloIndex == -1) throw new IllegalArgumentException("Cavallo non presente");
		if(this.garaFinita()) throw new IllegalArgumentException("La gara e' finita");
		if(distanza <= 0) throw new IllegalArgumentException("Distanza non valida");
		this.currentDistance[cavalloIndex] += distanza;
		if(!this.garaIniziata()){
			this.hasStarted = true;
		}
		if(this.currentDistance[cavalloIndex] >= this.getLength()){
			this.hasFinished = true;
			this.cavalli[cavalloIndex].setNumeroVittorie(this.cavalli[cavalloIndex].getNumeroVittorie() + 1);
		}
	}

	private boolean isFull() {
		return this.currentCavalli == cavalli.length;
	}

	/**
	 * Controlla se un cavallo &egrave; presente all'interno della gara, e nel caso ritorna il suo indice
	 * @param nomeCavallo nome del cavallo
	 * @return indice del cavallo se presente, -1 altrimenti
	 */
	private int contains(String nomeCavallo){
		for(int i = 0; i < this.currentCavalli; i++){
			if(this.cavalli[i].getNome().equals(nomeCavallo)) return i;
		}
		return -1;
	}
}
