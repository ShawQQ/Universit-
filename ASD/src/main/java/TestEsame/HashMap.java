package TestEsame;

/**
 * Semplice implementazione di una HashMap. La mappa non accetta valori duplicati o valori null.
 * La tabella delle collisioni ha una capacità iniziale di 32 e un fattore di bilanciamento di default pari a 0.5.
 * Quando il fattore di carico reale supera quello di default la tabella di collisione viene raddoppiata e reindirizzata.
 * La funzione di hash viene fornita.
 * @param <K>
 * @param <V>
 */
public class HashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 32;
    private static final double LOAD_FACTOR = 0.5;
    private static final int RESIZE_FACTOR = 2;

    private int size;
    private Object[] table;

    public HashMap(){
        this.table = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Aggiungi un elemento alla mappa. L'elemento viene aggiunto solamente se non è già presente all'interno della mappa,
     * e se non è null. Se l'elemento è null o la chiave è null viene lanciata una IllegalArgumentException.
     * @param key chiave dell'elemento
     * @param e elemento da aggiungere
     * @return true se l'elemento viene aggiunto correttamente, false altrimenti
     * @throws IllegalArgumentException se la chiave o l'elemento sono null
     */
    public boolean put(K key, V e){
        throw new NotImplementedException("Da fare");
    }

    /**
     * Ritorna il valore associato alla chiave data. Lancia una IllegalArgumentException se la chiave non è presente
     * nella mappa, o se la chiave è null.
     * @param key chiave dell'elemento
     * @return elemento associato alla chiave
     * @throws IllegalArgumentException se la chiave non è presente all'interno della mappa, o se è null
     */
    public V get(K key){
        throw new NotImplementedException("Da fare");
    }

    /**
     * Controlla se un dato elemento è già presente all'interno della mappa. Lancia una IllegalArgumentException se
     * l'elemento è null.
     * @param e elemento da ricercare
     * @return true se l'elemento è presente, false altrimenti
     * @throws IllegalArgumentException se l'elemento è null
     */
    public boolean contains(V e){
        throw new NotImplementedException("Da fare");
    }

    /**
     * Controlla se una data chiave è già presente all'interno della mappa. Lancia una IllegalArgumentException se
     * la chiave è null.
     * @param key chiave da ricercare
     * @return true se la chiave è presente, false altrimenti
     * @throws IllegalArgumentException se la chiave è null
     */
    public boolean containsKey(K key){
        throw new NotImplementedException("Da fare");
    }

    /**
     * Rimuove un dato elemento dalla mappa. Ritorna true se l'elemento è stato rimosso, false altrimenti. Lancia una
     * IllegalArgumentException se l'elemento è null.
     * @param e elemento da rimuovere
     * @return true se l'elemento è stato rimosso, false altrimenti
     * @throws IllegalArgumentException se l'elemento è null
     */
    public boolean remove(V e){
        throw new NotImplementedException("Da fare");
    }

    /**
     * Rimuove una data chiave dalla mappa. Ritorna true se la chiave è stato rimossa, false altrimenti. Lancia una
     * IllegalArgumentException se la chiave è null.
     * @param k chiave da rimuovere
     * @return true se la chiave è stato rimossa, false altrimenti
     * @throws IllegalArgumentException se la chiave è null
     */
    public boolean removeKey(K k){
        throw new NotImplementedException("Da fare");
    }

    /**
     * Riporta l'hashmap al suo stato iniziale
     */
    public void clear(){
        throw new NotImplementedException("Da fare");
    }

    /**
     * Ridimensiona la tabella delle collisioni, raddoppiando la sua dimensione.
     */
    public void resize(){
        throw new NotImplementedException("Da fare");
    }

    /**
     * Enumera tutte le chiavi presenti all'interno della mappa.
     * @return l'enumerazione delle chiavi presenti nella mappa
     */
    public Iterable<K> enumerateKey(){
        throw new NotImplementedException("Da fare");
    }

    /**
     * Enumera tutti i valori presenti all'interno della mappa.
     * @return l'enumerazione dei valori della mappa
     */
    public Iterable<V> enumerateValues(){
        throw new NotImplementedException("Da fare");
    }

    private int hash(K key, int size){
        double phi = (Math.sqrt(5) - 1) / 2;
        double v = key.hashCode() * phi;
        double v1 = size * (v - Math.floor(v));
        return Math.abs((int) v1);
    }
    public int getSize(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.getSize() == 0;
    }
    protected int getCurrentCapacity(){
        return this.table.length;
    }
    protected int getCurrentThreshold(){
        return (int) (this.getCurrentCapacity() * LOAD_FACTOR);
    }

    private static class Node<K, V>{
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
