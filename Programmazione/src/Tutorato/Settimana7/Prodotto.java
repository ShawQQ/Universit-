package Tutorato.Settimana7;

public class Prodotto {
    private static int currentId = 0;
    private final int id;
    private final String name;
    private double price;
    private double cost;

    public Prodotto(String name, double price, double cost){
        if(name == null) throw new IllegalArgumentException("Il nome del prodotto non puo' essere null");
        if(isValidPrice(price, cost)) throw new IllegalArgumentException("Prezzo non valido");
        if(cost <= 0) throw new IllegalArgumentException("Costo non valido");
        this.id = ++Prodotto.currentId;
        this.name = name;
        this.price = price;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price){
        if(!isValidPrice(price, this.cost)) throw new IllegalArgumentException("Prezzo non valido");
        this.price = price;
    }

    public double getCost() {
        return cost;
    }
    public void setCost(double cost){
        if(cost <= 0) throw new IllegalArgumentException("Costo non valido");
        this.cost = cost;
    }

    public double getProfit(){
        return this.getPrice() - this.getCost();
    }

    public int getId() {
        return id;
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Prodotto prodotto = (Prodotto) o;
        return getId() == prodotto.getId();
    }
    private boolean isValidPrice(double price, double cost){
        return price > 0 && price > cost;
    }

    public String toString(){
        return this.name;
    }
}
