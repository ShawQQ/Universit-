package Esame.Coda;

/**
 * Rappresenta una visita identificata dalla coppia (nome, cognome)
 */
public class Visita {
	private final String nome;
	private final String cognome;

	public Visita(String nome, String cognome){
		if(nome == null || nome.length() < 2){
			throw new RuntimeException("Nome non valido");
		}
		if(cognome == null || cognome.length() < 2){
			throw new RuntimeException("Cognome non valido");
		}
		this.nome = nome;
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	/**
	 * Due visite si considerano uguali quando hanno lo stesso nome e cognome
	 * @param v visita da paragonare
	 * @return true se le due visite hanno lo stesso nome e cognome
	 * @return false se le due visiste hanno nome o cognome diverso
	 */
	public boolean equals(Object v){
		if(v == null) return false;
		if(!(v instanceof Visita)) return false;
		Visita o = (Visita)v;
		return o.getCognome().equals(this.getCognome()) && o.getNome().equals(this.getNome());
	}
}
