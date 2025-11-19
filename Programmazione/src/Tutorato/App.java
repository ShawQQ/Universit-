package Tutorato;

public class App {
    public static void main(String[] args) throws Exception {
        if(potenzaDiDue(2) && potenzaDiDue(1024) && potenzaDiDue(8) && potenzaDiDue(1) 
        && !potenzaDiDue(-2) && !potenzaDiDue(5) && !potenzaDiDue(27) && !potenzaDiDue(6))
            System.out.println("potenzaDiDue -> successo");
        else System.out.println("potenzaDiDue -> fallimento");

        if(sommaSicura(12, 24) == 36 && sommaSicura(47, -30) == 17 
        && sommaSicura(2000000000, 2000000000) == Integer.MAX_VALUE
        && sommaSicura(-2000000000, -2000000000) == Integer.MIN_VALUE)
            System.out.println("sommaSicura -> successo");
        else System.out.println("sommaSicura -> fallimento");

        if(daDecimaleABinario(10).equals("1010") 
        && daDecimaleABinario(1000).equals("1111101000") 
        && daDecimaleABinario(4).equals("100")  
        && daDecimaleABinario(27).equals("11011") )
            System.out.println("daDecimaleABinario -> successo");
        else System.out.println("daDecimaleABinario -> fallimento");
    }

    /**
     * Questo metodo ritorna true se e solo se
     * il valore passato è una potenza di due
     * alcuni esempi di numeri che tornato true
     * sono 2, 1024, 8, 1...
     * si consiglia di usare la ricorsione
     * @param n
     * @return
     */
    public static boolean potenzaDiDue(int n){
        if(n < 0) return false;
        if(n == 1 || n == 2) return true;
        if(n % 2 == 1) return false;
        return potenzaDiDue(n / 2);
    }

    /**
     * Questa somma restituisce a + b
     * attenzione, se il risultato è minore del 
     * valore più basso accettato da int,
     * o più alto accettato, restituisce i limiti
     * a cui il tipo è sottoposto
     * es. 12 + 24 = 36
     * es. 47 + -30 = 17
     * es. 2000000000 + 2000000000 = 2147483647 (Integer.MAX_VALUE)
     * es. -2000000000 + -2000000000 = -2147483648 (Integer.MIN_VALUE)
     * @param a
     * @param b
     * @return
     */
    public static int sommaSicura(int a, int b){
        long sum = (long)a+b;
        if(sum > Integer.MAX_VALUE){
            sum = Integer.MAX_VALUE;
        }else if(sum < Integer.MIN_VALUE){
            sum = Integer.MIN_VALUE;
        }
        return (int)sum;
    }

    /**
     * Questo metodo realizza una stringa in binario
     * corrispondente al valore decimale del parametro
     * in ingresso.
     * Es. 10 -> "1010"
     * Es. 1000 -> "1111101000"
     * Es. 4 -> "100"
     * Es. 27 -> "11011"
     * @param n
     * @return
     */
    public static String daDecimaleABinario(int n){
        String result = "";
        String sign = "";
        if(n < 0){
            sign = "-";
            n = n * -1;
        }
        do{
            result = (n % 2) + result;
            n = n / 2;
        }while(n > 0);
        return sign+result;
    }
}
