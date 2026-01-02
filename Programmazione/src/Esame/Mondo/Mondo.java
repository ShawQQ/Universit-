package Esame.Mondo;

import java.util.Random;

public class Mondo {
	private final Portale[] portali;
	private int currentPortali;
	private final String id;
	public Mondo(int n){
		if(n <= 0) throw new IllegalArgumentException("Numero portali non valido");
		this.portali = new Portale[n];
		this.id = generateIdString();
		this.currentPortali = 0;
	}

	public String getCodiceUnivoco() {
		return id;
	}

	public int getCurrentPortali(){
		return this.currentPortali;
	}

	public boolean aggiungiPortale(Portale portale){
		if(portale == null) return false;
		if(this.isFull()) return false;
		if(this.contains(portale)) return false;
		if(!portale.getFrom().equals(this)) return false;
		if(portale.getTo().equals(this)) return false;
		this.portali[currentPortali++] = portale;
		return true;
	}

	public boolean puoRaggiungere(Mondo to, int n){
		if(n == 0) return false;
		for(int i = 0; i < this.getCurrentPortali(); i++){
			if(this.portali[i].getTo().equals(to)) return true;
			if(this.portali[i].getTo().puoRaggiungere(to, n-1)) return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Mondo mondo = (Mondo) o;
		return this.getCodiceUnivoco().equals(mondo.getCodiceUnivoco());
	}

	@Override
	public int hashCode() {
		return this.getCodiceUnivoco().hashCode();
	}

	private boolean contains(Portale portale) {
		for(int i = 0; i < this.getCurrentPortali(); i++){
			if(this.portali[i].equals(portale)) return true;
		}
		return false;
	}

	private boolean isFull() {
		return this.currentPortali == this.portali.length;
	}

	private String generateIdString(){
		StringBuilder id = new StringBuilder();
		Random rng = new Random();
		int[] charsCode = rng.ints(16, 'a', 'z').toArray();
		for (int j : charsCode) {
			id.append((char) j);
		}
		return id.toString();
	}
}
