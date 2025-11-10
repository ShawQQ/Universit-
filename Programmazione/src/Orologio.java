public class Orologio {
    private int minutes;
    private int hours;

    public int getMinutes(){
        return this.minutes;
    }

    public int getHours(){
        return this.hours;
    }

    public void tick(){
        this.minutes++;
        if(this.minutes >= 60){
            int addHours = this.minutes / 60;
            this.hours += addHours;
            this.minutes = 0;
        }
    }
}
