package Esame.Badge;

public class Stabilimento {
	private static long idCounter;

	private final long id;
	private final String nomeStabilimento;

	public Stabilimento(String nomeStabilimento) {
		if(!isValid(nomeStabilimento)) throw new IllegalArgumentException("Nominativo non valido");
		this.id = ++idCounter;
		this.nomeStabilimento = nomeStabilimento;
	}

	public Badge creaBadge(String nominativo, Ruolo ruolo){
		return new Badge(nominativo, this.getID(), ruolo);
	}

	public void check(Badge b) throws BadgeForbiddenException {
		if(!b.check(this.getID())){
			throw new BadgeForbiddenException();
		}
	}

	public long getID() {
		return id;
	}

	public String getNomeStabilimento() {
		return nomeStabilimento;
	}

	private boolean isValid(String nomeStabilimento) {
		if(nomeStabilimento == null) return false;
		return StringUtils.isOnlyLetter(nomeStabilimento) && StringUtils.countUppercaseWord(nomeStabilimento) >= 2;
	}
}
