package Tutorato.Settimana5;

public class App {
    public static void main(String[] args) throws Exception {
        final String frase = "La vita, se ben vissuta, è lunga abbastanza.";
        /*
            parte 1
            frase è un OGGETTO, e contiene molti metodi
            usa i metodi delle stringhe ( substring replace indexOf toCharArray split )
            per manipolare la frase e stampare a schermo le seguenti cose:
            1. il testo senza punteggiatura
            2. la seconda parola in maiuscolo
            3. la frase due volte
            4. la frase al contrario
            5. la posizione di tutte le a <--- difficile
            
            ATTENZIONE non potete modificare frase, o dichiarare altre variabili. 
            (fatta eccezione per dell'indice di un for)
        */
        System.out.println(
                frase
                        .replaceAll(",", "")
                        .replaceAll("\\.", "")
                        .replaceAll("'", "")
                        .replaceAll(";", "")
                        .replaceAll(";", "")
        );
        System.out.println(frase.split(" ")[1].toUpperCase());
        System.out.println(frase + frase);
        for(int i = frase.length() - 1; i >= 0; i--){
            System.out.print(frase.charAt(i));
        }
        int i = 0;
        while(frase.indexOf("a", i) > -1){
            System.out.println(frase.indexOf("a", i));
            i = frase.indexOf("a", i) + 1;
        }
    }

    /**
     * -----parte 2---------
     * Genera i seguenti metodi statici.
     * Non è necessario il corpo del metodo, basta che non dia errore.
     * 
     * 1. sommaArray
     * argomenti: 2 array di float
     * ritorno: array di float
     * 
     * 2. leggiFIle
     * argomenti: 1 string come path del file
     * ritorno: array di stringhe
     * 
     * 3. stampaPer
     * argomenti: 1 stringa e 1 int
     * ritorno: void
     * 
     * 4. concatena
     * argomenti: 1 array di stringhe, 1 stringa
     * ritorno: stringa
     */
    private static float[] sommaArray(float[] first, float[] second){
        return new float[]{};
    }
    private static String[] leggiFile(String path){
        return new String[]{};
    }
    private static void stampaPer(String s, int n){}
    private static String concatena(String[] strings, String s){
        return "";
    }
}
