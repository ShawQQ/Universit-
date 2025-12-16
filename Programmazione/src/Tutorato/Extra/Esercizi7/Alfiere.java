package Tutorato.Extra.Esercizi7;

public class Alfiere extends PezzoDegliScacchi {

    public Alfiere(int x, int y, ColoreGiocatore colore) {
        super(x, y, 3, colore);
    }

    @Override
    public boolean canMoveTo(int newX, int newY) {
        return newX + newY == this.getX() + this.getX() || newX - newY == this.getX() - this.getY();
    }

}
