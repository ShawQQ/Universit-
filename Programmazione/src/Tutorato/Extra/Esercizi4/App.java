package Tutorato.Extra.Esercizi4;

public class App {
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

        if(reverseString("aaaab").equals("baaaa") && reverseString("hello").equals("olleh")
        && reverseString("Java").equals("avaJ") && reverseString("").equals("")) {
            System.out.println("reverseString funziona!");
        } else {
            System.out.println("reverseString NON funziona!");
        }

        if(countOccurrences("hello", 'l') == 2 && countOccurrences("world", 'o') == 1
        && countOccurrences("Java", 'a') == 2 && countOccurrences("test", 'z') == 0) {
            System.out.println("countOccurrences funziona!");
        } else {
            System.out.println("countOccurrences NON funziona!");
        }

        if(!isPalindromeFixed("aAaBa") && isPalindromeFixed("I topi non avevano nipoti")
        && !isPalindromeFixed("hello") && isPalindromeFixed("madam in eden, i'm adam")) {
            System.out.println("isPalindromeFixed funziona!");
        } else {
            System.out.println("isPalindromeFixed NON funziona!");
        }

        if(countWords("Hello world") == 2 && countWords("  This  is   a test ") == 4
        && countWords("") == 0 && countWords("SingleWord") == 1) {
            System.out.println("countWords funziona!");
        } else {
            System.out.println("countWords NON funziona!");
        }

        if(replaceWithMemory("hello world", "world", "Java")[0].equals("hello world")
        && replaceWithMemory("ababab", "ab", "cd")[1].equals("cdcdcd")
        && replaceWithMemory("ababab", "ab", "cd")[0].equals("ababab")
        && replaceWithMemory("test test test", "test", "exam")[1].equals("exam exam exam")) {
            System.out.println("replaceWithMemory funziona!");
        } else {
            System.out.println("replaceWithMemory NON funziona!");
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
        if(a == null) return b == null;
        return a.toLowerCase().equals(b.toLowerCase());
    }

    /**
     * Converte una stringa esadecimale in un intero.
     * Esempio: "1A" -> 26
     * @param hex
     * @return
     */
    public static int fromExadecimal(String hex) {
        int sum = 0;
        for(int i = 0; i < hex.length(); i++){
            char c = hex.toLowerCase().charAt(i);
            int number = c >= '0' && c <= '9' ? c - '0' : c - 'a' + 10;
            sum *= 16;
            sum += number;
        }
        return sum;
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
        return index < 0 || index >= s.length() ? defaultChar : s.charAt(index);
    }

    //--------------------------------------------------------------//
    // Esercizi di Stringhe da debuggare.                           //
    //--------------------------------------------------------------//

    /**
     * Resituisci la stringa s al contrario.
     * @param s
     * @return
     */
    public static String reverseString(String s) {
        String result = "";
        for(int i = 0; i < s.length(); i ++){
            result = s.charAt(i) + result;
        }
        return result;
    }

    /**
     * Conta quante volte il carattere target appare nella stringa s.
     * @param s
     * @param target
     * @return
     */
    public static int countOccurrences(String s, char target) {
         int count = 0;
        for(int i = 0; i < s.length(); i ++){
            count += s.charAt(i) == target ? 1 : 0;
        }
        return count;
    }

    //--------------------------------------------------------------//
    // Esercizi di Stringhe opzionali per casa.                     //
    //--------------------------------------------------------------//

    /**
     * Restituisci true se la stringa è un palindromo, ignorando spazi, caratteri speciali e maiuscole.
     * Esempio: "I topi non avevano nipoti" -> true.
     * @param s
     * @return
     */
    public static boolean isPalindromeFixed(String s) {
        if(s == null || s.isEmpty()) return false;
        String toCheck = normalizeString(s);
        for(int i = 0; i < toCheck.length() / 2; i++){
            if(toCheck.charAt(i) != toCheck.charAt(toCheck.length() - i - 1)) return false;
        }
        return true;
    }
    private static String normalizeString(String s){
        String result = s.trim().toLowerCase();
        String[] notAllowed = new String[] {
                ",",
                ".",
                "'",
                " "
        };
        for(int i = 0; i < notAllowed.length; i++){
            result = result.replace(notAllowed[i], "");
        }
        return result;
    }

    /**
     * Esercizio 8:
     * Suddividi la stringa s in parole (split su spazio) e restituisci la lunghezza dell’array.
     * Considera spazi multipli.
     */
    public static int countWords(String s) {
        int count = 0;
        String[] split = s.split(" ");
        for(int i = 0; i < split.length; i++){
            if(!split[i].isEmpty()) count++;
        }
        return count;
    }

    /**
     * Esercizio 9:
     * Sostituisci tutte le occorrenze della sottostringa oldSub con newSub.
     * Usa il metodo replace().
     */
    public static String[] replaceWithMemory(String s, String oldSub, String newSub) {
        return new String[]{s,s.replaceAll(oldSub, newSub)};
    }
}
