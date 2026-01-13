    Implementare due classi:
    Cavallo.java
    CorsaDiCavalli.java
    Cavallo è una classe con le seguenti proprietà, tutte gestite da appositi getter e setter (il nome è immutabile):
    - String nome
    - int eta
    - int numeroVittorie
    - int numeroPartecipazioni
    ed espone i seguenti metodi:
    - float tassoDiVittoria (in centesimi)
    - boolean equals(Object o) i valori da usare per equals sono solo il nome
    Ha inoltre un unico costruttore che accetta tutti i parametri e si assicura che abbia almeno 5 anni 
    ed un nome alfabetico composto da almeno 4 lettere

    CorsaDiCavalli ha un costruttore che accetta un numero intero e un float. 
    l'intero deve essere maggiore di 0 e definisce il numero massimo dei cavalli che la gara può gestire.
    il float definisce la lunghezza del percorso da percorrere.
    Espone anche i seguenti metodi
    - boolean garaIniziata()
    - boolean garaFinita()
    - boolean aggiungiCavallo(Cavallo c) 
    torna true se ha aggiunto un cavallo, e segna la partecipazione sul cavallo.
    torna false se non lha aggiunto perché la corsa era piena o il cavallo era già presente (tramite equals)
    lancia un eccezione se è null o se la gara è iniziata
    - void avanzaCavallo(String nomeCavallo, float distanza) 
    se nessun cavallo ha qual nome, se la stringa è null, se la gara era finita o la quantita <= 0, lancia un eccezione
    avanza la posizione del cavallo della quantita passata (partono da 0)
    se la gara non era iniziata, inizia la gara
    se il cavallo supera la lunghezza del percorso, concludi la gara e segna la vittoria al cavallo

    Non e' permesso l'uso delle classi della libreria standard di java, salvo String e le sottoclassi di Exception
*/