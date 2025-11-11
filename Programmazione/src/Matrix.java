public class Matrix {
    public static double[][] sum(double[][] a, double[][] b){
        if(a.length != b.length) return null;
        double[][] result = new double[a.length][a[0].length];
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length; j++){
                if(j < b[i].length){
                    result[i][j] = a[i][j] + b[i][j];
                }else{
                    result[i][j] = a[i][j];
                }
            }
        }
    }

    public static double[][] multiply(double[][] a, double[][] b){
        if(a.length != b[0].length) return null;
        double[][] result = new double[a.length][b[0].length];
        for(int i = 0; i < a.length){
            for(int j = 0; j < b[i].length; j++){
                result[i][j] = a[0][0] * b[0] + a[0][1] * b[1][0];
            }
        }
    }
}
