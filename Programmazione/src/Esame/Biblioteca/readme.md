/*
Impementare la classe Libro e Biblioteca
Libro ha due proprieta' String, titolo e autore
il costruttore accetta entrambi e controlla:
- che non siano null
- che abbiano almeno un carattere ciascuno
  per entrambe le proprieta', implementare i getter e l'equals

Biblioteca ha un costruttore con due parametri
int max (numero massimo di libri da inserire) (> 0)
float mora (costo giornaliero per ogni giorno di ritardo di un prestito) (> 0.0)
esporre i seguenti metodi:

public boolean aggiungiLibro(Libro l)
lancia una eccezione se l è null.
torna true se il libro è stato aggiunto, false altrimenti (x mancanza di spazio)

public String[][] daiTutti()
ritorna tutti i libri aggiunti in una matrice di stringhe
se ad esempio ci sono tre libri, il risultato dovrebbe essere:
[["titolo1", "autore1"],["titolo2", "autore2"],["titolo3", "autore3"]]

public boolean prestaLibro(String titolo, String autore)
lancia un eccezione se titolo o autore non sono consoni x un libro
torna false se non c'e' il libro o non e' disponibile
torna true se il libro c'e' ed e' disponibile, e segna che e' stato prestato

public float restituisciLibro(String titolo, String autore, int giorniDiRitardo)
lancia un eccezione se titolo o autore non sono consoni x un libro, o giorniDiRitardo < 0
torna -1 se non c'e' il libro o non e' in prestito
torna mora*giorniDiRitardo se il libro c'e' ed e' in prestito, e segna che e' di nuovo disponibile

non esporre altri metodi pubblici oltre a quelli indicati
vietato usare classi estrne oltre a String, Object e i figli di Exception
*/