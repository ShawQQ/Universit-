Si vuole definire una classe Polinomio per rappresentare polinomi come array [c0, c1, ..., c(n-1)] di coefficienti di tipo float. Chiamiamo n (la lunghezza dell'array) dimensione del polinomio.
Per esempio, l'array [4, 2, 1] rappresenta il polinomio 4 + 2x + x^2 di dimensione 3.

Definire i seguenti metodi:

    Polinomio(int n): costruttore. L'argomento n indica la dimensione del polinomio da creare. Il costruttore lancia un'eccezione runtime se n è negativo. Il polinomio creato ha tutti i coefficienti inizializzati a 0.

    int dimensione(): restituisce la dimensione del polinomio, ovvero la lunghezza dell'array che ne contiene i coefficienti.

    float get(int i): restituisce il valore del coefficiente con indice i del polinomio.
    Lancia un'eccezione runtime se i è negativo.
    Restituisce 0 se i è maggiore o uguale alla dimensione del polinomio (in questo modo si assume che tutti i coefficienti oltre la dimensione siano 0).

    void set(int i, float x): assegna al coefficiente con indice i il valore x.
    Lancia un'eccezione runtime se i è negativo oppure maggiore o uguale alla dimensione del polinomio.

    Polinomio somma(Polinomio that): calcola la somma tra this e that, ovvero il polinomio la cui dimensione è il massimo tra le dimensioni di this e that, e i cui coefficienti sono la somma dei coefficienti corrispondenti di this e that.

    float valore(float x): valuta il polinomio, ovvero calcola la quantità:
    c0 * x^0 + c1 * x^1 + ... + c(n-1) * x^(n-1)
    dove [c0, ..., c(n-1)] sono i coefficienti del polinomio.
    Suggerimento: usare il metodo Math.pow per calcolare la potenza i-esima di x.

ATTENZIONE

È vietato l'uso di classi della libreria standard di Java ad eccezione di Math, String e delle sottoclassi di Exception.
In particolare, si può usare il metodo Math.pow per calcolare la potenza di un numero in virgola mobile.