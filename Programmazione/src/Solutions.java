import ClassiBase.Complex;
import ClassiBase.Primes;
import ClassiBase.Recipiente;
import Hereditary.Counter;
import Hereditary.CounterBase;

public class Solutions {
    public static void main(String[] args){
        //System.out.println("Ricorsione: ");
        //testRecursion();
        //printDivisor();
        //System.out.println("Array: ");
        //testArrays();
        //Lab.pascal(7);
        //testSearch();
        //testClassPrime();
        //testComplex();
        //testCounter();
        testMatrixMultiply();
    }

    public static void testMatrixMultiply(){
        double[][] a = { {1,1,2}, {0,1,-3} };
        double[][] b = { {1,1,1}, {2,5,1}, {0,-2,1} };
        printMultiDimensionalArray(Matrix.multiply(a,b));
    }

    public static void testCounter(){
        Counter c = new Counter();
        Counter d = new CounterBase(10);
        printCounter(c);
        printCounter(d);
    }
    public static void printCounter(Counter c){
        for(int i = 0; i <= 10; i++){
            System.out.println(c.getNext());
        }
    }

    private static void testComplex(){
        Complex a = new Complex(4, 2);
        Complex b = new Complex(2, 4);
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.add(b));
        System.out.println(a.substraction(b));
        System.out.println(a.multiply(b));
        System.out.println(a.division(b));
        System.out.println(a.conjugate());
        System.out.println(a.module());
    }
    private static void testClassPrime(){
        Primes primes = new Primes();
        for(int i = 0; i < 250; i++){
            System.out.println(primes.next());
        }
    }

    private static void testRecursion(){
        int[] test = {16, 0, 32, 63};

        for(int number : test){
            String a = Recursion.toBase(number, 2);
            String b = Recursion.toBase(number, 16);
            System.out.println("Base 2: " + a);
            System.out.println("Base 16: " + b);
        }

        int[] testPrime = {2, 4, 7, 12, 13};
        for(int number : testPrime){
            System.out.println(number + " è primo: " + (Recursion.isPrime(number) ? "Sì" : "No"));
        }
    }

    private static void testArrays(){
//        int[] a = {1,2,3,4};
//        Arrays.inverti(a);
//        System.out.println("Inversione: ");
//        printArray(a);
//        printDivisor();
//        int[] b = {1,2,3,4};
//        Arrays.invertiNotInPlace(b);
//        printArray(b);
//        printArray(Arrays.invertiNotInPlace(b));
//        printDivisor();
//        System.out.println("Concatena: ");
//        printArray(Arrays.concatena(a,b));
//        printDivisor();
//        System.out.println("Permutazioni: ");
//        printMultiDimensionalArray(Arrays.permutazioni(4));
          System.out.println("Permutazioni 2: ");
          printMultiDimensionalArray(Arrays.permutazioni2(12));
    }
    private static void testSearch(){
        int[] a = {5,4,9,3,15,2};
        Search.mergeSort(a, 0, a.length-1);
        printArray(a);
    }
    private static void printArray(int[] a){
        for(int i = 0; i < a.length; i++){
            System.out.println("a["+i+"] = "+a[i]);
        }
    }
    private static void printMultiDimensionalArray(int[][] a){
        for(int i = 0; i < a.length; i++){
            System.out.print("a["+i+"] = [");
            for(int j = 0; j < a[i].length; j++){
                System.out.print(" " + a[i][j] + ",");
            }
            System.out.println("]");
        }
    }
    private static void printMultiDimensionalArray(double[][] a){
        for(int i = 0; i < a.length; i++){
            System.out.print("a["+i+"] = [");
            for(int j = 0; j < a[i].length; j++){
                System.out.print(" " + a[i][j] + ",");
            }
            System.out.println("]");
        }
    }

    private static void printDivisor(){
        System.out.println("---------------------------------------------------------------");
    }

}
