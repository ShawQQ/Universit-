Si vuole definire una classe Matrice per modellare matrici rettangolari di numeri di tipo int. Nel resto dell'esercizio, indichiamo con m il numero di righe e con n il numero di colonne della matrice. Realizzare la classe Matrice in modo tale che le componenti della matrice siano memorizzate in un array di array di tipo int[][]. Definire i seguenti metodi:

    Matrice(int m, int n): costruttore. L'argomento m indica il numero di righe della matrice e l'argomento n indica il numero di colonne. Il costruttore lancia un'eccezione runtime se m o n sono minori o uguali a zero. La matrice creata ha tutti gli elementi inizializzati a 0.

    int righe(): restituisce m, ovvero il numero di righe della matrice.

    int colonne(): restituisce n, ovvero il numero di colonne della matrice.

    int get(int i, int j): se 0 ≤ i < m e 0 ≤ j < n, restituisce il valore dell'elemento della matrice in posizione (i, j). Altrimenti, lancia un'eccezione runtime.

    void set(int i, int j, int x): se 0 ≤ i < m e 0 ≤ j < n, imposta l'elemento della matrice in posizione (i, j) al valore x. Altrimenti, lancia un'eccezione runtime.

    int[] riga(int i): se 0 ≤ i < m, restituisce la riga con indice i della matrice. Altrimenti, lancia un'eccezione runtime.

    int[] colonna(int j): se 0 ≤ j < n, restituisce la colonna con indice j della matrice. Altrimenti, lancia un'eccezione runtime.

    Matrice somma(Matrice that): se this e that hanno le stesse dimensioni, calcola la somma matriciale di this e that. Altrimenti, lancia un'eccezione runtime. L'elemento in posizione (i, j) della somma corrisponde alla somma degli elementi nella stessa posizione in this e that. Il metodo non deve modificare le matrici originali.

    Matrice trasposta(): calcola la matrice trasposta di this, ovvero la matrice in cui l'elemento in posizione (i, j) corrisponde a quello in posizione (j, i) di this. Il metodo non deve modificare in alcun modo la matrice originale.

ATTENZIONE

È vietato l'uso di classi della libreria standard di Java, ad eccezione di Math, String e delle sottoclassi di Exception.