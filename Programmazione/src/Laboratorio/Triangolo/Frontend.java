package Laboratorio.Triangolo;

import java.util.Scanner;

public class Frontend {
    public static void main(String[] args) {
        double l1 = askDouble("Inserisci il primo lato");
        double l2 = askDouble("Inserisci il secondo lato");
        double l3 = askDouble("Inserici il terzo lato");
        try{
            Triangolo t  = new Triangolo(l1, l2, l3);
            System.out.println("Perimetro: "+t.perimetro());
            System.out.println("Area: "+t.area());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private static double askDouble(String q){
        System.out.println(q);
        Scanner sc = new Scanner(System.in);
        System.out.print(">");
        return sc.nextDouble();
    }
}
