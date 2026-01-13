package Esame.CavalloConMappa;

public class SimpleMap {
	private final Node[] buckets;
	private final int size;
	private int currentSize;

	public SimpleMap(int size){
		this.buckets = new Node[size];
		this.size = size;
	}

	public boolean put(Cavallo c, float val){
		if(currentSize == size) return false;
		int hash = this.hash(c);
		Node newNode = new Node(c, val);
		Node bucket = this.buckets[hash];
		if(bucket == null){
			this.buckets[hash] = newNode;
		}else{
			while(bucket.next != null){
				if(bucket.key.equals(c)) return false;
				bucket = bucket.next;
			}
			bucket.next = newNode;
		}
		currentSize++;
		return true;
	}
	public void update(Cavallo c, float val){
		int hash = this.hash(c);
		Node bucket = this.buckets[hash];
		while(bucket != null){
			if(bucket.key.equals(c)){
				bucket.value = val;
				return;
			}
			bucket = bucket.next;
		}
		throw new IllegalArgumentException("Chiave non presente");
	}
	public float get(Cavallo c){
		int hash = this.hash(c);
		Node bucket = this.buckets[hash];
		while(bucket != null){
			if(bucket.key.equals(c)) return bucket.value;
			bucket = bucket.next;
		}
		throw new IllegalArgumentException("Chiave non presente");
	}
	public Cavallo getKey(String nomeCavallo){
		Cavallo c = new Cavallo(nomeCavallo, 5, 0, 0);
		int hash = this.hash(c);
		Node bucket = this.buckets[hash];
		while(bucket != null){
			if(bucket.key.equals(c)) return bucket.key;
			bucket = bucket.next;
		}
		throw new IllegalArgumentException("Chiave non presente");
	}

	private int hash(Cavallo c){
		return c.hashCode() % size;
	}

	private static class Node{
		private final Cavallo key;
		private float value;
		private Node next;

		public Node(Cavallo e, float value){
			this.key = e;
			this.value = value;
		}
	}
}
