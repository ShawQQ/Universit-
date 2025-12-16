package Tutorato.Extra.Esercizi7;

public class Re  extends PezzoDegliScacchi {

    public Re (int x, int y, ColoreGiocatore colore) {
        super(x, y, Integer.MAX_VALUE, colore);
    }

    @Override
    public boolean canMoveTo(int newX, int newY) {
        return newX - 1 == this.getX() || newY - 1 == this.getY();
    }

}
