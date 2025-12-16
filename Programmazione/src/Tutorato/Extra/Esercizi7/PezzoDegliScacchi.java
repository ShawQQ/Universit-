package Tutorato.Extra.Esercizi7;

public abstract class PezzoDegliScacchi {
    private int x, y;
    private final int puntiValore;
    private final ColoreGiocatore colore;
    public PezzoDegliScacchi(int x, int y, int puntiValore, ColoreGiocatore colore) {
        if(!isValidCoordinate(x) || !isValidCoordinate(y)) {
            throw new IllegalArgumentException("Coordinate out of bounds");
        }
        this.x = x;
        this.y = y;
        this.puntiValore = puntiValore;
        this.colore = colore;
    }
    public static boolean isValidCoordinate(int coord) {
        return coord >= 0 && coord < 8;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setXY(int newX, int newY) {
        if(!isValidCoordinate(newX) || !isValidCoordinate(newY)) {
            throw new IllegalArgumentException("Coordinate out of bounds");
        }
        if(!canMoveTo(newX, newY)) {
            throw new IllegalArgumentException("Invalid move for this piece");
        }
        this.x = newX;
        this.y = newY;
    }

    public abstract boolean canMoveTo(int newX, int newY);

    public int getPuntiValore() {
        return puntiValore;
    }

    public ColoreGiocatore getColore() {
        return colore;
    }

    public boolean canPromote(){
        return false;
    }
}
