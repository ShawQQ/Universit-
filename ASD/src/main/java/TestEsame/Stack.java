package TestEsame;

/**
 * Semplice implementazione di uno stack che supporta le operazioni di
 * <ul>
 *     <li>Inserimento</li>
 *     <li>Rimozione</li>
 *     <li>Reset</li>
 * </ul>
 * @param <E>
 */
public class Stack<E> {
    private Node<E> first;
    private int size;

    public Stack(){
        this.first = null;
        this.size = 0;
    }

    /**
     * Aggiunge un nuovo elemento allo stack. L'elemento viene aggiunto solo se non è null. Lo stack accetta duplicati.
     * L'operazione deve avere una complessità pari a O(1)
     * @param element elemento da aggiungere
     * @throws IllegalArgumentException se l'elemento è null
     */
    public void push(E element){
        throw new NotImplementedException("Da fare");
    }

    /**
     * Rimuove l'ultimo elemento inserito all'interno dello stack, e lo ritorna.
     * L'operazione deve avere una complessità pari a O(1)
     * @return l'ultimo elemento inserito
     * @throws NullPointerException se lo stack è vuoto
     */
    public E pop(){
        throw new NotImplementedException("Da fare");
    }

    /**
     * Pulisce lo stack rimuovendo tutti gli elementi al suo interno
     * L'operazione deve avere una complessità pari a O(1)
     */
    public void clear(){
        throw new NotImplementedException("Da fare");
    }

    /**
     * Rimuove la prima instanza delll'elemento specificato come argomento dall'interno dello stack.
     * Ritorna true se l'elemento è stato trovato e rimosso con successo, false altrimenti
     * L'operazione deve avere una complessità pari a O(n) (o meglio)
     * @param element elemento da rimuovere
     * @return true se l'elemento è stato rimosso, false altrimenti
     * @throws NullPointerException se lo stack è vuoto
     * @throws IllegalArgumentException se l'elemento è null
     */
    public boolean remove(E element){
        throw new NotImplementedException("Da fare");
    }

    /**
     * Rimuove tutte le instanze dell'elemento specificato come argomento dall'interno dello stack.
     * Ritorna true se almeno un elemento viene rimosso, false altrimenti.
     * L'operazione deve avere una complessità pari a O(n) (o meglio)
     * @param element elemento da rimuovere
     * @return true se almeno un elemento è stato rimosso, false altrimenti
     * @throws NullPointerException se lo stack è vuoto
     * @throws IllegalArgumentException se l'elemento è null
     */
    public boolean removeAll(E element){
        throw new NotImplementedException("Da fare");
    }

    /**
     * Ritorna la dimensione dello stack
     * @return dimensione attuale dello stack
     */
    public int getSize(){
        return this.size;
    }

    /**
     * @return true se lo stack è vuoto, false altrimenti
     */
    public boolean isEmpty(){
        return this.getSize() == 0;
    }

    private static class Node<E>{
        private E element;
        private Node<E> next;

        public Node(E element){
            this.element = element;
            this.next = null;
        }
    }
}
