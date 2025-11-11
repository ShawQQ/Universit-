public class Matrix {
    public static double[][] sum(double[][] a, double[][] b){
        if(a.length != b.length || a[0].length != b[0].length) return null;
        double[][] result = new double[a.length][a[0].length];
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length; j++){
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    public static double[][] multiply(double[][] a, double[][] b){
        if(a[0].length != b.length) return null;
        double[][] result = new double[a.length][b[0].length];
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < b[0].length; j++){
                for(int q = 0; q < b.length; q++){
                    result[i][j] += a[i][q] * b[q][j];
                }
            }
        }
        return result;
    }
}
