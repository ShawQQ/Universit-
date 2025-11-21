package Esame.Ramo;

import java.util.Arrays;

/**
 * Rappresenta un ramo con una lunghezza specificata e un numero di sottorami collegati
 */
public class Ramo {
	public float lunghezza;
	private Ramo[] rami;
	private int totalRami = 0;
	public Ramo(float v, int n){
		if(v <= 0) throw new IllegalArgumentException("Lunghezza ramo non valido");
		if(n <= 0) throw new IllegalArgumentException("Numero di rami non valido");

		this.lunghezza = v;
		this.rami = new Ramo[n];
		this.totalRami = 0;
	}

	/**
	 * Aggiungi un sottoramo al ramo corrente. Un ramo non può essere sottoramo di sé stesso.
	 * @param s sottoramo da aggiungere
	 * @return true se il ramo è stato aggiunto correttamente, false se:
	 * -Il sottoramo e il ramo sono lo stesso oggetto
	 * -Se è stato raggiunto il numero massimo di sottorami
	 * -Se la lunghezza del sottoramo è maggiore del ramo padre
	 */
	public boolean aggiungi(Ramo s){
		//due rami sono uguali se sono lo stesso oggetto, per cui l'equals di Object è sufficiente
		if(
			s == null ||
			this.equals(s) ||
			this.currentNumberOfRami() == this.maxNumberOfRami() ||
			this.getLunghezza() < s.getLunghezza()
		){
			return false;
		}
		this.rami[this.totalRami++] = s;
		return true;
	}

	/**
	 * Lunghezza totale del ramo, ovvero la sua lunghezza + la lunghezza totale di tutti i suoi sottorami
	 * @return lunghezza totale del ramo
	 */
	public float lunghezzaTotale(){
		float sum = this.getLunghezza();
		for(int i = 0; i < this.currentNumberOfRami(); i++){
			sum += this.rami[i].lunghezzaTotale();
		}
		return sum;
	}

	public float getLunghezza(){
		return this.lunghezza;
	}

	public String toString() {
		return this.currentNumberOfRami() + " " + this.getLunghezza();
	}

	private int currentNumberOfRami(){
		return this.totalRami;
	}
	private int maxNumberOfRami(){
		return this.rami.length;
	}
}
