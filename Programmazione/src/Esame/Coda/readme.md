Si vuole gestire un sistema di prenotazione di visite mediche. Il sistema prevede la possibilità di prenotarsi indicando nome e cognome.

Definire la classe Visita caratterizzata da due attributi nome e cognome di tipo String nome e cognome. Definire il costruttore di Visita con due parametri, nome e cognome, che lancia un'eccezione runtime se nome o cognome sono nulli o sono stringhe con meno di due caratteri. Dotare la classe di opportuni metodi getter.

Definire la classe Coda che permette di inserire oggetti di tipo Visita. La classe Coda è caratterizzata da un attributo coda di tipo array di Visita e da un intero indicante il numero di prenotazioni. Il costruttore di Coda ha un parametro intero indicante il numero massimo di prenotazioni che possono essere gestite. Tale costruttore lancia un'eccezione runtime se il parametro è negativo.  Definire quindi i seguenti metodi di Coda:

- boolean inserimento(Visita v) che inserisce una prenotazione in fondo alla coda e restituisce true se ha successo. Il metodo non effettua alcuna prenotazione e restituisce false se il numero massimo di prenotazioni è stato raggiunto.

- Visita estrazione() che preleva e cancella la prima prenotazione della coda. Il metodo restituisce null se la coda è vuota.

- boolean cancellazione(String nome, String cognome) che cancella la prenotazione del paziente nome, cognome.

- int getNumero() che restituisce il numero di prenotazioni nella coda.

Notare che i metodi estrazione e cancella devono mantenere l'ordine delle prenotazioni che rimangono nella coda, compattando opportunamente gli elementi dell'array coda. Se utile, è possibile definire metodi ausiliari (privati) della classe Coda.


