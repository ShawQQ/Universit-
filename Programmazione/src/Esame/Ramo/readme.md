Si vuole modellare un sistema per gestire rami di piante. Definire la classe  Ramo caratterizzato dalla lunghezza espressa in metri con un attributo di tipo float. Definire i seguenti metodi:

    Ramo(float v, int n) costruttore che crea un ramo di lunghezza v e che può avere al più n rami. Il costruttore lancia un'eccezione di tipo IllegalArgumentException se v o n sono negativi o 0.
    boolean aggiungi(Ramo s) aggiunge il ramo s al ramo in oggetto. Se il ramo da aggiungere è lo stesso del ramo in oggetto o se è null viene prodotto false. Se il ramo s è più lungo del ramo in oggetto o se si è raggiunto il numero massimo di rami che possono essere aggiunti al ramo in oggetto viene prodotto false altrimenti il ramo è aggiunto e viene prodotto true. 
    float getLunghezza() produce la lunghezza del ramo.
    Sovrascrivere il metodo  String toString() di modo che venga prodotta la stringa con il numero di sottorami e la lunghezza.
    float lunghezzaTotale() produce la somma delle lunghezze del ramo in oggetto e di tutti i suoi sotto rami che da lui dipartono.

ATTENZIONE:  é vietato l'uso di classi della libreria standard di Java ad eccezione di  String e delle sottoclassi di  Exception. Se utile, è possibile definire metodi ausiliari privati in aggiunta a quelli richiesti.