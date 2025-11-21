Si vuole definire una classe Filetto per giocare a una generalizzazione del gioco tris su una griglia di dimensione n x n. La griglia è modellata con un array bidimensionale di tipo char[][], i cui elementi possono essere:

    il carattere ' ' (spazio), che indica una casella vuota,

    il carattere 'X' o il carattere 'O', che rappresentano i due giocatori.

L'obiettivo del gioco è completare una riga, una colonna o una diagonale della griglia con caratteri dello stesso giocatore. Definire i seguenti metodi:

    Filetto(int n): costruttore. L'argomento n indica il numero di righe e colonne della griglia.
    Il costruttore lancia un'eccezione runtime se n è minore di 3.
    La griglia creata ha tutte le caselle inizializzate a ' ' (spazio).

    boolean gioca(int i, int j, char c): se 0 <= i < n, 0 <= j < n, c è 'X' oppure 'O' e la casella (i, j) è vuota (cioè contiene uno spazio), allora assegna il carattere c a quella casella e restituisce true. Altrimenti non fa nulla e restituisce false.

    boolean vinceRiga(int i, char c): restituisce true se 0 <= i < n e tutta la riga i è composta dal carattere c. Altrimenti restituisce false.

    boolean vinceColonna(int j, char c): restituisce true se 0 <= j < n e tutta la colonna j è composta dal carattere c. Altrimenti restituisce false.

    boolean vinceDiagonale(char c): restituisce true se una delle due diagonali della griglia è composta interamente dal carattere c. Altrimenti restituisce false.

    Nell'esempio della griglia sopra, il metodo restituirebbe true se chiamato con 'O' e false se chiamato con 'X'.

    boolean vince(char c): restituisce true se il giocatore c ha completato una riga, una colonna o una diagonale. Altrimenti restituisce false.
    Il metodo deve usare i metodi vinceRiga, vinceColonna e vinceDiagonale.

    String toString(): restituisce una stringa di lunghezza n * n che rappresenta l’intera griglia.
    Per esempio, per la griglia mostrata sopra il metodo restituirà: "X O XO OX O ".

ATTENZIONE

È vietato l'uso di classi della libreria standard di Java ad eccezione di String e delle sottoclassi di Exception. Se utile, è possibile definire metodi ausiliari privati oltre a quelli richiesti.