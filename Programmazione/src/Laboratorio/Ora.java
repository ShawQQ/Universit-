package Laboratorio;

public class Ora {
    private final int hour;
    private final int minute;

    public Ora(int hour, int minute) {
        if(hour > 23 || hour < 0){
            throw new IllegalArgumentException("Ora non valida");
        }
        if(minute >= 60 || minute < 0){
            throw new IllegalArgumentException("Minuti non validi");
        }
        this.hour = hour;
        this.minute = minute;
    }

    public Ora add(Ora o){
        int newMinute = this.minute + o.getMinute();
        int newHour = this.hour + o.getHour() + (newMinute / 60);
        return new Ora(newHour % 24, newMinute % 60);
    }
    public static Ora addOre(Ora x, Ora y){
        return x.add(y);
    }

    private int getMinute() {
        return this.minute;
    }

    private int getHour() {
        return this.hour;
    }

    public String toString() {
        return this.hour+":"+this.minute;
    }
}
