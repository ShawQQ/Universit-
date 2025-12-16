package Tutorato.Extra.Esercizi7;

public class Cavallo extends PezzoDegliScacchi {

    public Cavallo(int x, int y, ColoreGiocatore colore) {
        super(x, y, 3, colore);
    }

    @Override
    public boolean canMoveTo(int newX, int newY) {
        int dx = 2;
        int dy = 1;
        while(dx > dy){
            if(
                newX == this.getX() + dx && newY == this.getX() + dy ||
                newX == this.getX() - dx && newY == this.getX() + dy ||
                newX == this.getX() + dx && newY == this.getX() - dy ||
                newX == this.getX() - dx && newY == this.getX() - dy
            ){
                return true;
            }
            dx--;
            dy++;
        }
        return false;
    }

}
