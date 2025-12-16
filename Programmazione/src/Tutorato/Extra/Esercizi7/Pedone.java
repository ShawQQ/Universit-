package Tutorato.Extra.Esercizi7;

public class Pedone extends PezzoDegliScacchi {

    public Pedone(int x, int y, ColoreGiocatore colore) {
        super(x, y, 1, colore);
    }

    @Override
    public boolean canMoveTo(int newX, int newY) {
        return this.getX() == newX && this.getY() + 1 == newY;
    }

    @Override
    public boolean canPromote(){
        int endOfBoard = this.getColore().equals(ColoreGiocatore.BIANCO) ? 7 : 0;
        return this.getY() == endOfBoard;
    }

}
