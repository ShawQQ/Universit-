Si vuole definire una classe Vettore per modellare vettori [x1, ..., xn] n-dimensionali di numeri interi. Realizzare la classe Vettore in modo tale che le componenti del vettore siano memorizzate in un array di tipo int[] la cui lunghezza è pari alla dimensione del vettore. Definire i seguenti metodi:

    Vettore(int n): costruttore. L'argomento n indica la dimensione del vettore da creare. Il costruttore lancia un'eccezione runtime se n è negativo. Il vettore creato ha tutte le n componenti inizializzate a 0.

    int dimensione(): restituisce la dimensione del vettore.

    int get(int i): restituisce il valore della componente con indice i del vettore. Lancia un'eccezione runtime se i non è un indice valido, cioè se i è negativo oppure maggiore o uguale alla dimensione del vettore.

    Vettore set(int i, int x): assegna alla componente con indice i il valore x e restituisce this. Lancia un'eccezione runtime se i non è un indice valido.

    Vettore somma(Vettore that): calcola la somma vettoriale di this e that, ovvero il vettore le cui componenti sono le somme delle componenti corrispondenti di this e that. Lancia un'eccezione runtime se this e that sono vettori di dimensione diversa.
    [x1, ..., xn] + [y1, ..., yn] = [x1 + y1, ..., xn + yn]

    int scalare(Vettore that): calcola il prodotto scalare di this e that, ovvero la somma dei prodotti delle componenti corrispondenti.
    [x1, ..., xn] · [y1, ..., yn] = x1y1 + x2y2 + ... + xn*yn

    double norma(): calcola la norma di this, cioè la radice quadrata del prodotto scalare del vettore con sé stesso.

    boolean ordinato(): restituisce true se il vettore è ordinato (cioè se ogni componente è minore o uguale alla successiva), altrimenti false. Un vettore di dimensione 0 o 1 è sempre ordinato.

Attenzione: È vietato l'uso di classi della libreria standard di Java ad eccezione di Math, String e delle sottoclassi di Exception. In particolare, si può usare il metodo Math.sqrt per calcolare la radice quadrata di un numero in virgola mobile.