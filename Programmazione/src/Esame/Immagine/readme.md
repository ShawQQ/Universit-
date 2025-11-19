Si vuole realizzare un sistema di gestione di immagini quadrate in bianco e nero. Definire la classe Immagine composta dall'attributo pixels, una matrice quadrata di valori booleani, dove false indica un pixel spento e true un pixel acceso.

Definire i seguenti metodi:

- Il costruttore Immagine(int n) produce un'eccezione IllegalArgumentException se il valore di n è minore o uguale a zero. Il costruttore inizializza un'immagine di dimensione n con tutti i pixel spenti.

- int getDimensione() produce la dimensione dell'immagine.

- boolean getPixel(int i, int j) produce il valore del pixel nella posizione i,j. Viene prodotta un'eccezione IllegalArgumentException se i valori di i e j sono minori di zero o maggiori o uguali alla dimensione dell'immagine.

- boolean setPixel(int i, int j, boolean v) assegna il valore v al pixel in posizione i, j e viene prodotto true se i e j sono maggiori o uguali a zero e minori delle dimensioni di pixels. Viene prodotto false altrimenti.

- Immagine maschera(Immagine a) produce una nuova immagine come and dei valori corrispettivi se le dimensioni dell'immagine a e dell'immagine in oggetto sono uguali, altrimenti viene prodotta un'eccezione IllegalArgumentException.

- Immagine negativo() produce una nuova immagine della stessa dimensione in cui tutti i valori dei pixel sono negati.

- int focus(int r, int c, int k) conta il numero di pixel true che sono nel quadrato con centro r e c e lato 2k+1. Ad esempio, con parametri r=3, c=3 e k=2, il quadrato corrispondente ha i suoi spigoli nelle coordinate (1,1), (1,5), (5,1) e (5,5). Viene prodotta un'eccezione di tipo IllegalArgumentException se il quadrato indica una zona fuori dell'immagine.