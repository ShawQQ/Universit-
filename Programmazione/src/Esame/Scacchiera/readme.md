Realizzare la classe Scacchiera, caratterizzata da una dimensione n, che contiene solo pezzi di tipo cavallo, tutti dello stesso colore. Una scacchiera è una griglia quadrata: la sua dimensione è il numero di righe e colonne. Gli elementi della griglia sono chiamati caselle.

Definire i seguenti metodi:

- Il costruttore Scacchiera(int n) che crea una scacchiera di dimensione n. Lancia un'eccezione IllegalArgumentException se il parametro n è minore o uguale a zero.

- dimensione() che restituisce la dimensione della scacchiera.

- contienePezzo(int i, int j) che restituisce true se la casella in posizione (i, j) contiene un pezzo. Restituisce false se la casella è vuota o se le coordinate non sono valide.

- aggiungiPezzo(int i, int j) che aggiunge un cavallo nella posizione (i, j). Restituisce true se la casella era vuota e il pezzo è stato aggiunto, false se la casella è già occupata o se le coordinate non sono valide.

- mossaValida(int i, int j, int k, int w) che restituisce true se la casella (i, j) contiene un cavallo e questo può muoversi alla posizione (k, w) secondo le regole del cavallo. La mossa è valida solo se la casella di arrivo è vuota. Restituisce false in caso contrario.

- dominata(int i, int j) che restituisce true se la casella (i, j) è vuota ed esiste almeno un cavallo che può muoversi in quella posizione con una mossa valida.

- sposta(int i, int j, int k, int w) che sposta il cavallo dalla posizione (i, j) alla posizione (k, w). Restituisce true se la mossa è valida ed è stata eseguita con successo, false altrimenti.

- conta(int i, int j) che restituisce il numero di cavalli che possono raggiungere la posizione (i, j) con una sola mossa. Se la posizione non è valida, restituisce 0.