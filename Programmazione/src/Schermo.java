public class Schermo {
    private final int X = 600;
    private final int Y = 800;

    public void schermo(){
        boolean[][] schermo = new boolean[X][Y];
    }

    private void nero(boolean[][] s){
        fillBoolMatrix(s, false);
    }
    private boolean[][] and(boolean[][] a, boolean[][] b){
        boolean[][] result = new boolean[X][Y];
        for(int i = 0; i < X; i++){;
            for(int j = 0; j < Y; j++){
                result[i][j] = a[i][j] || b[i][j];
            }
        }
        return result;
    }
    private void translate(boolean[][] s, int x1, int y1, int x2, int y2, int xs, int ys){
        for(int i = x1; i < x2; i++){
            for(int j = y1; j < y2; j++){
                if(i+xs < X && j+ys < Y && i+xs > 0 && j+ys > 0){
                    s[i+xs][j+ys] = s[i][j];
                }
                s[i][j] = false;
            }
        }
    }

    private void fillBoolMatrix(boolean[][] s, boolean val){
        for(int i = 0; i < s.length; i++){
            for(int j = 0; j < s[i].length; j++){
                s[i][j] = val;
            }
        }
    }
}
