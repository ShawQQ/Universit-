## Esame di Algoritmi e Strutture Dati – Laboratorio

### Condizioni dell'esame

- **Tempo a disposizione**: **1 ora**
- **È consentito** utilizzare come IDE **solo** IntelliJ IDEA, disponibile nel
  Thin Client.
- **Non è consentito** utilizzare materiale cartaceo a parte il foglio dato in
  dotazione, su cui bisogna scrivere all'inizio della prova Nome, Cognome e
  Matricola.
- **Non è consentito** navigare in Internet con il browser o altre
  applicazioni.

---

### Istruzioni

1. Scaricare il codice in formato `.zip` dalla domanda Moodle nella cartella
   del disco locale `C` del Thin Client `C:\Users\proprionome.propriocognome`.
   **ATTENZIONE**: il file deve essere scaricato e poi scompattato esattamente in
   questa cartella, altrove IntelliJ IDEA non riesce a leggere correttamente i file.
2. Scompattare lo zip.
3. Aprire con IntelliJ IDEA la cartella scompattata. **ATTENZIONE**: la
   cartella deve contenere `src` (cartella), `pom.xml` e `README.md`.
4. L'IDE dovrebbe riconoscere automaticamente il progetto come **Maven** e
   scaricare le dipendenze necessarie per l’esecuzione dei test. Questo può
   richiedere un po' di tempo.
5. Ignorare la finestra di "Access Denied" o qualcosa di simile che si aprirà.
   Se viene chiusa si riapre. Abbassatela così non dà fastidio.
6. Provare a eseguire i test per verificare che venga fatto il build del
   progetto. In questa fase ovviamente molti test non passeranno.  
   **ATTENZIONE**: se c'è un errore che riguarda l'assenza di una SDK, andare su
   `File -> Project Structure -> Project` e impostare una SDK tra quelle
   disponibili. Qualora non fosse installata nessuna SDK si potrà scaricare da
   IntelliJ IDEA.
7. Leggere attentamente la descrizione delle classi fornite e del lavoro da
   svolgere in questo file `README.md` (e nella domanda su Moodle).
8. Implementare **esclusivamente** i metodi contrassegnati nel codice con
   `// TODO implementare`.
9. Sono messi a disposizione alcuni **test JUnit di base** per verificare le
   funzionalità richieste.  
   **I test forniti non sono tutti quelli utilizzati in fase di valutazione.**

---

### Descrizione delle classi fornite e del lavoro da fare

Il progetto riguarda l’implementazione di una **coda con priorità minima (min-priority queue)**
realizzata tramite **heap binario**, tipicamente utilizzata in algoritmi su grafi
come l’algoritmo di **Dijkstra** per il calcolo dei cammini minimi.

Sono fornite le seguenti classi e interfacce.

#### `PriorityQueueElement`

È un’interfaccia che deve essere implementata dagli oggetti inseribili nella coda
con priorità.  
Ogni elemento gestisce:

- una **priorità** (tipo `double`);
- una **handle** (tipo `int`), che rappresenta l’indice dell’elemento all’interno
  della struttura dati che implementa lo heap.

La handle è fondamentale per consentire l’aggiornamento efficiente della priorità
di un elemento già presente nella coda.

#### `MySimpleElement`

È una semplice classe di supporto che implementa l’interfaccia
`PriorityQueueElement`.  
Questa classe è fornita **esclusivamente per scopi di test** e **non deve essere
modificata**.  
L’implementazione della coda con priorità **non deve fare alcuna assunzione
specifica** su questa classe.

#### `BinaryHeapMinPriorityQueue`

È la classe principale da completare.

Implementa una **coda con priorità minima** tramite **heap binario**, rappresentato
internamente mediante una `ArrayList`.

Lo studente deve implementare **esclusivamente** i metodi contrassegnati nel codice
con:

```text
// TODO implementare
```

È consentito (e consigliato) **aggiungere metodi privati di supporto** per scopi di
implementazione.

Ad esempio, possono risultare utili metodi come:

```text
swap(int i, int j)
heapifyUp(int i)
heapifyDown(int i)
```

**Attenzione**: tutti i metodi che spostano elementi nello heap **devono
aggiornare correttamente anche le handle** degli elementi coinvolti.

---

### Vincoli di correttezza e complessità

L’implementazione deve rispettare i **vincoli di complessità tipici di uno heap
binario**:

- `insert`: **O(log n)**
- `extractMinimum`: **O(log n)**
- `minimum`: **O(1)**
- `decreasePriority`: **O(log n)**

In particolare, per il metodo:

```text
decreasePriority(PriorityQueueElement element, double newPriority)
```

- **non è consentito** cercare l’elemento nello heap tramite una scansione
  lineare della struttura dati;
- l’elemento deve essere localizzato **esclusivamente tramite la sua handle**,
  che consente l’accesso diretto alla posizione corretta in tempo O(1);
- dopo la modifica della priorità, la struttura dello heap deve essere
  ripristinata correttamente.

**Importante**  
Soluzioni che implementano correttamente il comportamento funzionale ma **violano
i vincoli di complessità asintotica richiesti** (ad esempio tramite ricerche
lineari nello heap) **potranno subire una penalizzazione in sede di valutazione**,
anche se i test automatici forniti risultano superati.

---

### Test e valutazione

Nel progetto sono inclusi alcuni **test JUnit pubblici** che verificano le
funzionalità di base richieste.

Il superamento di tutti i test pubblici è **necessario ma non sufficiente** per
ottenere il punteggio massimo.

Durante la valutazione verranno utilizzati anche **test aggiuntivi non visibili**,
utilizzati per:

- verificare la corretta gestione delle handle;
- testare casi limite;
- distinguere implementazioni parziali da implementazioni pienamente corrette ed
  efficienti.

---

### Consegna delle classi

1. Controllare che non ci siano errori di compilazione.
2. Controllare che tutti i test forniti passino correttamente.
3. Allegare **solo il seguente file** nella risposta al compito Moodle:
   - `BinaryHeapMinPriorityQueue.java`
4. Confermare la consegna.
5. **Non devono essere consegnate**:
   - le classi che non contengono `// TODO implementare`,
   - le classi di test.
6. Terminare la sessione e uscire dalla stanza.
