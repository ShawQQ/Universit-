package Esame.IntervalloNaturale;

public class IntervalloNaturale {
	private final String start;
	private final String end;

	public IntervalloNaturale(String first, String second){
		if(isNotValid(first) || isNotValid(second)) throw new IllegalArgumentException("Intervalli non validi");
		if(compareNumericString(first, second) > 0) throw new IllegalArgumentException("Il secondo intervallo non puo essere minore del primo");
		this.start = first;
		this.end = second;
	}
	public IntervalloNaturale(IntervalloNaturale first, IntervalloNaturale second){
		if(compareNumericString(first.start, second.start) > 0)
			throw new IllegalArgumentException("Il secondo intervallo deve venire dopo il primo");
		if(Integer.parseInt(first.end) - Integer.parseInt(second.start) < -1)
			throw new IllegalArgumentException("Gli intervalli non sono consecutivi");
		this.start = first.start;
		this.end = compareNumericString(first.end, second.end) > 0 ? first.end : second.end;
	}

	@Override
	public String toString() {
		return compareNumericString(this.start, this.end) == 0 ? this.start : this.start + "-" + this.end;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		IntervalloNaturale that = (IntervalloNaturale) o;
		return this.toString().equals(that.toString());
	}

	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}

	public boolean compreso(String numero){
		if(isNotValid(numero)) return false;
		return compareNumericString(numero, this.start) >= 0 && compareNumericString(numero, this.end) <= 0;
	}

	private boolean isNotValid(String str) {
		if(str == null) return true;
		if(str.isEmpty()) return true;
		for(int i = 0; i < str.length(); i++){
			if(!Character.isDigit(str.charAt(i))) return true;
		}
		return false;
	}

	private int compareNumericString(String first, String second){
		int result = Integer.parseInt(first) - Integer.parseInt(second);
		if(result == 0) return 0;
		return result > 0 ? 1 : -1;
	}
}
