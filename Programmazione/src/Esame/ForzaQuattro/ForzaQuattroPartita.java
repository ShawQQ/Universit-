package Esame.ForzaQuattro;

/**
 * Una partita di forza 4 ha le seguenti caratteristiche:
 * 1. un numero di righe, di default è 6
 * 2. un numero di colonne, di default è 6
 * 3. un numero di elementi consecutivinecessari per vincere, di default 4
 * 4. un numero di giocatori, di default è 2
 * 
 * Questa classe ha due costruttori, uno che accetta tutti e quattro gli argomenti, e un'altra che usa quelli di default
 * il numero di giocatori non può essere minore di 2 o maggiore del numero di elementi per vincere
 * il numero di righe o colonne non può essere minore del numero di elementi per vincere
 * il numero di elementi per vincere non può essere minore di tre
 * 
 * Questa classe esplone i seguenti metodi pubblici
 * 1. resetPartita, torna void, senza argomenti. si può sempre usare e la partita risulta non finita. i parametri restano gli stessi
 * 2. getVincitore, torna -1 se la partita non è finita, o il numero del giocatore corrispondente, ad iniziare dallo 0
 * 3. getGiocatore, torna il numero del giocatore di turno, ad iniziare da 0
 * 4. faiMossa, torna un booleano (true se la colonna era libera, false altrimenti) e segna che il giocatore di turno
 *      fa una mossa tramite la coordiata passate tramite parametro (quindi il metodo ha un parametro intero) che vanno da 0 a num di colonne -1.
 *      lancia un ClosedGameException se la partita è finita, e un IndexOutOfBoundsException se le coordinate sono fuori dalla griglia di gioco.
 *      ATTENZIONE ricorda che in forza 4 c'è la gravità, significa che, se una colonna non è piena, torna true e metti il segno nella posizione più in basso
 * 5. daiGriglia, non prende argomenti e ritorna un array int[][] di dimensione righe x colonne. nell'array c'è -1 se non ci sono segni, o il numero del giocatore, se ci ha giocato.
 *      attenzione, se l'array è contenuto anche dentro l'oggetto deve essere una copia, per evitare manipolazioni di memoria.
 */

public class ForzaQuattroPartita {
	private final static int DEFAULT_GRID_ROW = 6;
	private final static int DEFAULT_GRID_COL = 6;
	private final static int DEFAULT_WIN = 4;
	private final static int DEFAULT_PLAYER = 2;

	private int[][] grid;
	private int currentPlayer;
	private final int nPlayer;
	private final int numberOfSymbolForWin;
	private boolean hasEnded;

	public ForzaQuattroPartita(int row, int col, int numberOfSymbolForWin, int player){
		if(row < numberOfSymbolForWin) throw new IllegalArgumentException("Numero righe non valido");
		if(col < numberOfSymbolForWin) throw new IllegalArgumentException("Numero colonne non valido");
		if(player < 2 || numberOfSymbolForWin < player) throw new IllegalArgumentException("Numero giocatori non valido");
		if(numberOfSymbolForWin < 3) throw new IllegalArgumentException("Numero simboli non valido");
		this.grid = this.generateDefaultGrid(row, col);
		this.nPlayer = player;
		this.numberOfSymbolForWin = numberOfSymbolForWin;
		this.currentPlayer = 0;
	}

	public ForzaQuattroPartita(){
		this(DEFAULT_GRID_ROW, DEFAULT_GRID_COL, DEFAULT_WIN, DEFAULT_PLAYER);
	}

	public void resetPartita(){
		this.grid = this.generateDefaultGrid(this.grid.length, this.grid[0].length);
		this.hasEnded = false;
		this.currentPlayer = 0;
	}

	public int getVincitore(){
		return this.hasEnded ? this.currentPlayer : -1;
	}
	public int getGiocatore(){
		return this.currentPlayer;
	}
	public boolean faiMossa(int col){
		if(!isValid(col)) throw new IndexOutOfBoundsException("Colonna non valida");
		if(this.hasEnded) throw new ClosedGameException("Partita finita");
		int row = getNextSpaceInCol(col);
		if(row == -1) return false;
		this.grid[col][row] = this.currentPlayer;
		this.hasEnded = hasCurrentPlayerWon(col, row);
		if(!this.hasEnded) this.currentPlayer = (this.currentPlayer + 1) % this.nPlayer;
		return true;
	}
	public int[][] daiGriglia(){
		int[][] grid = new int[this.grid[0].length][this.grid.length];
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				grid[i][j] = this.grid[j][i];
			}
		}
		return grid;
	}

	private boolean hasCurrentPlayerWon(int col, int row) {
		return hasCurrentPlayerWonCol(col) || hasCurrentPlayerWonRow(row) || hasCurrentPlayerWonDiagonal(col, row);
	}

	private boolean hasCurrentPlayerWonDiagonal(int col, int row) {
		int[] diagonal = this.getDiagonal(col, row);
		int[] antiDiagonal = this.getAntiDiagonal(col, row);
		return hasWon(diagonal, this.currentPlayer) || hasWon(antiDiagonal, this.currentPlayer);
	}

	private int[] getDiagonal(int col, int row) {
		int start_col = col;
		int start_row = row;
		int k = 0;
		int[] diagonal = new int[this.grid.length * this.grid[0].length];
		while(start_col > 0 && start_row < this.grid[0].length - 1){
			start_col--;
			start_row++;
		}
		int i = 0;
		while(start_col + i < this.grid.length && start_row - i >= 0){
			diagonal[k++] = this.grid[start_col + i][start_row - i];
			i++;
		}
		return copy(diagonal, k);
	}

	private int[] getAntiDiagonal(int col, int row) {
		int start_col = col;
		int start_row = row;
		int k = 0;
		int[] antiDiagonal = new int[this.grid.length * this.grid[0].length];
		while(start_col > 0 && start_row > 0){
			start_col--;
			start_row--;
		}
		int i = 0;
		while(start_col + i < this.grid.length && start_row + i < this.grid[0].length){
			antiDiagonal[k++] = this.grid[start_col + i][start_row + i];
			i++;
		}
		return copy(antiDiagonal, k);
	}

	private int[] copy(int[] arr, int k) {
		int[] copy = new int[k];
		for(int i = 0; i < k; i++){
			copy[i] = arr[i];
		}
		return copy;
	}

	private boolean hasCurrentPlayerWonRow(int row) {
		int[] symbols = new int[this.grid.length];
		for(int i = 0; i < symbols.length; i++){
			symbols[i] = this.grid[i][row];
		}
		return hasWon(symbols, this.currentPlayer);
	}

	private boolean hasCurrentPlayerWonCol(int col) {
		return hasWon(this.grid[col], this.currentPlayer);
	}

	private boolean hasWon(int[] symbols, int currentPlayer) {
		int consecutiveSymbol = 0;
		for(int i = 0; i < symbols.length; i++){
			if(symbols[i] != currentPlayer){
				consecutiveSymbol = 0;
			}else{
				consecutiveSymbol++;
			}
			if(consecutiveSymbol >= this.numberOfSymbolForWin) return true;
		}
		return false;
	}

	private int getNextSpaceInCol(int col) {
		for(int i = this.grid[col].length - 1; i >= 0; i--){
			if(this.grid[col][i] == -1) return i;
		}
		return -1;
	}

	private boolean isValid(int col) {
		return col >= 0 && col < this.grid.length;
	}

	private int[][] generateDefaultGrid(int row, int col) {
		//per comodità la griglia è memorizzata con le dimensioni invertite
		int[][] grid = new int[col][row];
		for(int i = 0; i < col; i++){
			for(int j = 0; j < row; j++){
				grid[i][j] = -1;
			}
		}
		return grid;
	}
}
