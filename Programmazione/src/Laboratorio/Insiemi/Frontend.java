package Laboratorio.Insiemi;

public class Frontend {
    public static void main(String[] args) {
        Insieme i = new Insieme(4);
        for(int j = 0; j < 4; j++){
            i.add(j);
        }
        System.out.println(i);
    }
}
