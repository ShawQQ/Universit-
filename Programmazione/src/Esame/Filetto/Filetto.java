package Esame.Filetto;

/**
 * Rappresenta una generalizzazione del gioco tris su una griglia n*n. La griglia è modellata attraverso un array
 * bidimensionale di char, i cui unici elementi sono ' ', 'x','o'
 */
public class Filetto {
	private char[][] grid;

	public Filetto(int n){
		if(n < 3) throw new RuntimeException("La griglia non puo' essere piu' piccola di 3x3");
		this.grid = new char[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				this.grid[i][j] = ' ';
			}
		}
	}

	private int getGridSize(){
		return this.grid.length;
	}

	/**
	 * Assegna, se le coordinate sono interne alla griglia e il carattere e' valido, il carattere alla posizione
	 * indicata dai due indici
	 * @param i prima coordinata della griglia
	 * @param j secodna coordinata della griglia
	 * @param c carattere da inserire
	 * @return true se il carattere e' stato inserito correttamente, false altrimenti
	 */
	public boolean gioca(int i, int j, char c){
		if(!isValidPlay(i, j, c)) return false;
		this.grid[i][j] = c;
		return true;
	}

	/**
	 * Controlla se la riga indicata dal primo parametro e' composta unicamente dal carattere indicato nel secondo
	 * parametro
	 * @param i indice della riga
	 * @param c carattere da confrontare
	 * @return true se la riga contiene solo il carattere indicato come secondo parametro, false altrimenti
	 */
	public boolean vinceRiga(int i, char c){
		return vince(i, 0, 0, 1, c);
	}
	/**
	 * Controlla se la colonna indicata dal primo parametro e' composta unicamente dal carattere indicato nel secondo
	 * parametro
	 * @param j indice della colonna
	 * @param c carattere da confrontare
	 * @return true se la colonna contiene solo il carattere indicato come secondo parametro, false altrimenti
	 */
	public boolean vinceColonna(int j, char c){
		return vince(0, j, 1, 0, c);
	}
	/**
	 * Controlla se una delle diagonali e' composta unicamente dal carattere indicato come parametro
	 * parametro
	 * @param c carattere da confrontare
	 * @return true se una delle diagonali contiene solo il carattere indicato come secondo parametro, false altrimenti
	 */
	public boolean vinceDiagonale(char c){
		return vince(0, 0, 1, 1, c) || vince(0, this.getGridSize() - 1, 1, -1, c);
	}

	/**
	 * Determina se il carattere c ha vinto (ovvero se c occupa interamente una riga, una colonna o una diagonale)
	 * @param c carattere da controllare
	 * @return true se c occupa interamente una riga, una colonna o una diagonale, false altrimenti
	 */
	boolean vince(char c){
		if(this.vinceDiagonale(c)) return true;
		for(int i = 0; i < this.getGridSize(); i++){
			if(this.vinceRiga(i, c) || this.vinceColonna(i, c)) return true;
		}
		return false;
	}

	public String toString() {
		String name = "";
		for(int i = 0; i < this.getGridSize(); i++){
			for(int j = 0; j < this.getGridSize(); j++){
				name += this.grid[i][j];
			}
		}
		return name;
	}

	/**
	 * Controlla se il carattere passato è un carattere valido per la griglia
	 * @param c carattere da controllare
	 * @return true se il carattere rispetta le condizioni della griglia, false altrimenti
	 */
	private boolean isValid(char c){
		return c == 'x' || c == 'o';
	}

	/**
	 * Controlla se un indice e' valido per la griglia attuale
	 * @param i indice da controllare
	 * @return true se l'indice e' valido, false altrimenti
	 */
	private boolean isValidIndex(int i){
		return i > 0 && i < this.grid.length;
	}

	/**
	 * Controlla se una mossa è valida, ovvero se il carattere inserito rispetta le condizioni della griglia e
	 * sta venendo inserito in uno spazio considerato vuoto
	 * @param i prima coordinata della griglia
	 * @param j seconda coordinata della griglia
	 * @param c carattere da inserire
	 * @return true se la mossa è valida, false altrimenti
	 */
	private boolean isValidPlay(int i, int j, char c){
		return 	this.isValid(c) &&
				this.isValidIndex(i) &&
				this.isValidIndex(j) &&
				this.grid[i][j] == ' ';
	}

	/**
	 * Controlla se un giocatore ha vinto la partita
	 * @param y riga da controllare
	 * @param x colonna da controllare
	 * @param dy incremento riga
	 * @param dx incremento colonna
	 * @param c carattere da controllare
	 * @return true se un giocatore ha vinto la partita, false altrimenti
	 */
	private boolean vince(int y, int x, int dy, int dx, char c){
		if(!isValid(c)) return false;
		int i = y;
		int j = x;
		while(isValidIndex(y) && isValidIndex(x)){
			if(this.grid[y][x] != c) return false;
			i += dy;
			x += dx;
		}
		return true;
	}
}
