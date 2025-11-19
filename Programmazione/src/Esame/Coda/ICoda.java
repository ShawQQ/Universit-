package Esame.Coda;

/**
 * Rappresenta una coda di Visita
 * @see Visita#Visita per implementazione degli elementi della coda
 */
public interface ICoda {
	/**
	 * Inserisce una visita in fonda alla coda
	 * @param v Visita da inserire
	 * @return true se la visita è stata inserita con successo
	 * @return false se la coda è piena e la nuova visita non può essere inserita
	 */
	boolean inserimento (Visita v);

	/**
	 * Rimuove la prima visita dalla coda e la restituisce
	 * @return il primo elemento della coda se presente
	 * @return null se la coda è vuota
	 */
	Visita estrazione();

	/**
	 * Cancella la prenotazione, se presente, basandosi su nome e cognome
	 * @param nome della visita da eliminare
	 * @param cognome della visita da eliminare
	 * @return true se la visita è presente ed è stata elimina con successo
	 * @return false se la visita non è presente
	 */
	boolean cancellazione(String nome, String cognome);

	/**
	 * Restituisce il numero di visite attualmente presenti nella coda
	 * @return il numero di visite attualmente presenti nella coda
	 */
	int getNumero();
}
