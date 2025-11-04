public class Solutions {
    public static void main(String[] args){
        //System.out.println("Ricorsione: ");
        //testRecursion();
        //printDivisor();
        //System.out.println("Array: ");
        //testArrays();
        //Lab.pascal(7);
        testSearch();
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
        int[] a = {1,2,3,4};
        Arrays.inverti(a);
        System.out.println("Inversione: ");
        printArray(a);
        printDivisor();
        int[] b = {1,2,3,4};
        Arrays.invertiNotInPlace(b);
        printArray(b);
        printArray(Arrays.invertiNotInPlace(b));
        printDivisor();
        System.out.println("Concatena: ");
        printArray(Arrays.concatena(a,b));
        printDivisor();
        System.out.println("Permutazioni: ");
        printMultiDimensionalArray(Arrays.permutazioni(4));
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

    private static void printDivisor(){
        System.out.println("---------------------------------------------------------------");
    }

}
