package Tutorato.Extra.Esercizi6;

public class App {
    private static int testsRun = 0;
    private static int testsPassed = 0;

    private static void check(boolean condition, String name) {
        testsRun++;
        if (condition) {
            testsPassed++;
            System.out.println("[OK]   " + name);
        } else {
            System.out.println("[FAIL] " + name);
        }
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        // ---------- TEST PUNTO ----------
        Punto p1 = new Punto(1.5, -2.0);
        check(p1.getX() == 1.5 && p1.getY() == -2.0,
                "Punto: coordinate memorizzate correttamente");

        // ---------- TEST SEGMENTO ----------
        Punto a = new Punto(0.0, 0.0);
        Punto b = new Punto(3.0, 4.0); // distanza = 5

        Segmento s1 = new Segmento(a, b);
        check(s1.getInizio() == a && s1.getFine() == b,
                "Segmento: estremi memorizzati correttamente");

        double lunghezzaS1 = s1.lunghezza();
        check(Punto.doubleEquals(lunghezzaS1, 5.0),
                "Segmento: lunghezza distanza euclidea (3-4-5)");

        // Segmento con punti uguali -> deve lanciare eccezione
        boolean eccezioneSegmentoUguale = false;
        try {
            Segmento sErrore1 = new Segmento(a, a);
        } catch (RuntimeException e) {
            eccezioneSegmentoUguale = true;
        }
        check(eccezioneSegmentoUguale,
                "Segmento: punti uguali -> eccezione");

        // Segmento con punto null -> deve lanciare eccezione
        boolean eccezioneSegmentoNull = false;
        try {
            Segmento sErrore2 = new Segmento(a, null);
        } catch (RuntimeException e) {
            eccezioneSegmentoNull = true;
        }
        check(eccezioneSegmentoNull,
                "Segmento: punto null -> eccezione");

        // ---------- TEST POLIGONO da vertici (triangolo 3-4-5) ----------
        Punto t1 = new Punto(0.0, 0.0);
        Punto t2 = new Punto(3.0, 0.0);
        Punto t3 = new Punto(0.0, 4.0);

        Punto[] verticiTriangolo = { t1, t2, t3 };
        Poligono triangolo = new Poligono(verticiTriangolo);

        check(triangolo.numeroVertici() == 3,
                "Poligono (vertici): numero vertici = 3");

        double perimetroTriangolo = triangolo.perimetro(); // 3 + 4 + 5 = 12
        check(Punto.doubleEquals(perimetroTriangolo, 12.0),
                "Poligono (vertici): perimetro triangolo 3-4-5 = 12");

        check(!triangolo.isEquilatero(),
                "Poligono (vertici): triangolo 3-4-5 NON equilatero");

        // Poligono con meno di 3 vertici -> deve lanciare eccezione
        boolean eccezionePoligonoPochiVertici = false;
        try {
            Punto[] pochiVertici = { t1, t2 };
            Poligono errorePol1 = new Poligono(pochiVertici);
        } catch (RuntimeException e) {
            eccezionePoligonoPochiVertici = true;
        }
        check(eccezionePoligonoPochiVertici,
                "Poligono (vertici): meno di 3 vertici -> eccezione");

        // Poligono con vertici duplicati -> deve lanciare eccezione
        boolean eccezionePoligonoVerticiDuplicati = false;
        try {
            Punto[] verticiDuplicati = { t1, t2, t1 };
            Poligono errorePol2 = new Poligono(verticiDuplicati);
        } catch (RuntimeException e) {
            eccezionePoligonoVerticiDuplicati = true;
        }
        check(eccezionePoligonoVerticiDuplicati,
                "Poligono (vertici): vertici duplicati -> eccezione");

        // ---------- TEST POLIGONO da lati (quadrato equilatero) ----------
        Punto q1 = new Punto(0.0, 0.0);
        Punto q2 = new Punto(2.0, 0.0);
        Punto q3 = new Punto(2.0, 2.0);
        Punto q4 = new Punto(0.0, 2.0);

        Segmento l1 = new Segmento(q1, q2);
        Segmento l2 = new Segmento(q2, q3);
        Segmento l3 = new Segmento(q3, q4);
        Segmento l4 = new Segmento(q4, q1);

        Segmento[] latiQuadrato = { l1, l2, l3, l4 };
        Poligono quadrato = new Poligono(latiQuadrato);

        check(quadrato.numeroVertici() == 4,
                "Poligono (lati): numero vertici = 4 (quadrato)");

        double perimetroQuadrato = quadrato.perimetro(); // 4 lati da 2 -> 8
        check(Punto.doubleEquals(perimetroQuadrato, 8.0),
                "Poligono (lati): perimetro quadrato lato 2 = 8");

        check(quadrato.isEquilatero(),
                "Poligono (lati): quadrato è equilatero");

        // ---------- getLati coerente con il perimetro ----------
        Segmento[] latiTriangolo = triangolo.getLati();
        double sommaLatiTri = 0.0;
        if(latiTriangolo != null) {
            for (Segmento s : latiTriangolo) {
                sommaLatiTri += s.lunghezza();
            }
        }
        check(Punto.doubleEquals(sommaLatiTri, triangolo.perimetro()),
                "Poligono: somma lunghezze getLati == perimetro");

        // ---------- Poligono da lati non chiusi -> eccezione ----------
        boolean eccezionePoligonoLatiAperti = false;
        try {
            Segmento[] latiAperti = {
                new Segmento(q1, q2),
                new Segmento(q2, q3),
                new Segmento(q3, q4) // non chiude su q1
            };
            Poligono errorePol3 = new Poligono(latiAperti);
        } catch (RuntimeException e) {
            eccezionePoligonoLatiAperti = true;
        }
        check(eccezionePoligonoLatiAperti,
                "Poligono (lati): catena aperta -> eccezione");

        // ---------- RIEPILOGO ----------
        System.out.println();
        System.out.println("Test passati: " + testsPassed + " / " + testsRun);
    }
}
