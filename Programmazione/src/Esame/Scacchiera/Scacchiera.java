package Esame.Scacchiera;

public class Scacchiera {
	private boolean[][] grid;

	public Scacchiera(int n){
		if(n <= 0) throw new IllegalArgumentException("Dimensione scacchiera non valida");
		this.grid = new boolean[n][n];
	}

	public int dimensione(){
		return this.grid.length;
	}
	public boolean contienePezzo(int i, int j){
		return isValid(i, j) && this.grid[i][j];
	}
	public boolean aggiungiPezzo(int i, int j){
		if(!isValid(i, j) || contienePezzo(i, j)) return false;
		this.grid[i][j] = true;
		return true;
	}
	public boolean mossaValida(int i, int j, int k, int w){
		if(!contienePezzo(i, j) || contienePezzo(k, w) || !isValid(k, w)) return false;
		int dx = 2;
		int dy = 1;
		while(dx > 0){
			if(
				mossaValida(i, j, k, w, dx, dy) ||
				mossaValida(i, j, k, w, -dx, dy) ||
				mossaValida(i, j, k, w, dx, -dy) ||
				mossaValida(i, j, k, w, -dx, -dy)
			){
				return true;
			}
			dx--;
			dy++;
		}
		return false;
	}
	private boolean mossaValida(int i, int j, int k, int w, int dx, int dy){
		return i + dx == k && j + dy == w;
	}
	public boolean dominata(int i, int j){
		for(int k = 0; k < this.dimensione(); k++){
			for(int q = 0; q < this.dimensione(); q++){
				if(mossaValida(k, q, i, j)) return true;
			}
		}
		return false;
	}
	public boolean sposta(int i, int j, int k, int w){
		if(!mossaValida(i, j, k, w)) return false;
		this.grid[i][j] = false;
		this.grid[k][w] = true;
		return true;
	}
	public int conta(int i, int j){
		int total = 0;
		for(int k = 0; i < this.dimensione(); k++){
			for(int q = 0; q < this.dimensione(); q++){
				if(this.mossaValida(k,q,i,j)){
					total++;
				}
			}
		}
		return total;
	}

	private boolean isValid(int i, int j){
		return isValid(i) && isValid(j);
	}
	private boolean isValid(int i){
		return i > 0 && i < this.dimensione();
	}
}
