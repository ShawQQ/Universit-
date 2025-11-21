package Tutorato;

public class App2 {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    /**
     * Dato un numero n, conta il numero di 1 nella sua rappresentazione binaria.
     * Es. 5 -> 101 -> 2
     * Es. 7 -> 111 -> 3
     * Es. 10 -> 1010 -> 2
     * ...
     * Suggerimento: usare l'operatore AND bit a bit (&).
     * @param n
     * @return
     */
    public int countOnesIntoBinary(int n) {
        int count = 0;
        while(n > 0){
            if((n & 1) == 1) count++;
            n = n>>1;
        }
        return count;
    }

    /**
     * Dato un array di booleani, restituisce true se il numero di true e false
     * sono uguali, false altrimenti.
     * Suggerimento: ci sono casi in cui torna sempre false?
     * Suggerimento 2: data la dimensione dell'array, ti serve contare entrambi i valori?
     * @param array
     * @return
     */
    public boolean isBalancedBooleanArray(boolean[] array) {
        if(array.length % 2 == 1) return false;
        int count = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i]){
                count++;
            }else{
                count--;
            }
        }
        return count == 0;
    }
}
