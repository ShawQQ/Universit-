package Tutorato;

public class App3 {
    public static void main(String[] args) throws Exception {
        if(equalsIgnoreCase("hello", "HELLO") && !equalsIgnoreCase("hello", "world")
        && equalsIgnoreCase("Java", "java") && !equalsIgnoreCase("Java", "JavaScript")
        && equalsIgnoreCase("", "") && !equalsIgnoreCase(" ", "")) {
            System.out.println("equalsIgnoreCase funziona!");
        } else {
            System.out.println("equalsIgnoreCase NON funziona!");
        }

        if(fromExadecimal("0") == 0 && fromExadecimal("1A") == 26 
        && fromExadecimal("FF") == 255 && fromExadecimal("A0") == 160
        && fromExadecimal("10") == 16 && fromExadecimal("7B") == 123) {
            System.out.println("fromExadecimal funziona!");
        } else {
            System.out.println("fromExadecimal NON funziona!");
        }

        if(charAtIndex("hello", 1, 'x') == 'e' 
        && charAtIndex("world", 4, 'y') == 'd'
        && charAtIndex("java", 0, 'z') == 'j'
         && charAtIndex("test", 10, 't') == 't'
        && charAtIndex("", 0, 'a') == 'a') {
            System.out.println("charAtIndex funziona!");
        } else {
            System.out.println("charAtIndex NON funziona!");
        }
    }

    //--------------------------------------------------------------//
    // Esercizi di Stringhe da completare.                          //
    //--------------------------------------------------------------//

    /**
     * Confronta due stringhe ignorando le differenze tra maiuscole e minuscole.
     * @param a
     * @param b
     * @return
     */
    public static boolean equalsIgnoreCase(String a, String b) {
        return a.toLowerCase().equals(b.toLowerCase());
    }

    /**
     * Converte una stringa esadecimale in un intero.
     * Esempio: "1A" -> 26
     * @param hex
     * @return
     */
    public static int fromExadecimal(String hex) {
        int number = 0;
        for(int i = hex.length() - 1; i >= 0; i--){
            number += convertHexCharToInt(hex.charAt(i)) * Math.pow(16, hex.length() - i - 1);
        }
        return number;
    }
    private static int convertHexCharToInt(char c){
        return Character.getNumericValue(c);
    }

    /**
     * Restituisci il carattere alla posizione index della stringa s.
     * Se l'indice è fuori dai limiti della stringa, restituisci defaultChar.
     * @param s
     * @param index
     * @param defaultChar
     * @return
     */
    public static char charAtIndex(String s, int index, char defaultChar) {
        return index < s.length() ? s.charAt(index) : defaultChar;
    }
}
