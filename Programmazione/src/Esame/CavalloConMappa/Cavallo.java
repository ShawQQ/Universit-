package Esame.CavalloConMappa;

public class Cavallo {
	private final String nome;
	private int eta;
	private int numeroVittorie;
	private int numeroPartecipazioni;

	/**
	 * Instanzia un nuovo cavallo. Un cavallo &grave; identificato unicovamente dal suo nome, che deve essere pi&ugrave;
	 * lungo di 4 lettere e pu&ograve; contenere solo caratteri alfabetici. Inoltre un cavallo &egrave; caratterizzato
	 * dalle seguente propriet&agrave;
	 * <ul>
	 *     <li>Et&agrave; del cavallo, che non pu&ograve; essere minore di 5</li>
	 *     <li>Il numero di partecipazioni</li>
	 *     <li>Il numero di vittorie</li>
	 * </ul>
	 * @param nome del cavallo
	 * @param eta del cavallo
	 * @param numeroVittorie numero di vittorie del cavallo
	 * @param numeroPartecipazioni numero di partecipazioni del cavallo
	 * @throws IllegalArgumentException se l'et&agrave; o il nome non sono validi
	 */
	public Cavallo(String nome, int eta, int numeroVittorie, int numeroPartecipazioni){
		if(eta < 5) throw new IllegalArgumentException("Eta non valida");
		if(numeroPartecipazioni < 0) throw new IllegalArgumentException("Numero partecipazioni non valida");
		if(numeroVittorie < 0) throw new IllegalArgumentException("Numero vittorie non valido");
		if(!isValidName(nome)) throw new IllegalArgumentException("Nome non valido");
		this.nome = nome;
		this.eta = eta;
		this.numeroVittorie = numeroVittorie;
		this.numeroPartecipazioni = numeroPartecipazioni;
	}

	public String getNome(){
		return this.nome;
	}
	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public int getNumeroVittorie() {
		return numeroVittorie;
	}

	public void setNumeroVittorie(int numeroVittorie) {
		this.numeroVittorie = numeroVittorie;
	}

	public int getNumeroPartecipazioni() {
		return numeroPartecipazioni;
	}

	public void setNumeroPartecipazioni(int numeroPartecipazioni) {
		this.numeroPartecipazioni = numeroPartecipazioni;
	}

	/**
	 * Fornisce il tasso di vittoria del cavallo in centesimi
	 * @return tasso di vittoria del cavallo in centesimi
	 */
	public float tassoDiVittoria(){
		if(this.getNumeroPartecipazioni() == 0) return 0;
		return (float)this.getNumeroVittorie() / this.getNumeroPartecipazioni() * 100;
	}

	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Cavallo cavallo = (Cavallo) o;
		return this.getNome().equals(cavallo.getNome());
	}

	public int hashCode() {
		return this.getNome().hashCode();
	}

	private boolean isValidName(String nome) {
		if(nome == null) return false;
		if(nome.length() < 4) return false;
		for(int i = 0; i < nome.length(); i++){
			if(!Character.isAlphabetic(nome.charAt(i))) return false;
		}
		return true;
	}
}
