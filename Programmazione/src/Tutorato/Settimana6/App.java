package Tutorato.Settimana6;

public class App {
    public static void main(String[] args) throws Exception {
        Casa c = new Casa(new Stanza[]{
                new Stanza(1,1,1,1),
                new Stanza(2,2,2,2,3),
                new Stanza(1,1,1,1,1,1,true,true)
        });
        System.out.println(c.getElectricSockets());
        System.out.println(c.getDoors());
        System.out.println(c.getMaxHeight());
        System.out.println(c.getWaterAccess());
        System.out.println(c.getMq());
    }
}
