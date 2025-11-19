package Tutorato;

public class Matrice{
 public static void main(String[] args) {
        
        //creiamo delle matrici
        int[][] matrixA = new int[][] {{1,1,1},{1,1,1},{1,1,1}};
        int[][] matrixB = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
       

        System.out.println("");
    }
    
    //---------------------------------------------------------------------------------------------------
    //----------------------------------------METODI MATRIX-----------------------------------------------
    //---------------------------------------------------------------------------------------------------

    //Questo metodo prende in input una matrice e la stampa a console 
    public static void printMatrix(int[][] matrix){
        System.out.print("[");
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
        }
        System.out.println("]");
    }

    //Calcola la somma di tutti gli elementi di una matrice quadrata
    //nel caso in cui una matrice sia null ritorniamo il valore 0
    public static int sumMatrix(int[][] matrix){
        if(isNotSquare(matrix)) return 0;
        int sum = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    // Stampa la somma gli elementi della diagonale principale m[i][i]. 
    // Ricorda che solo le matrici quadrate hanno una diagonale, ossia 
    // le matrici con la stessa lunghezza di righe e colonne
    public static void printDiagonale(int[][] matrix){
        if(isNotSquare(matrix)) return;
        int sum = 0;
        for(int i = 0; i < matrix.length; i++){
            sum += matrix[i][i];
        }
        System.out.println("Somma diagonale: "+sum);
    }

    //C'è un modo per rendere il metodo precedente più efficente ? 
    //Prova a velocizzare il metodo di prima
    public static void printDiagonalePro(int[][] matrix){

    }
    
    //Il metodo prende in input n, ossia la lunghezza della matrice quadrata. 
    //Genera una matrice identità.
    public static int[][] matriceId( int n ){
        int[][] matrix = new int [][]{{}};
        for(int i = 0; i < n; i++){
            matrix[i][i] = 1;
        }
        return matrix; 
    }

    //Il metodo SommaTraMatrici prende in input due matrici. 
    //Assumiamo che le due matrici abbiano la stessa lunghezza e non siano nulle 
    public static int[][] SommaTraMatrici(int[][] matrixA, int[][] matrixB){
        int[][] matrix = new int [matrixA.length][matrixA[0].length];
        if(matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) return matrix;
        for(int i = 0; i < matrixA.length; i++){
            for(int j = 0; j < matrixA[i].length; j++){
                matrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return matrix; 
    }

    /*Ruota la matrice passata come input di 90 gradi 

    1(00)    2(01)    3(02)   -->     7(00)    4(01)    1(02)
    4(10)    5(11)    6(12)   -->     8(10)    5(11)    2(12)
    7(20)    8(21)    9(22)   -->     9(20)    6(21)    3(22)

    */
    public static int[][] rotazioneMatrice(int[][] matrix){
        if(isNotSquare(matrix)) return null;
        int[][] m = new int [matrix.length][matrix[0].length];
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[0].length; j++){
                m[i][j] = matrix[j][i];
            }
        }
        return m;
    }

    private static boolean isNotSquare(int[][] matrix){
        return matrix == null || matrix.length != matrix[0].length;
    }
}

  