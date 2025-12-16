package Tutorato.Extra.Esercizi7;

public class Torre  extends PezzoDegliScacchi {

    public Torre(int x, int y, ColoreGiocatore colore) {
        super(x, y, 5, colore);
    }

    @Override
    public boolean canMoveTo(int newX, int newY) {
        return newX == this.getX() || newY == this.getY();
    }

}
