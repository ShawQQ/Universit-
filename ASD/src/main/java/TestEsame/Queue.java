package TestEsame;

/**
 * Semplice implementazione di una coda. La coda supporta le operazioni di
 * <ul>
 *     <li>Inserimento</li>
 *     <li>Rimozione</li>
 *     <li>Reset</li>
 * </ul>
 */
public class Queue<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public Queue(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Aggiunge un elemento in fondo alla coda. La coda accetta duplicati, ma non accetta valori null.
     * L'operazione deve avere una complessità pari a O(1)
     * @param element elemento da aggiungere
     * @throws IllegalArgumentException se l'elemento è null
     */
    public void enqueue(E element){
        throw new NotImplementedException("Da fare");
    }

    /**
     * Rimuove il primo elemento della coda, e lo ritorna. Se la coda è vuota viene lanciata una NullPointerException
     * @return primo elemento della coda
     * @throws NullPointerException se la coda è vuota
     */
    public E dequeue(){
        throw new NotImplementedException("Da fare");
    }

    /**
     * Rimuove la prima instanza delll'elemento specificato dalla coda. Se l'elemento non è presente, ritorna false.
     * Se la coda è vuota, lancia una NullPointerException. Se l'elemento è null, lancia una IllegalArgumentException.
     * L'operazione deve avere una complessità pari a O(n) (o meglio)
     * @param element elemento da rimuovere
     * @return true se l'elemento è stato rimosso, false altrimenti
     * @throws NullPointerException se la coda è vuota
     * @throws IllegalArgumentException se l'elemento è null
     */
    public boolean remove(E element){
        throw new NotImplementedException("Da fare");
    }

    /**
     * Rimuove tutte le instanze delll'elemento specificato dalla coda. Se l'elemento non è presente, ritorna false.
     * Se la coda è vuota, lancia una NullPointerException. Se l'elemento è null, lancia una IllegalArgumentException.
     * L'operazione deve avere una complessità pari a O(n) (o meglio)
     * @param element elemento da rimuovere
     * @return true se l'elemento è stato rimosso, false altrimenti
     * @throws NullPointerException se la coda è vuota
     * @throws IllegalArgumentException se l'elemento è null
     */
    public boolean removeAll(E element){
        throw new NotImplementedException("Da fare");
    }

    public int getSize(){
        return this.size;
    }

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
