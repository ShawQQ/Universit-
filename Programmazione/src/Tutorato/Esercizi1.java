package Tutorato;

import java.util.Arrays;

public class Esercizi1 {

    public static void main(String[] args) {
        int[] a = {1,2,3};
        rotateRight(a, 3);
        printArray(a);
        int[] b = {2,2,2,2,4,5,5,6,10,10,10,10};
        System.out.println(majorityElement(b));
        int[] f = {2,2,2,4};
        System.out.println(majorityElement(f));
        int[] c = {1,2,3,4,2,3,1,2,3,4,5};
        System.out.println(longestNonDecreasingRun(c));
        int[] d = {3,1,2,4};
        System.out.println(countInversions(d));
        int[] e = {2,2};
        printArray(twoSumIndices(e, 4));
        printArray(twoSumIndices(e, 5));
    }
    
    /**
     * Ruota a destra l'array di k posizioni, in place. Usa solo array.
     * Pre: a != null, k può essere qualunque intero (usa k mod a.length).
     */
    public static void rotateRight(int[] a, int k) {
        int[] copy = Arrays.copyOf(a, a.length);
        int current = 0;
        for(int i = 0; i+k < a.length; i++){
            a[i+k] = copy[i];
            current++;
        }
        for(int i = 0; i+current < a.length; i++){
            a[i] = copy[i+current];
        }
    }

    /**
     * Restituisce l'elemento di maggioranza (> n/2 occorrenze) oppure Integer.MIN_VALUE se non esiste.
     * Pre: a != null.
     */
    public static int majorityElement(int[] a) {
        int maxOccurences = 0;
        int maxIndex = 0;
        for(int i = 0; i < a.length; i++){
            int currentOccurrences = countOccurence(a,a[i]);
            if(currentOccurrences > maxOccurences){
                maxOccurences = currentOccurrences;
                maxIndex = i;
            }
        }
        return maxOccurences >= a.length / 2 ? a[maxIndex] : Integer.MIN_VALUE;
    }
    private static int countOccurence(int a[], int value){
        int total = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] == value){
                total++;
            }
        }
        return total;
    }

    /**
     * Lunghezza massima di una corsa non decrescente consecutiva.
     * Pre: a != null. Es: [1,2,2,1] -> 3.
     */
    public static int longestNonDecreasingRun(int[] a) {
        int maxRun = 0;
        int currentMax = 1;
        for(int i = 1; i < a.length; i++){
            if(a[i] < a[i-1]){
                maxRun = Math.max(maxRun, currentMax);
                currentMax = 1;
            }else{
                currentMax++;
            }
        }

        return Math.max(maxRun, currentMax);
    }

    /**
     * Conta il numero di inversioni (i<j, a[i] > a[j]) in O(n^2) usando solo array.
     * Pre: a != null.
     */
    public static long countInversions(int[] a) {
        int totalInversion = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = i+1; j < a.length; j++){
                if(a[i] > a[j]){
                    totalInversion++;
                }
            }
        }
        return totalInversion;
    }

    /**
     * Restituisce due indici i<j tali che a[i]+a[j]=target, oppure {-1,-1} se assente.
     * Pre: a != null.
     */
    public static int[] twoSumIndices(int[] a, int target) {
        for(int i = 0; i < a.length; i++){
            for(int j = i+1; j < a.length; j++){
                if(a[i] + a[j] == target){
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {-1,-1};
    }

    public static int max(int a, int b, int c){
        int firstMax = Math.max(a,b);
        return Math.max(firstMax, c);
    }

    public static int max(int[] a){
        int max = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] > max){
                max = a[i];
            }
        }
        return max;
    }

    public static void printArray(int[] a){
        System.out.print("[ ");
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println("]");
    }
}
