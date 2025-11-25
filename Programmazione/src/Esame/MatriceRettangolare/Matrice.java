package Esame.MatriceRettangolare;

public class Matrice {
	private int[][] matrix;

	public Matrice(int m, int n){
		if(m <= 0 || n <= 0) throw new IllegalArgumentException("Dimensione non valida");
		this.matrix = new int[m][n];
	}
	public int righe(){
		return this.matrix.length;
	}
	public int column(){
		return this.matrix[0].length;
	}
	private int[][] getMatrix(){
		return this.matrix;
	}
	public int get(int i, int j){
		if(!isValid(i, j)) throw new RuntimeException("Indici fuori dal range della matrice");
		return this.matrix[i][j];
	}
	public void set(int i, int j, int x){
		if(!isValid(i, j)) throw new RuntimeException("Indici fuori dal range della matrice");
		this.matrix[i][j] = x;
	}
	public int[] riga(int i){
		if(!isValid(i, 0)) throw new RuntimeException("Indici fuori dal range della matrice");
		return this.matrix[i];
	}
	public int[] colonna(int j) {
		if(!isValid(0, j)) throw new RuntimeException("Indici fuori dal range della matrice");
		int[] column = new int[this.righe()];
		for(int i = 0; i < this.righe(); i++){
			column[i] = this.get(i, j);
		}
		return column;
	}
	public Matrice somma(Matrice that){
		if(this.righe() != that.righe() || this.column() != that.column()) throw new RuntimeException("le dimensioni non corrispondo");
		Matrice sumMatrix = new Matrice(this.righe(), this.column());
		for(int i = 0; i < this.righe(); i++){
			for(int j = 0; j < this.column(); j++){
				sumMatrix.set(i, j, this.get(i, j) + that.get(i, j));
			}
		}
		return sumMatrix;
	}

	public Matrice tranposta(){
		Matrice transposta = new Matrice(this.column(), this.righe());
		for(int i = 0; i < this.column(); i++){
			for(int j = 0; j < this.righe(); j++){
				transposta.set(i, j, this.get(j, i));
			}
		}
		return transposta;
	}

	private boolean isValid(int i, int j) {
		return (i >= 0 && i < this.righe()) && (j >= 0 && j < this.column());
	}
}
