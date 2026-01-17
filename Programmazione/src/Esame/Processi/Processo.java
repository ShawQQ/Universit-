package Esame.Processi;

public class Processo {
	private static final int DEFAULT_CAPACITY = 32;
	private static final int CAPACITY_INCREMENT = 2;

	private final long priorita;
	private int peso;
	private boolean terminato;
	private Processo[] childs;
	private int currentChild;

	public Processo(long priorita, int peso) {
		if(peso <= 0) throw new IllegalArgumentException("Peso non valido");
		this.priorita = priorita;
		this.peso = peso;
		this.childs = new Processo[DEFAULT_CAPACITY];
	}

	public long getPriorita() {
		return priorita;
	}

	public int getPeso() {
		return peso;
	}

	public boolean isTerminato() {
		return terminato;
	}

	public boolean aggiungiProcesso(Processo p){
		if(p == null) throw new IllegalArgumentException("Processo non puo' essere null");
		if(this.getTotalChildPeso() + p.getPeso() > this.getPeso()) return false;
		this.childs[currentChild++] = p;
		if(currentChild == childs.length){
			this.resize(this.childs.length * CAPACITY_INCREMENT);
		}
		this.sortChildByPriority();
		return true;
	}

	public void prestaRisorse(int risorse){
		if(risorse <= 0) throw new IllegalArgumentException("Numero risorse non valido");
		int remainingRisorse = risorse;
		for(int i = 0; i < this.currentChild; i++){
			remainingRisorse = prestaRisorse(this.childs[i], remainingRisorse);
			if(remainingRisorse <= 0) break;
		}
		prestaRisorse(this, risorse);
	}

	private int prestaRisorse(Processo p, int risorse){
		int toRemove = Math.min(p.getPeso(), risorse);
		p.peso -= toRemove;
		if(p.peso <= 0){
			p.terminato = true;
		}
		return risorse - toRemove;
	}

	public Processo daiProssimoProcesso(){
		for(int i = 0; i < this.currentChild; i++){
			if(!this.childs[i].isTerminato()) return this.childs[i];
		}
		return this.isTerminato() ? null : this;
	}

	private void sortChildByPriority() {
		for(int i = currentChild - 1; i > 0; i--){
			if(this.childs[i].getPriorita() <= this.childs[i - 1].getPriorita()) break;
			this.swapChild(i, i - 1);
		}
	}

	private void swapChild(int i, int j) {
		Processo tmp = this.childs[i];
		this.childs[i] = this.childs[j];
		this.childs[j] = tmp;
	}


	private void resize(int size) {
		this.childs = this.copy(this.childs, size);
	}

	private Processo[] copy(Processo[] childs, int size) {
		Processo[] copy = new Processo[size];
		for(int i = 0; i < childs.length; i++){
			copy[i] = childs[i];
		}
		return copy;
	}

	private int getTotalChildPeso() {
		int total = 0;
		for(int i = 0; i < this.currentChild; i++){
			total += childs[i].getPeso();
		}
		return total;
	}
}
