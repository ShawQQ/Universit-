package Esame.Vettore;

public class Vettore {
	private int[] elements;

	public Vettore(int n){
		if(n < 0) throw new RuntimeException("Il vettore non puo' avere dimensione negativa");
		this.elements = new int[n];
	}

	public int dimensione(){
		return this.elements.length;
	}
	public int get(int i){
		if(!isValidIndex(i)) throw new RuntimeException("Indice non valido");
		return this.elements[i];
	}
	public Vettore set(int i, int x){
		if(!isValidIndex(i)) throw new RuntimeException("Indice non valido");
		this.elements[i] = x;
		return this;
	}
	public Vettore somma(Vettore that){
		if(this.hasSameDimension(that)) throw new RuntimeException("I vettori hanno dimensione diversa");
		Vettore sumVector = new Vettore(this.dimensione());
		for(int i = 0; i < this.dimensione(); i++){
			sumVector.set(i, this.get(i) + that.get(i));
		}
		return sumVector;
	}
	public int scalare(Vettore that){
		if(this.hasSameDimension(that)) throw new RuntimeException("I vettori hanno dimensione diversa");
		int scalar = 0;
		for(int i = 0; i < this.dimensione(); i++){
			scalar += this.get(i) * that.get(i);
		}
		return scalar;
	}
	public double norma(){
		return Math.sqrt(this.scalare(this));
	}
	public boolean ordinato(){
		for(int i = 1; i < this.dimensione(); i++){
			if(this.get(i) < this.get(i - 1)) return false;
		}
		return true;
	}

	private boolean isValidIndex(int i){
		return i > 0 && i < this.dimensione();
	}
	private boolean hasSameDimension(Vettore that){
		return this.dimensione() == that.dimensione();
	}
}
