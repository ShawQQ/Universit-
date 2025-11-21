package Esame.Agenda;

/**
 * Rappresenta un appuntamento, identificato dal nome, giorno e ora. Il giorno è un intero 1<=giorno<=365, l'ora è un inte
 * ro 0<ora<23. Nome, giorno e ora non sono modificabili una volta instanziato l'oggetto
 */
public class Appuntamento {
	private final String nome;
	private final int giorno;
	private final int ora;

	public Appuntamento(String nome, int giorno, int ora){
		if(nome == null) throw new RuntimeException("Nome non valido");
		if(giorno < 1 || giorno > 365) throw new RuntimeException("Giorno non valido");
		if(ora < 0 || ora > 23) throw new RuntimeException("Ora non valida");
		this.nome = nome;
		this.giorno = giorno;
		this.ora = ora;
	}

	public String getNome(){
		return this.nome;
	}

	public int getGiorno() {
		return giorno;
	}

	public int getOra() {
		return ora;
	}

	public int crono(){
		return (this.getGiorno() - 1) * 24 + this.getOra();
	}

	public String toString() {
		return "Nome: "+this.getNome()+"\nGiorno: "+this.getGiorno()+"\nOra: "+this.getOra();
	}

	/**
	 * Controlla se questo appuntamento viene cronologicamente dopo un altro
	 * @param appointment da confrontare
	 * @return true se questo appuntamento viene cronologicamente dopo, false altrimenti
	 */
	public boolean isNext(Appuntamento appointment) {
		if(this.getGiorno() > appointment.getGiorno()) return true;
		if(this.getGiorno() == appointment.getGiorno() && this.getOra() > appointment.getOra()) return true;
		return false;
	}
}
