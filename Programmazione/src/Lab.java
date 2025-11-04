import java.util.Arrays;

public class Lab {
    public static void primi(int n){
        boolean[] b = new boolean[n];
        for(int i = 0; i < n; i++){
            b[i] = true;
        }
        for(int i = 2; i*i < n; i++){
            if(b[i]){
                for(int j = i*2; j < n; j += i){
                    b[j] = false;
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(b[i]){
                System.out.print(i+" ");
            }
        }
    }

    public static void tabellina(){
        int[][] tabellina = new int[10][10];
        for(int i = 0; i < tabellina.length; i++){
            for(int j = 0; j < tabellina[i].length; j++){
                tabellina[i][j] = (i+1)*(j+1);
            }
        }
        for(int i = 0; i < tabellina.length; i++){
            for(int j = 0; j < tabellina[i].length; j++){
                System.out.println(i+"*"+j+" = "+tabellina[i][j]);
            }
        }
    }

    //creare una matrice contenente il triangolo di pascal
    public static void pascal(int n){
        int[][] triangle = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    triangle[i][j] = 1;
                }else{
                    triangle[i][j] = triangle[i-1][j] + triangle[i-1][j-1];
                }
            }
        }
        for(int i = 0; i < triangle.length; i++){
            System.out.print("[");
            for(int j = 0; j < triangle[i].length; j++){
                System.out.print(triangle[i][j]+",");
            }
            System.out.print("]");
        }
    }
}
