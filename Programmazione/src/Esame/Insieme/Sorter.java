package Esame.Insieme;

/**
 * Definisce un generico algoritmo di sorting
 */
public interface Sorter {
	/**
	 * Ordina l'array dato considerando solo i primi n elementi
	 * @param toSort array da ordinare
	 * @param n numero di elementi da considerare
	 */
	public void sort(int[] toSort, int n);
}
