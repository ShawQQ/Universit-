public class Solutions {
    public static void main(String[] args){
        int[] test = {16, 0, 32, 63};

        /*for(int number : test){
            String a = Recursion.toBase(number, 2);
            String b = Recursion.toBase(number, 16);
            System.out.println("Base 2: " + a);
            System.out.println("Base 16: " + b);
        }*/

        int[] testPrime = {2, 4, 7, 12, 13};
        for(int number : testPrime){
            System.out.println(number + " è primo: " + (Recursion.isPrime(number) ? "Sì" : "No"));
        }
    }
}
