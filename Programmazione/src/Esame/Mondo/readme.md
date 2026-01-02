
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