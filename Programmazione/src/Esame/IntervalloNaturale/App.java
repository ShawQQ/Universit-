package Esame.IntervalloNaturale;/*
    Genera una classe chiamata IntervalloNaturale
    La casse ha due costruttori:
    1. il primo prende due Stringhe numeriche, con soli numeri
    tra i due, il primo deve essere minore o uguale del secondo
    es. IntervalloNaturale("10234765098", "9982345762") non va bene, perché il primo è più grande
    espone i metodi toString, che ritorna l'intervallo tra i due numeri separati da un "-"
    oppure semplicemente il numero stesso se l'intervallo è di un solo numero.
    Implementa equals e hashCode usando l'intervallo.

    espone anche i metodi:
    - compreso(string numero) che accetta un numero e torna true se:
        1. è una stringa numerica ed è un numero naturale
        2. è compreso tra i due numeri di intervallo

    Ha un secondo costruttore, che accetta però due intervalli.
    controlla che siano in qualche modo consecutivi. se tra i due intervalli ci sono dei
    numeri di differenza, lancia un'eccezione.
    es. 7-10 : 1-7 -> ERROR (il primo intervallo doveva stare prima, in funzione dei numeri iniziali di intervallo)
        1-7 : 5-10 -> SUCESS 1-10
        900-1000 : 900-910 -> SUCESS 900-1000 (si prendono gli estremi maggiori)
        1-7 : 7-10 -> SUCESS 1-10

    ATTENZIONE
    1. avete un'ora di tempo
    2. non usate fonti esterne o librerie aggiuntive di java
    3. suggerimento: ragiona per casi ed applica una logica "dividi e conquista"

    buon lavoro.
*/



public class App {

// come al solito, decommenta il main per testare


    public static void main(String[] args) throws Exception {
        try {
            // Test 1: Creazione intervallo valido
            IntervalloNaturale intervallo1 = new IntervalloNaturale("10", "20");
            if (intervallo1.toString().equals("10-20")) {
                System.out.println("Test 1: SUCCESSO");
            } else {
                System.out.println("Test 1: FALLIMENTO");
            }

            // Test 2: Creazione intervallo con stesso numero
            IntervalloNaturale intervallo2 = new IntervalloNaturale("5", "5");
            if (intervallo2.toString().equals("5")) {
                System.out.println("Test 2: SUCCESSO");
            } else {
                System.out.println("Test 2: FALLIMENTO");
            }

            // Test 3: Numero compreso nell'intervallo
            if (intervallo1.compreso("15")) {
                System.out.println("Test 3: SUCCESSO");
            } else {
                System.out.println("Test 3: FALLIMENTO");
            }

            // Test 4: Numero non compreso nell'intervallo
            if (!intervallo1.compreso("25")) {
                System.out.println("Test 4: SUCCESSO");
            } else {
                System.out.println("Test 4: FALLIMENTO");
            }

            // Test 5: Numero non valido (non numerico)
            if (!intervallo1.compreso("abc")) {
                System.out.println("Test 5: SUCCESSO");
            } else {
                System.out.println("Test 5: FALLIMENTO");
            }

            // Test 6: Creazione intervallo con ordine inverso (errore)
            try {
                IntervalloNaturale intervalloInvalid1 = new IntervalloNaturale("20", "10");
                System.out.println("Test 6: FALLIMENTO"); // Non dovrebbe arrivare a questa riga
            } catch (IllegalArgumentException e) {
                System.out.println("Test 6: SUCCESSO");
            }

            // Test 7: Costruttore con due intervalli consecutivi
            IntervalloNaturale intervalloConsecutivo1 = new IntervalloNaturale(new IntervalloNaturale("10", "20"), new IntervalloNaturale("20", "30"));
            if (intervalloConsecutivo1.toString().equals("10-30")) {
                System.out.println("Test 7: SUCCESSO");
            } else {
                System.out.println("Test 7: FALLIMENTO");
            }

            // Test 8: Costruttore con intervallo che non sono consecutivi (errore)
            try {
                IntervalloNaturale intervalloInvalid2 = new IntervalloNaturale(new IntervalloNaturale("10", "15"), new IntervalloNaturale("20", "30"));
                System.out.println("Test 8: FALLIMENTO"); // Non dovrebbe arrivare a questa riga
            } catch (IllegalArgumentException e) {
                System.out.println("Test 8: SUCCESSO");
            }

            // Test 9: Intervallo che si sovrappone (errore)
            try {
                IntervalloNaturale intervalloInvalid3 = new IntervalloNaturale(new IntervalloNaturale("5", "10"), new IntervalloNaturale("8", "12"));
                System.out.println("Test 9: FALLIMENTO"); // Non dovrebbe arrivare a questa riga
            } catch (IllegalArgumentException e) {
                System.out.println("Test 9: SUCCESSO");
            }

            // Test 10: Costruttore con intervallo che si estende (1-7 e 7-10)
            IntervalloNaturale intervalloSuccessivo1 = new IntervalloNaturale(new IntervalloNaturale("1", "7"), new IntervalloNaturale("7", "10"));
            if (intervalloSuccessivo1.toString().equals("1-10")) {
                System.out.println("Test 10: SUCCESSO");
            } else {
                System.out.println("Test 10: FALLIMENTO");
            }

            // Test 11: Numero non naturale
            if (!intervallo1.compreso("-5")) {
                System.out.println("Test 11: SUCCESSO");
            } else {
                System.out.println("Test 11: FALLIMENTO");
            }

            // Test 12: Intervallo che si estende (900-1000 e 900-910) - Corretto secondo le specifiche
            IntervalloNaturale intervallo900_1000 = new IntervalloNaturale("900", "1000");
            IntervalloNaturale intervallo900_910 = new IntervalloNaturale("900", "910");

            // Uniamo i due intervalli
            IntervalloNaturale intervalloSuccessivo2 = new IntervalloNaturale(intervallo900_1000, intervallo900_910);
            if (intervalloSuccessivo2.toString().equals("900-1000")) {
                System.out.println("Test 12: SUCCESSO");
            } else {
                System.out.println("Test 12: FALLIMENTO");
            }

            // Test 13: Verifica equality con intervallo uguale
            IntervalloNaturale intervalloUguale1 = new IntervalloNaturale("10", "20");
            if (intervallo1.equals(intervalloUguale1)) {
                System.out.println("Test 13: SUCCESSO");
            } else {
                System.out.println("Test 13: FALLIMENTO");
            }

            // Test 14: Verifica equality con intervallo diverso
            IntervalloNaturale intervalloDiverso1 = new IntervalloNaturale("10", "21");
            if (!intervallo1.equals(intervalloDiverso1)) {
                System.out.println("Test 14: SUCCESSO");
            } else {
                System.out.println("Test 14: FALLIMENTO");
            }

            // Test 15: Verifica hashCode uguale per intervallo uguale
            if (intervallo1.hashCode() == intervalloUguale1.hashCode()) {
                System.out.println("Test 15: SUCCESSO");
            } else {
                System.out.println("Test 15: FALLIMENTO");
            }

            // Test 16: Verifica hashCode diverso per intervallo diverso
            if (intervallo1.hashCode() != intervalloDiverso1.hashCode()) {
                System.out.println("Test 16: SUCCESSO");
            } else {
                System.out.println("Test 16: FALLIMENTO");
            }

            // Test 17: Creazione intervallo con numeri molto grandi
            IntervalloNaturale intervalloGrande = new IntervalloNaturale("999999999", "1000000000");
            if (intervalloGrande.toString().equals("999999999-1000000000")) {
                System.out.println("Test 17: SUCCESSO");
            } else {
                System.out.println("Test 17: FALLIMENTO");
            }

            // Test 18: Intervallo di un solo numero (10-10)
            IntervalloNaturale intervalloUnico = new IntervalloNaturale("10", "10");
            if (intervalloUnico.toString().equals("10")) {
                System.out.println("Test 18: SUCCESSO");
            } else {
                System.out.println("Test 18: FALLIMENTO");
            }

            // Test 19: Controllo se numero è compreso in un intervallo con intervallo unico
            if (intervalloUnico.compreso("10")) {
                System.out.println("Test 19: SUCCESSO");
            } else {
                System.out.println("Test 19: FALLIMENTO");
            }

            // Test 20: Intervallo con numeri negativi (non valido)
            try {
                IntervalloNaturale intervalloNegativo = new IntervalloNaturale("-10", "-5");
                System.out.println("Test 20: FALLIMENTO"); // Non dovrebbe arrivare a questa riga
            } catch (IllegalArgumentException e) {
                System.out.println("Test 20: SUCCESSO");
            }

            // Test 21: Controllo di un intervallo che parte da zero
            IntervalloNaturale intervalloZero = new IntervalloNaturale("0", "10");
            if (intervalloZero.toString().equals("0-10")) {
                System.out.println("Test 21: SUCCESSO");
            } else {
                System.out.println("Test 21: FALLIMENTO");
            }

            // Test 22: Controllo se numero "0" è compreso
            if (intervalloZero.compreso("0")) {
                System.out.println("Test 22: SUCCESSO");
            } else {
                System.out.println("Test 22: FALLIMENTO");
            }

            // Test 23: Costruttore con intervallo 1-7 e 7-10
            IntervalloNaturale intervalloContiguo1 = new IntervalloNaturale(new IntervalloNaturale("1", "7"), new IntervalloNaturale("7", "10"));
            if (intervalloContiguo1.toString().equals("1-10")) {
                System.out.println("Test 23: SUCCESSO");
            } else {
                System.out.println("Test 23: FALLIMENTO");
            }
            // Test 24: Intervallo con ordine non corretto
            try {
                IntervalloNaturale intervalloInvalidOrder = new IntervalloNaturale(new IntervalloNaturale("7", "5"), new IntervalloNaturale("10", "15"));
                System.out.println("Test 24: FALLIMENTO"); // Non dovrebbe arrivare a questa riga
            } catch (Exception e){
                System.out.println("Test 24: SUCCESSO"); 
            }
        }catch(Exception e){
            System.err.println(e);
        }
    }
}

