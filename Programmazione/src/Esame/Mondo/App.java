package Esame.Mondo;

/*
  SIMULAZIONE D'ESAME

  Obiettivo:
  Creare due classi `Mondo` e `Portale` che simulano la connessione tra mondi tramite portali, 
  con una logica di gestione dei portali e delle loro caratteristiche.
   Ogni mondo avrà un codice univoco generato casualmente e la possibilità di connettersi ad altri mondi tramite portali.

  1. **Classe Mondo**:
      - Un mondo ha un codice univoco di 16 caratteri (a-z) generato casualmente tramite il random di java.
      - Ogni mondo può contenere un numero massimo di portali, `n`, dove `n` è maggiore di 0.
      - I metodi che devono essere implementati:
        - `toString`: deve restituire il codice univoco del mondo.
        - `equals` e `hashCode`: devono essere basati sul codice univoco per permettere il confronto tra mondi.
        - `aggiungiPortale`: deve aggiungere un portale se il mondo non è pieno, il portale non è `null`, 
                            il portale non connette lo stesso mondo e il portale non è già stato aggiunto.
        - `puoRaggiungere`: deve verificare se un mondo può raggiungere un altro mondo in un dato numero di passi 
                            (ricorsivamente, fino a `n` passi). Ha due argomenti, il codice del mondo di destinazione
                            e il numero di passi, maggiore o uguale di 0.

  2. **Classe Portale**:
      - Un portale è una connessione tra due mondi e ha un codice univoco che è la concatenazione del codice univoco dei due mondi.
      - I metodi che devono essere implementati:
        - `toString`: deve restituire il codice univoco del portale.
        - `equals` e `hashCode`: devono essere basati sul codice univoco per permettere il confronto tra portali.
        - Ogni portale deve essere creato con due mondi distinti. Se i mondi sono uguali, il portale non può essere creato.

  3. **Test del programma**:
      - Nella classe App sono stati commentati una serie di test mediamente esaustivi. preceduti da quello che il test
      ci si aspetta debba fare. Si possono aggiungere ulteriori test a piacere.

  **Requisiti**:
  - Il progetto deve essere completato in 1 ora.
  - Non sono ammesse fonti esterne. Tutto deve essere scritto autonomamente.
  - Assicurati che il codice sia ben strutturato e comprensibile.

  **Vincoli**:
  - Non utilizzare librerie Java oltre a `Random` per la generazione del codice univoco e per la gestione di numeri casuali.
  - Implementa tutte le funzionalità richieste senza fare affidamento su classi di libreria avanzate.
  - Ogni classe deve essere progettata in modo efficiente e senza l'uso di tecniche avanzate non richieste dalla consegna.
  
  Buon lavoro!
*/


public class App {

    public static void main(String[] args) {
        // Creazione di mondi
        Mondo mondo1 = new Mondo(3);
        Mondo mondo2 = new Mondo(3);
        Mondo mondo3 = new Mondo(3);
        Mondo mondo4 = new Mondo(3);
        Mondo mondo5 = new Mondo(3);
        Mondo mondo6 = new Mondo(3);
        
        // Creazione di portali tra mondi
        Portale p1 = new Portale(mondo1, mondo2);
        Portale p2 = new Portale(mondo2, mondo3);
        Portale p3 = new Portale(mondo3, mondo4);
        Portale p4 = new Portale(mondo4, mondo5);
        Portale p5 = new Portale(mondo5, mondo6);
        Portale p6 = new Portale(mondo2, mondo4);
        Portale p7 = new Portale(mondo1, mondo5);
        
        // Aggiunta di portali ai mondi
        System.out.println("Aggiungiamo portali ai mondi...");
        System.out.print("Dovrebbe essere un successo: ");
        aggiungiPortaleSePosso(mondo1, p1);
        System.out.print("Dovrebbe essere un successo: ");
        aggiungiPortaleSePosso(mondo2, p2);
        System.out.print("Dovrebbe essere un successo: ");
        aggiungiPortaleSePosso(mondo3, p3);
        System.out.print("Dovrebbe essere un successo: ");
        aggiungiPortaleSePosso(mondo4, p4);
        System.out.print("Dovrebbe essere un successo: ");
        aggiungiPortaleSePosso(mondo5, p5);
        System.out.print("Dovrebbe essere un successo: ");
        aggiungiPortaleSePosso(mondo2, p6);
        System.out.print("Dovrebbe essere un successo: ");
        aggiungiPortaleSePosso(mondo1, p7);
        
        // Verifica se un mondo può raggiungere un altro mondo in vari passi
        System.out.println("\nTest di raggiungibilità:");
        System.out.print("Dovrebbe essere un fallimento: ");
        testRaggiungibilità(mondo1, mondo6, 1);  // 1 passo
        System.out.print("Dovrebbe essere un successo: ");
        testRaggiungibilità(mondo1, mondo6, 2);  // 2 passi
        System.out.print("Dovrebbe essere un fallimento: ");
        testRaggiungibilità(mondo1, mondo4, 1);  // 1 passo
        System.out.print("Dovrebbe essere un successo: ");
        testRaggiungibilità(mondo1, mondo4, 3);  // 3 passi
        System.out.print("Dovrebbe essere un successo: ");
        testRaggiungibilità(mondo1, mondo3, 2);  // 2 passi
        System.out.print("Dovrebbe essere un fallimento: ");
        testRaggiungibilità(mondo5, mondo1, 3);  // 3 passi
        System.out.print("Dovrebbe essere un successo: ");
        testRaggiungibilità(mondo2, mondo5, 2);  // 2 passi
        System.out.print("Dovrebbe essere un fallimento: ");
        testRaggiungibilità(mondo6, mondo1, 5);  // 5 passi

        // Test di portali duplicati (non dovrebbero essere aggiunti)
        Portale p8 = new Portale(mondo1, mondo5);  // Portale duplicato di p7
        System.out.print("Dovrebbe essere un fallimento: ");
        aggiungiPortaleSePosso(mondo1, p8);  // Non dovrebbe essere aggiunto

        // Proviamo a superare la capacità di portali
        Portale p9 = new Portale(mondo1, mondo4);
        Portale p10 = new Portale(mondo1, mondo3);
        System.out.print("Dovrebbe essere un successo: ");
        aggiungiPortaleSePosso(mondo1, p9);
        System.out.print("Dovrebbe essere un fallimento: ");
        aggiungiPortaleSePosso(mondo1, p10);  // Questo dovrebbe fallire, capacità di 3 portali raggiunta
    }

    private static void aggiungiPortaleSePosso(Mondo mondo, Portale portale) {
        if (mondo.aggiungiPortale(portale)) {
            System.out.println("Portale aggiunto con successo: " + portale.toString());
        } else {
            System.out.println("Impossibile aggiungere il portale: " + portale.toString());
        }
    }

    private static void testRaggiungibilità(Mondo partenza, Mondo destinazione, int passi) {
        System.out.println("Mondo " + partenza.getCodiceUnivoco() +
            " può raggiungere il mondo " + destinazione.getCodiceUnivoco() + " in " + passi + " passi? " +
            partenza.puoRaggiungere(destinazione, passi));
    }

}
