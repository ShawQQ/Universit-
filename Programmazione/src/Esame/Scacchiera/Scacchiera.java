package Esame.Scacchiera;

public class Scacchiera {
	private final boolean[][] grid;

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
		int[][] range = this.moveRange(i, j);
		for(int q = 0; q < range.length; q++){
			int[] indexes = range[q];
			if(k == indexes[0] && w == indexes[1]) return true;
		}
		return false;
	}

	public boolean dominata(int i, int j){
		int[][] range = this.moveRange(i, j);
		for(int k = 0; k < range.length; k++){
			int[] indexes = range[k];
			if(this.contienePezzo(indexes[0], indexes[1])) return true;
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
		int[][] range = this.moveRange(i, j);
		for(int k = 0; k < range.length; k++){
			if(this.contienePezzo(range[k][0], range[k][1])) total++;
		}
		return total;
	}

	/**
	 * Enumera tutte le possibili coordinate di arrivo di un cavallo che si trova nella posizione (i,j). Se una coordinata
	 * si trova fuori dal range possibile della scacchiera assume il valore (-1, -1)
	 * @param i primo indice
	 * @param j secondo indice
	 * @return Array di array di interi contenenti tutte le coordinate possibili che si possono raggiungere partendo da
	 * (i,j) con una sola mossa
	 */
	private int[][] moveRange(int i, int j){
		int[][] range = new int[8][];
		for(int k = 0; k < range.length; k++){
			range[k] = new int[] {-1, -1};
		}
		int totalLegalMoves = 0;
		int dx = 2;
		int dy = 1;
		while(dx > 0){
			int[][] indexesRange = getValidIndexRange(i, j, dx, dy);
			for(int q = 0; q < indexesRange.length; q++){
				int[] indexRange = indexesRange[q];
				if(!contienePezzo(indexRange[0], indexRange[1])){
					range[totalLegalMoves++] = new int[] { indexRange[0], indexRange[1] };
				}
			}
			dx--;
			dy++;
		}
		return range;
	}

	/**
	 * Ritorna tutte le coppie di indici (k,q) valide per questa scacchiera tali per cui k = i +/- dx, q = j +/- dy
	 * @param i indice di partenza
	 * @param j indice di partenza
	 * @param dx incremento primo indice
	 * @param dy incremenento secondo indice
	 * @return Un'array di array di interi contenenti le coppie (k,q) valide per questa scacchiera tali per cui
	 * k = i +/- dx, q = j +/- dy
	 */
	private int[][] getValidIndexRange(int i, int j, int dx, int dy) {
		int[][] indexesRange = new int[4][];
		int allowedRanges = 0;
		for(int q = 0; q < 2; q++){
			if(isValid(i + dx, j + dy)) indexesRange[allowedRanges++] = new int[]{ i + dx, j + dy};
			if(isValid(i + dx, j - dy)) indexesRange[allowedRanges++] = new int[]{ i + dx, j - dy};
			dx *= -1;
		}
		int[][] realRanges = new int[allowedRanges][];
		for(int q = 0; q < realRanges.length; q++){
			realRanges[q] = indexesRange[q];
		}
		return realRanges;
	}
	private boolean isValid(int i, int j){
		return isValid(i) && isValid(j);
	}
	private boolean isValid(int i){
		return i > 0 && i < this.dimensione();
	}
}
