/**
 * Una partita di forza 4 ha le seguenti caratteristiche:
 * 1. un numero di righe, di default è 6
 * 2. un numero di colonne, di default è 6
 * 3. un numero di elementi consecutivinecessari per vincere, di default 4
 * 4. un numero di giocatori, di default è 2
 * 
 * Questa classe ha due costruttori, uno che accetta tutti e quattro gli argomenti, e un'altra che usa quelli di default
 * il numero di giocatori non può essere minore di 2 o maggiore del numero di elementi per vincere
 * il numero di righe o colonne non può essere minore del numero di elementi per vincere
 * il numero di elementi per vincere non può essere minore di tre
 * 
 * Questa classe esplone i seguenti metodi pubblici
 * 1. resetPartita, torna void, senza argomenti. si può sempre usare e la partita risulta non finita. i parametri restano gli stessi
 * 2. getVincitore, torna -1 se la partita non è finita, o il numero del giocatore corrispondente, ad iniziare dallo 0
 * 3. getGiocatore, torna il numero del giocatore di turno, ad iniziare da 0
 * 4. faiMossa, torna un booleano (true se la colonna era libera, false altrimenti) e segna che il giocatore di turno
 *      fa una mossa tramite la coordiata passate tramite parametro (quindi il metodo ha un parametro intero) che vanno da 0 a num di colonne -1.
 *      lancia un ClosedGameException se la partita è finita, e un IndexOutOfBoundsException se le coordinate sono fuori dalla griglia di gioco.
 *      ATTENZIONE ricorda che in forza 4 c'è la gravità, significa che, se una colonna non è piena, torna true e metti il segno nella posizione più in basso
 * 5. daiGriglia, non prende argomenti e ritorna un array int[][] di dimensione righe x colonne. nell'array c'è -1 se non ci sono segni, o il numero del giocatore, se ci ha giocato.
 *      attenzione, se l'array è contenuto anche dentro l'oggetto deve essere una copia, per evitare manipolazioni di memoria.
 */