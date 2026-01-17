    Implementare una classe chiamata Processo

    la classe ha le seguenti proprietà, con i relativi getter:
    - priorita (long) definisce quanto un Processo sia importante
    - peso (int) definisce quante risorse un processo può occupare
    - terminato (boolean) definisce se il processo ha finito o deve essere eseguito

    la classe possiede solo un costruttore, che accetta i parametri prioria e peso
    si assicura anche che peso sia maggiore di 0
    prioria può essere negativa
    terminato è sempre false alla costruzione

    la classe espone i seguenti metodi
    boolean aggiungiProcesso(Processo p)
    aggiunge un processo, che viene inteso come sottoprocesso. lancia un eccezione se p è null
    non aggiungilo e torna false se, con la sua aggiunta, la somma del peso dei sottoprocessi superasse quella del processo corrente.
    altrimenti torna true
    Processo daiProssimoProcesso()
    torna il sottoprocesso con la priorita piu alta e non concluso
    se non ne ha nessuno, torna se stesso se non è concluso
    in caso contrario, torna null
    void prestaRisorse(int risorse)
    se risorse è <= 0, lancia un'eccezione
    se il processo non ha sottoprocessi da terminare, sottrae le risorse al suo peso e, se arriva a 0, viene segnato come concluso.
    se ha sottoprocessi, sottrae le risorse sia al proprio peso che ai processi figli, andando in ordine di priorità

    es. il processo p0, con peso 50, ha tre sottoprocessi
    - p1, con peso 10 e priorita 21
    - p2, con peso 30 e priorita 1
    - p3, con peso 5 e priorita -5
    chiamando prestaRisorse(11)
    1) p1 va a 0 di peso e diventa concluso
    2) p2 vede il suo peso scendere a 29
    3) p0 vede il suo peso scendere a 39
    (si ricorda che abbiamo seguito l'ordine di priorita)
    se poi chiamando prestaRisorse(37)
    1) p2 va a 0 di peso e diventa concluso
    2) p3 va a 0 di peso e diventa concluso
    3) p0 vede il suo peso scendere a 2