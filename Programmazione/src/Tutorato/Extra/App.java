package Tutorato.Extra;


public class App {
    public static void main(String[] args) {
        // Esegue i test del primo esercizio
        boolean result = new BitManipulator().main();
        if(result){
            // Eseguo quindi i test del secondo se il primo funziona
            System.out.println("<<.....Procedo a testare il secondo.....>>");
            int[][] table = {
                {5, 0, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 0, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 0},

                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 0, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},

                {0, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 0, 5},
                {3, 4, 5, 2, 8, 0, 1, 7, 9}
            };
            int[][] table2 = {
                {5, 0, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 0, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 0},

                {8, 5, 9, 7, 6, 4, 0, 2, 3},
                {4, 2, 6, 0, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},

                {1, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 0, 5},
                {3, 4, 5, 2, 8, 0, 1, 7, 9}
            };
            try{
                SudokuChecker checker = new SudokuChecker();
                if(checker.checkSudoku(table) && !checker.checkSudoku(table2)){
                    System.out.println("checkSudoku funziona");
                } else {
                    System.out.println("checkSudoku NON funziona");
                }
            }catch(Exception e){
                System.out.println("checkSudoku è andato in errore");
                System.err.println(e.getMessage());
            }
        }
    }
}
