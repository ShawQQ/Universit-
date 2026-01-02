Genera una classe chiamata IntervalloNaturale
    La casse ha due costruttori:
    1. il primo prende due Stringhe numeriche, con soli numeri
    tra i due, il primo deve essere minore o uguale del secondo
    es. IntervalloNaturale("10234765098", "9982345762") non va bene, perché il primo è più grande
    espone i metodi toString, che ritorna l'intervallo tra i due numeri separati da un "-"
    oppure semplicemente il numero stesso se l'intervallo è di un solo numero.
    Implementa equals e hashCode usando l'intervallo.

    espone anche i metodi:
    - compreso(string numero) che accetta un numero e torna true se:
        1. è una stringa numerica ed è un numero naturale
        2. è compreso tra i due numeri di intervallo

    Ha un secondo costruttore, che accetta però due intervalli.
    controlla che siano in qualche modo consecutivi. se tra i due intervalli ci sono dei
    numeri di differenza, lancia un'eccezione.
    es. 7-10 : 1-7 -> ERROR (il primo intervallo doveva stare prima, in funzione dei numeri iniziali di intervallo)
        1-7 : 5-10 -> SUCESS 1-10
        900-1000 : 900-910 -> SUCESS 900-1000 (si prendono gli estremi maggiori)
        1-7 : 7-10 -> SUCESS 1-10

    ATTENZIONE
    1. avete un'ora di tempo
    2. non usate fonti esterne o librerie aggiuntive di java
    3. suggerimento: ragiona per casi ed applica una logica "dividi e conquista"

    buon lavoro.