package Tutorato.Extra.Esercizi7;

public class Regina  extends PezzoDegliScacchi {

    public Regina(int x, int y, ColoreGiocatore colore) {
        super(x, y, 9, colore);
    }

    @Override
    public boolean canMoveTo(int newX, int newY) {
        Alfiere bishop = new Alfiere(this.getX(), this.getY(), this.getColore());
        Torre tower = new Torre(this.getX(), this.getY(), this.getColore());
        return bishop.canMoveTo(newX, newY) || tower.canMoveTo(newX, newY);
    }

}
