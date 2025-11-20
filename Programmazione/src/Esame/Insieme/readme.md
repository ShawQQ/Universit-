Si vuole modellare un insieme finito di numeri interi. A tal fine, definire una classe Insieme che memorizza in un array valori di tipo int. L'ordine con cui vengono memorizzati gli elementi dell'insieme non è specificato pertanto possono essere fatte scelte diverse, che porteranno a realizzazioni leggermente diverse dei metodi che seguono:

- Insieme(int n): costruttore, l'argomento "n" indica la dimensione massima dell'insieme. Il costruttore lancia un'eccezione runtime se "n" è negativo.

- boolean aggiungi(int x): aggiunge l'elemento "x" all'insieme. Se l'insieme ha già raggiunto la dimensione massima oppure se c'è già un elemento "x" nell'insieme il metodo non fa nulla e restituisce "false". Altrimenti, il metodo aggiunge "x" all'insieme e restituisce "true".

- boolean rimuovi(int x): rimuove l'elemento "x" dall'insieme. Restituisce "true" se "x" e` un elemento dell'insieme, "false" altrimenti.  Da notare che, in generale, il metodo può dover effettuare lo scorrimento di elementi dell'array successivi a quello rimosso.

- boolean contiene(int x): determina se "x" appartiene o no all'insieme, restituendo "true" o "false" di conseguenza.

- Insieme intersezione(Insieme that): calcola l'intersezione di "this" (oggetto ricevente) e "that" (argomento). L'insieme restituito è un *nuovo* oggetto, non è mai "null" e ne' "this" ne' "that" sono modificati in alcun modo. La dimensione massima dell'insieme intersezione può essere calcolata in modo arbitrario, purchè sia sufficientemente grande da contenere tutti gli elementi risultanti dall'operazione.

- Insieme unione(Insieme that): calcola l'unione di "this" (oggetto ricevente) e "that" (argomento). L'insieme restituito è un *nuovo* oggetto, non è mai "null" e ne' "this" ne' "that" sono modificati in alcun modo. La dimensione massima dell'insieme unione può essere calcolata in modo arbitrario, purchè sia sufficientemente grande da contenere tutti gli elementi risultanti dall'operazione.

- int dimensioneTotale(): restituisce il numero totale di elementi dell'insieme. 

-int dimensione(): restituisce il numero di elementi attualmente presenti nell'insieme.

ATTENZIONE. E` vietato l'uso di classi della libreria standard di Java ad eccezione di Math, String e delle sottoclassi di Exception.