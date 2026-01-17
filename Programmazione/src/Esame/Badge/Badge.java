package Esame.Badge;

public class Badge {
	private static long idCounter;
	private static final int DEFAULT_TRIES = 3;

	private final long id;
	private final String nominativo;
	private final long stabilimentoId;
	private final Ruolo ruolo;
	private boolean attivo;
	private int tries;

	public Badge(String nominativo, long stabilimentoId, Ruolo ruolo) {
		if(!isValid(nominativo)) throw new IllegalArgumentException("Nominativo non valido");
		this.id = ++idCounter;
		this.nominativo = nominativo;
		this.stabilimentoId = stabilimentoId;
		this.ruolo = ruolo;
		this.attivo = true;
		this.tries = DEFAULT_TRIES;
	}

	private boolean isValid(String nominativo) {
		if(nominativo == null) return false;
		return StringUtils.isOnlyLetter(nominativo) && StringUtils.countUppercaseWord(nominativo) >= 2;
	}

	public long getID() {
		return id;
	}

	public String getNominativo() {
		return nominativo;
	}

	public long getStabilimentoID() {
		return stabilimentoId;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public boolean isAttivo() {
		return attivo;
	}

	public boolean check(long stabilimentoId){
		if(!this.isAttivo()) return false;
		if(stabilimentoId != this.getStabilimentoID()){
			this.tries--;
			if(this.tries == 0) this.attivo = false;
			return false;
		}
		return true;
	}
}
