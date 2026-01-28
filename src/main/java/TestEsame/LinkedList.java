package TestEsame;

import java.util.Iterator;

/**
 * Semplice implementazione di una single linked list. La lista non accetti valori null, ma accetta valori duplicati
 * @param <E>
 */
public class LinkedList<E> implements Iterable<E> {
    private Node<E> first;
    private Node<E> tail;
    private int size;
    private int numChange;

    public LinkedList(){
        this.first = null;
        this.size = 0;
        this.numChange = 0;
    }

    /**
     * Aggiunge l'elemento in fondo alla lista. Lancia una IllegalArgumentException se l'elemento è null
     * * L'operazione deve avere una complessità pari a O(1)
     * @param element elemento da aggiungere
     * @throws IllegalArgumentException se l'elemento è null
     */
    public void add(E element){
        throw new NotImplementedException("Da fare");
    }

    /**
     * Aggiunge l'elemento nella posizione specificata. Lancia una IllegalArgumentException se l'elemento è null, una
     * IndexOutOfBoundException se l'indice non è valido (maggiore della dimensione attuale della lista o minore di 0)
     * L'operazione deve avere una complessità pari a O(n) (o meglio)
     * @param element elemento da aggiungere
     * @param index posizione nella lista
     * @throws IllegalArgumentException se l'elemento è null
     * @throws IndexOutOfBoundsException se l'indice non è valido
     */
    public void add(E element, int index){
        throw new NotImplementedException("Da fare");
    }

    /**
     * Rimuove la prima instanza dell'elemento specificato dalla lista. Ritorna true se l'elemento è stato rimosso
     * false, altrimenti.
     * Lancia una IllegalArgumentException se l'elemento è null, una NullPointerException se la lista è vuota
     * L'operazione deve avere una complessità pari a O(n) (o meglio)
     * @param element elemento da rimuovere
     * @return true se l'elemento è stato rimosso, false altrimenti
     * @throws IllegalArgumentException se l'elemento è null
     * @throws NullPointerException se la lista è vuota
     */
    public boolean remove(E element){
        throw new NotImplementedException("Da fare");
    }

    /**
     * Rimuove l'elemento che si trova nella posizione specificata. Lancia una IndexOutOfBoundException se l'indice
     * non è valido.
     * L'operazione deve avere una complessità pari a O(n) (o meglio)
     * @param index posizione dell'elemento
     * @throws IndexOutOfBoundsException se l'indice non è valido.
     */
    public void remove(int index){
        throw new NotImplementedException("Da fare");
    }

    /**
     * Recupera l'elemento che si trova nella posizione indicata. Lancia una IndexOutOfBoundException se l'indice non
     * è valido.
     * L'operazione deve avere una complessità pari a O(n) (o meglio)
     * @param index posizione dell'elemento
     * @return l'elemento che si trova nella posizione specificata
     * @throws IndexOutOfBoundsException se l'indice non è valido
     */
    public E get(int index){
        throw new NotImplementedException("Da fare");
    }
    /**
     * Controlla se un elemento si trova all'interno della lista. Ritorna true se l'elemento è presente, false altrimenti.
     * Lancia una IllegalArgumentException se l'elemento è null
     * L'operazione deve avere una complessità pari a O(n) (o meglio)
     * @param element elemento da cercare
     * @return true se l'elemento è stato trovato, false altrimenti
     * @throws IllegalArgumentException se l'elemento è null
     */
    public boolean contains(E element){
        throw new NotImplementedException("Da fare");
    }

    /**
     * Ritorna l'indice di un dato elemento, se presente. Se l'elemento non è presente ritorna -1. Lancia una
     * IllegalArgumentException se l'elemento è null
     * @param element elemento da cercare
     * @return l'indice dell'elemento se presente, -1 altrimenti
     * @throws IllegalArgumentException se l'elemento è null
     */
    public int indexOf(E element){
        throw new NotImplementedException("Da fare");
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
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

    private class Itr implements Iterator<E>{
        private Node<E> lastReturned;
        private int numChangeExpected;

        private Itr(){
            this.lastReturned = null;
            this.numChangeExpected = LinkedList.this.numChange;
        }
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }
}
