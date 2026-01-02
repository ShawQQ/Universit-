package Esame.Mondo;

public class Portale {
	private final Mondo from;
	private final Mondo to;
	private final String id;

	public Portale(Mondo from, Mondo to){
		if(from == null) throw new IllegalArgumentException("Partenza non valida");
		if(to == null) throw new IllegalArgumentException("Arrivo non valido");
		if(from.equals(to)) throw new IllegalArgumentException("I due mondi non possono coincidere");
		this.from = from;
		this.to = to;
		this.id = from.getCodiceUnivoco() + to.getCodiceUnivoco();
	}

	public String getId() {
		return id;
	}

	public Mondo getTo() {
		return to;
	}

	public Mondo getFrom() {
		return from;
	}

	@Override
	public String toString() {
		return this.getId();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Portale portale = (Portale) o;
		return this.getId().equals(portale.getId());
	}

	@Override
	public int hashCode() {
		return this.getId().hashCode();
	}
}
