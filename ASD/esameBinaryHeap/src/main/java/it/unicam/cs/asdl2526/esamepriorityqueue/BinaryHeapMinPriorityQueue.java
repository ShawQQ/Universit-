package it.unicam.cs.asdl2526.esamepriorityqueue;

import java.util.ArrayList;
import java.util.NoSuchElementException;

// ATTENZIONE: è vietato includere import a pacchetti che non siano della Java SE

/**
 * Implementazione di una coda con priorità minima (min-priority queue)
 * tramite heap binario.
 * <p>
 * Gli elementi inseriti nella coda devono implementare l'interfaccia
 * {@link PriorityQueueElement}, che permette di:
 * <ul>
 *   <li>leggere e modificare la priorità dell'elemento;</li>
 *   <li>leggere e modificare la <b>handle</b> dell'elemento.</li>
 * </ul>
 *
 * <h3>Handle e complessità</h3>
 * La handle è un intero che rappresenta l'indice dell'elemento all'interno
 * della struttura dati che rappresenta lo heap (in questo caso una
 * {@link ArrayList}).
 * <p>
 * La handle è fondamentale per implementare in tempo logaritmico
 * l'operazione {@link #decreasePriority(PriorityQueueElement, double)}:
 * senza la handle sarebbe necessario cercare linearmente l'elemento
 * nello heap, ottenendo una complessità O(n).
 *
 * <h3>Rappresentazione dello heap</h3>
 * Lo heap è rappresentato tramite una {@link ArrayList} che utilizza
 * tutte le posizioni disponibili; la radice dello heap si trova
 * in posizione 0.
 *
 * @author Luca Tesei (template)
 */
public class BinaryHeapMinPriorityQueue {

    /*
     * ArrayList per la rappresentazione dello heap binario.
     * La radice dello heap si trova in posizione 0.
     *
     * Per un nodo in posizione i:
     * - il padre si trova in posizione (i - 1) / 2
     * - il figlio sinistro si trova in posizione 2*i + 1
     * - il figlio destro si trova in posizione 2*i + 2
     */
    private ArrayList<PriorityQueueElement> heap;

    /**
     * Crea una coda con priorità minima vuota.
     */
    public BinaryHeapMinPriorityQueue() {
        this.heap = new ArrayList<PriorityQueueElement>();
    }

    /**
     * Inserisce un elemento in questa coda con priorità minima.
     * <p>
     * La priorità corrente dell'elemento viene utilizzata per
     * posizionarlo correttamente nello heap.
     * <p>
     * La handle dell'elemento deve essere impostata e mantenuta
     * coerente con la sua posizione nello heap.
     *
     * @param element l'elemento da inserire
     * @throws NullPointerException se l'elemento passato è null
     */
    public void insert(PriorityQueueElement element) {
        if(element == null) throw new NullPointerException("Elemento nullo");
        element.setHandle(this.size());
        this.heap.add(element);
        PriorityQueueElement parent = this.heap.get(this.getParent(element.getHandle()));
        while(element.getPriority() < parent.getPriority()){
            this.swap(element.getHandle(), parent.getHandle());
            parent = this.heap.get(this.getParent(element.getHandle()));
        }
    }

    /**
     * Restituisce (senza estrarlo) l'elemento minimo attualmente presente
     * in questa coda con priorità minima.
     * <p>
     * Questa operazione non modifica lo heap.
     *
     * @return l'elemento con priorità minima
     * @throws NoSuchElementException se la coda è vuota
     */
    public PriorityQueueElement minimum() {
        if(this.isEmpty()) throw new NoSuchElementException("Coda vuota");
        return this.heap.get(0);
    }

    /**
     * Estrae e restituisce l'elemento minimo da questa coda con priorità minima.
     * <p>
     * Dopo l'estrazione, lo heap deve essere aggiornato per ripristinare
     * la proprietà di min-heap e le handle degli elementi eventualmente
     * spostati devono essere aggiornate coerentemente.
     *
     * @return l'elemento minimo
     * @throws NoSuchElementException se la coda è vuota
     */
    public PriorityQueueElement extractMinimum() {
        if(this.isEmpty()) throw new NoSuchElementException("Coda vuota");
        PriorityQueueElement min = this.heap.get(0);
        if(!this.isEmpty()){
            PriorityQueueElement newMin = this.heap.get(this.size() - 1);
            newMin.setHandle(0);
            this.heap.set(0, newMin);
            this.heapifyDown(0);
            this.heap.remove(this.size() - 1);
        }
        return min;
    }

    /**
     * Diminuisce la priorità associata a un elemento presente in questa
     * coda con priorità minima.
     * <p>
     * Dopo l'aggiornamento della priorità, la posizione dell'elemento
     * nello heap deve essere modificata di conseguenza: l'elemento
     * potrebbe risalire fino alla radice.
     *
     * <h3>Vincolo di complessità</h3>
     * Questo metodo <b>non deve</b> cercare linearmente l'elemento nello heap.
     * L'elemento deve essere individuato esclusivamente tramite la sua handle,
     * ottenendo così un tempo di accesso O(1) e una complessità complessiva
     * O(log n).
     *
     * @param element l'elemento di cui diminuire la priorità (deve essere presente nella coda)
     * @param newPriority la nuova priorità da assegnare all'elemento
     * @throws NoSuchElementException se l'elemento non è presente nella coda
     * @throws IllegalArgumentException se la nuova priorità non è strettamente minore
     *                                  della priorità corrente dell'elemento
     */
    public void decreasePriority(PriorityQueueElement element, double newPriority) {
        if(!this.handleIsValid(element.getHandle())) throw new NoSuchElementException("Elemento non presente");
        if(element.getPriority() <= newPriority) throw new IllegalArgumentException("La nuova priorita non puo essere maggiore dell'attuale");
        element.setPriority(newPriority);
        this.swap(0, element.getHandle());
        this.heapifyDown(0);
    }

    /**
     * Determina se questa coda con priorità è vuota.
     *
     * @return true se la coda è vuota, false altrimenti
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    /**
     * Restituisce il numero di elementi attualmente presenti nella coda.
     *
     * @return la dimensione corrente della coda
     */
    public int size() {
        return this.heap.size();
    }

    /**
     * Rimuove tutti gli elementi da questa coda con priorità minima.
     * Dopo questa operazione la coda risulta vuota.
     */
    public void clear() {
        this.heap.clear();
    }

    /*
     * TODO inserire eventuali metodi privati per fini di implementazione.
     *
     * Suggerimento:
     * - swap(int i, int j)
     * - heapifyUp(int i)
     * - heapifyDown(int i)
     *
     * ATTENZIONE: tutti i metodi che spostano elementi nello heap
     * devono aggiornare correttamente anche le handle degli elementi coinvolti.
     */
    private int getParent(int i){
        return (i - 1) / 2;
    }
    private int getLeft(int i){
        return 2*i+1;
    }
    private int getRight(int i){
        return 2*i+2;
    }

    private void swap(int i, int j){
        PriorityQueueElement first = this.heap.get(i);
        PriorityQueueElement second = this.heap.get(j);
        first.setHandle(j);
        second.setHandle(i);
        this.heap.set(j, first);
        this.heap.set(i, second);
    }
    private void heapifyDown(int i){
        PriorityQueueElement minElement = this.heap.get(i);
        PriorityQueueElement left = this.getLeft(i) < this.size() ? this.heap.get(this.getLeft(i)) : null;
        PriorityQueueElement right = this.getRight(i) < this.size() ? this.heap.get(this.getRight(i)) : null;
        if(left != null && left.getPriority() < minElement.getPriority()){
            minElement = left;
        }
        if(right != null && right.getPriority() < minElement.getPriority()){
            minElement = right;
        }
        if(minElement.getHandle() != i){
            int handle = minElement.getHandle();
            this.swap(handle, i);
            this.heapifyDown(handle);
        }
    }
    private boolean handleIsValid(int i){
        return i >= 0 && i < this.size();
    }
}