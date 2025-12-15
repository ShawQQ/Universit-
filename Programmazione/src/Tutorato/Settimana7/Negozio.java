package Tutorato.Settimana7;

public class Negozio {
    private static int currentId = 0;
    private final int id;
    private final String name;
    private double account;
    private Prodotto[] products;
    private int numberOfProducts;

    private Negozio(String name){
        if(name == null) throw new IllegalArgumentException("Nome non valido");
        this.name = name;
        this.id = ++Negozio.currentId;
        this.account = 0;
    }
    public Negozio(String name, Prodotto[] products){
        this(name);
        if(products == null) throw new IllegalArgumentException("Prodotti non validi");
        this.products = products;
        this.numberOfProducts = products.length;
    }
    public Negozio(String name, int n){
        this(name);
        if(n <= 0) throw new IllegalArgumentException("Numero prodotti non valido");
        this.products = new Prodotto[n];
        this.numberOfProducts = 0;
    }

    public String getName(){
        return this.name;
    }
    public double getAccount(){
        return this.account;
    }
    public int getId(){
        return this.id;
    }
    public Prodotto[] getProducts(){
        Prodotto[] result = new Prodotto[this.getProductNumber()];
        for(int i = 0; i < this.getProductNumber(); i++){
            result[i] = this.products[i];
        }
        return result;
    }
    public boolean addProduct(Prodotto p){
        if(p == null) throw new IllegalArgumentException("Prodotto non valido");
        if(this.isFull()) return false;
        this.products[this.numberOfProducts++] = p;
        return true;
    }

    private boolean isFull() {
        return this.products.length == this.getProductNumber();
    }

    public int getProductNumber() {
        return this.numberOfProducts;
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Negozio negozio = (Negozio) o;
        return this.getId() == negozio.getId();
    }

    public String toString() {
        return this.getName() + " - €" + this.getAccount();
    }
}
