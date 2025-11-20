package Esame.Polinomio;

public class Polinomio {
	private float[] coefficient;

	public Polinomio(int n){
		if(n < 0) throw new RuntimeException("la dimensione del polinomio non puo' essere minore di 0");
		this.coefficient = new float[n];
	}

	public int dimensione(){
		return this.coefficient.length;
	}
	public float get(int i){
		if(i < 0) throw new RuntimeException("Indice non valido");
		if(i >= this.dimensione()) return 0;
		return this.coefficient[i];
	}
	public void set(int i, float x){
		if(i < 0 || i >= this.dimensione()) throw new RuntimeException("Indice non valido");
		this.coefficient[i] = x;
	}
	public Polinomio somma(Polinomio that){
		if(that == null) throw new RuntimeException("Polinomio non valido");
		Polinomio newPolinomio = new Polinomio(Math.max(this.dimensione(), that.dimensione()));
		for(int i = 0; i < Math.min(this.dimensione(), that.dimensione()); i++){
			newPolinomio.set(i, this.get(i) + that.get(i));
		}
		return newPolinomio;
	}
	public float valore(float x){
		float sum = 0;
		for(int i = 0; i < this.dimensione(); i++){
			sum += this.get(i) * Math.pow(x, i);
		}
		return sum;
	}
}
