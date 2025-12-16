package Tutorato.Extra.Esercizi7;

public class Scacchiera {
    private PezzoDegliScacchi[][] board;

    public Scacchiera() {
        board = new PezzoDegliScacchi[8][8];
        PezzoDegliScacchi[][] defaultPieces = this.getDefaultPieces();
        for(int i = 0; i < defaultPieces.length; i++){
            for(int j = 0; j < defaultPieces.length; j++){
                this.placePezzo(defaultPieces[i][j], i, j);
            }
        }
    }

    public PezzoDegliScacchi getPezzoAt(int x, int y) {
        if (!PezzoDegliScacchi.isValidCoordinate(x) || !PezzoDegliScacchi.isValidCoordinate(y)) {
            throw new IllegalArgumentException("Coordinate out of bounds");
        }
        return board[x][y];
    }

    public void placePezzo(PezzoDegliScacchi pezzo, int x, int y) {
        if (!PezzoDegliScacchi.isValidCoordinate(x) || !PezzoDegliScacchi.isValidCoordinate(y)) {
            throw new IllegalArgumentException("Coordinate out of bounds");
        }
        board[x][y] = pezzo;
    }

    /**
     * Muove un pezzo dalla posizione (fromX, fromY) a (toX, toY) se la mossa è valida.
     * Se il pezzo non puo' fare quella mossa, torna false.
     * Se il pezzo viene mosso con successo, torna true.
     * Se non c'è nessun pezzo in fromX, fromY, torna false.
     * Se le coordinate sono fuori dai limiti, lancia IllegalArgumentException.
     * @param fromX
     * @param fromY
     * @param toX
     * @param toY
     * @return
     */
    public boolean movePezzo(int fromX, int fromY, int toX, int toY) {
        // ATTENZIONE, se un pedone arriva in fondo alla scacchiera,
        // (rispetto al suo colore)
        // deve essere promosso a regina automaticamente.
        if(
            !PezzoDegliScacchi.isValidCoordinate(fromX) ||
            !PezzoDegliScacchi.isValidCoordinate(fromY) ||
            !PezzoDegliScacchi.isValidCoordinate(toX) ||
            !PezzoDegliScacchi.isValidCoordinate(toY)
        ){
            throw new IllegalArgumentException("Coordinate out of bound");
        }
        PezzoDegliScacchi piece = getPezzoAt(fromX, fromY);
        if(piece == null) return false;
        if(!piece.canMoveTo(toX, toY)) return false;
        this.placePezzo(null, fromX, fromY);
        piece.setXY(toX, toY);
        this.placePezzo(piece, toX, toY);
        if(piece.canPromote()){
            this.placePezzo(new Regina(toX, toY, piece.getColore()), toX, toY);
        }
        return true;
    }

    public PezzoDegliScacchi[][] getBoard() {
        PezzoDegliScacchi[][] board = new PezzoDegliScacchi[8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                board[i][j] = this.getPezzoAt(i, j);
            }
        }
        return board;
    }

    private PezzoDegliScacchi[][] getDefaultPieces() {
        PezzoDegliScacchi[][] defaultBoard = new PezzoDegliScacchi[4][8];
        PezzoDegliScacchi[][] mainPieces = new PezzoDegliScacchi[][]{
            {
                new Torre(0, 0, ColoreGiocatore.BIANCO),
                new Cavallo(0, 1, ColoreGiocatore.BIANCO),
                new Alfiere(0, 2, ColoreGiocatore.BIANCO),
                new Regina(0, 3, ColoreGiocatore.BIANCO),
                new Re(0, 4, ColoreGiocatore.BIANCO),
                new Alfiere(0, 5, ColoreGiocatore.BIANCO),
                new Cavallo(0, 6, ColoreGiocatore.BIANCO),
                new Torre(0, 7, ColoreGiocatore.BIANCO),
            },
            {
                new Torre(0, 0, ColoreGiocatore.NERO),
                new Cavallo(0, 1, ColoreGiocatore.NERO),
                new Alfiere(0, 2, ColoreGiocatore.NERO),
                new Re(0, 3, ColoreGiocatore.NERO),
                new Regina(0, 4, ColoreGiocatore.NERO),
                new Alfiere(0, 5, ColoreGiocatore.NERO),
                new Cavallo(0, 6, ColoreGiocatore.NERO),
                new Torre(0, 7, ColoreGiocatore.NERO),
            },
        };
        for(int i = 0; i < 8; i++){
            defaultBoard[0][i] = mainPieces[0][i];
            defaultBoard[1][i] = mainPieces[1][i];
            defaultBoard[2][i] = new Pedone(1, i, ColoreGiocatore.BIANCO);
            defaultBoard[3][i] = new Pedone(6, i, ColoreGiocatore.NERO);
        }

        return defaultBoard;
    }
}
