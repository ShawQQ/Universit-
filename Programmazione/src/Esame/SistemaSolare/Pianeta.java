package Esame.SistemaSolare;

public class Pianeta {
	private final String nome;
	private final double massa;
	private final double distanza;

	public Pianeta(String nome, double massa, double distanza) {
		if(nome == null) throw new IllegalArgumentException("Nome non valido");
		if(massa <= 0) throw new IllegalArgumentException("Massa non valida");
		if(distanza <= 0) throw new IllegalArgumentException("Distanza non valida");
		this.nome = nome;
		this.massa = massa;
		this.distanza = distanza;
	}

	public String getNome() {
		return nome;
	}

	public double getMassa() {
		return massa;
	}

	public double getDistanza() {
		return distanza;
	}

	/**
	 * Compara la distanza tra due pianeti.
	 * @param other pianeta da confrontare
	 * @return
	 * <ul>
	 * 	<li>0 se la distanza tra i due pianeti &grave; uguale</li>
	 * 	<li>1 se questo pianeta &grave; pi&ugrave; distante del pianeta passato come argomento</li>
	 * 	<li>-1 se questo pianeta &grave; meno distante del pianeta passato come argomento</li>
	 * </ul>
	 */
	public int compare(Pianeta other){
		return Double.compare(this.getDistanza(), other.getDistanza());
	}


	@Override
	public String toString() {
		return "Pianeta{" +
				"nome='" + nome + '\'' +
				", massa=" + massa +
				", distanza=" + distanza +
				'}';
	}
}
