package Tutorato;

public class Cifrario {

    private static int SHIFT = 97;
    private static int ALPHABET_LENGTH = 26;
    public static void main(String[] args) throws Exception {
        String ciphertext= "";
        String plaintext = "Zia";

        printInt('a');
        printAlfabeto();
        shiftAlfabeto(1);
        int shift = 26;
        System.out.println(cifra(shift, plaintext));
        ciphertext = cifra(shift, plaintext);
        System.out.println(decifra(shift, ciphertext));

    }
   
    //-------------------------------------------------------------------------------------------
    //----------------------------------------CAESAR CYPHER--------------------------------------
    //-------------------------------------------------------------------------------------------
   
    // WIDENING : byte -> char -> short -> int -> long -> float -> double 
    // UNICODE -> ogni carattere è identificato da un numero
    public static void printInt (char a){
        System.out.println((int)a);
    }
    // Stampa l'alfabeto!
    public static void printAlfabeto() {
        for(int i = 0; i < 26; i++){
            System.out.println((char)(i + Cifrario.SHIFT));
        }
    }
    /* Sposta l'alfabeto di un valore k 
     SUGGERIMENTI: 1) Consiedera un alfabeto di 26 lettere 
                   2) Utilzza il cast esplicito  --->  (char)(lettera +..)*/
    public static void shiftAlfabeto(int k) {
        
    }
    /* Dato un numero k, se è positivo scorri l'alfabeto utilizzato di k posizioni.
     Se k è negativo scorri a sinistra 

     SUGGERIMENTO: 
     Consiedera un alfabeto di 26 lettere 
     Utilzza il cast esplicito  --->  (char)(lettera +..)

     k = 3 
     A  B  C  D  E  F  G  H..
     D  E  F  G  H  I  L  M.. */
    
     public static String cifra (int k, String plaintext){
         String encrypted = "";
         for(int i = 0; i < plaintext.length(); i++){
            encrypted += shift(plaintext.charAt(i), k);
         }
         return encrypted;
    }
    private static char shift(char c, int shift){
         char alphabetStart = shift > 0 ? 'a' : 'z';
         int start = Character.isUpperCase(c) ? Character.toUpperCase(alphabetStart) : alphabetStart;
         return (char)(((c-start+shift)%ALPHABET_LENGTH)+start);
    }
    public static String decifra (int k, String ciphertext){
        return cifra(-k, ciphertext);
    }
    public static String decifraPro (int key, String ciphertext){
        return "";
    }
}
      