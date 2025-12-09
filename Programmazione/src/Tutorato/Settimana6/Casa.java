package Tutorato.Settimana6;

public class Casa {
    private Stanza[] stanze;
    private int currentStanze;

    public Casa(Stanza[] stanze){
        if(stanze == null) throw new IllegalArgumentException("Stanze non puo' essere null");
        for(int i = 0; i < stanze.length; i++){
            if(stanze[i] == null) throw new IllegalArgumentException("Stanze non puo' contenere valori null");
        }
        this.stanze = stanze;
        currentStanze = stanze.length;
    }
    public Casa(int stanze){
        if(stanze <= 0) throw new IllegalArgumentException("Numero stanze non valido");
        this.stanze = new Stanza[stanze];
        this.currentStanze = 0;
    }
    public Casa(int stanze, Stanza s){
        this(stanze);
        this.add(s);
    }

    public void add(Stanza stanza){
        if(stanza == null) throw new IllegalArgumentException("La stanza non puo' essere nulla");
        if(this.stanze.length != this.getCurrentStanze()){
            this.stanze[this.currentStanze++] = stanza;
        }
    }
    public int getCurrentStanze(){
        return this.currentStanze;
    }
    public float getMq(){
        float total = 0;
        for(int i = 0; i < this.getCurrentStanze(); i++){
            total += this.stanze[i].getLarghezza() * this.stanze[i].getLunghezza();
        }
        return total;
    }
    public float getMaxHeight(){
        float height = 0;
        for(int i = 0; i < this.getCurrentStanze(); i++){
            height = Math.max(height, this.stanze[i].getAltezza());
        }
        return height;
    }
    public int getDoors(){
        int total = 0;
        for(int i = 0; i < this.getCurrentStanze(); i++){
            total += this.stanze[i].getPorte();
        }
        return total;
    }
    public int getElectricSockets(){
        int total = 0;
        for(int i = 0; i < this.getCurrentStanze(); i++){
            total += this.stanze[i].getPreseDiCorrente();
        }
        return total;
    }
    public int getWaterAccess(){
        int total = 0;
        for(int i = 0; i < this.getCurrentStanze(); i++){
            if(this.stanze[i].isAcquaCorrente()){
                total++;
            }
        }
        return total;
    }


    /**
     * definire i seguenti getter, in funzione delle stanze contenute dentro la casa:
     * 1. dai metri quandrati totali
     * 2. dai altezza massima
     * 3. dai numero porte
     * 4. dai numero prese di corrente
     * 5. dai numero accessi all'acqua
     */
}
