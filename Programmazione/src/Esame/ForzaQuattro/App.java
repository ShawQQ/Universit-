package Esame.ForzaQuattro;

/**
*   ATTENZIONE 
*
*   decommenta il contenuto di questa classe
*   per ottenere un main per testare 
*   la classe ForzaQuattroPartita,
*   dopo averla implementata.
 */

public class App {
    private static int passed = 0;
    private static int failed = 0;

    private static void check(int testNum, boolean condition) {
        if (condition) {
            passed++;
            System.out.println("Test " + testNum + ": SUCCESSO");
        } else {
            failed++;
            System.out.println("Test " + testNum + ": FALLIMENTO");
        }
    }

    private static void expectThrows(int testNum, Class<? extends Throwable> expected, Runnable action) {
        try {
            action.run();
            failed++;
            System.out.println("Test " + testNum + ": FALLIMENTO (attesa eccezione " + expected.getSimpleName() + ")");
        } catch (Throwable t) {
            if (expected.isInstance(t)) {
                passed++;
                System.out.println("Test " + testNum + ": SUCCESSO");
            } else {
                failed++;
                System.out.println("Test " + testNum + ": FALLIMENTO (lanciata " + t.getClass().getSimpleName() + ")");
            }
        }
    }

    private static boolean cellEquals(int[][] g, int r, int c, int v) {
        return g[r][c] == v;
    }

    private static boolean allEmpty(int[][] g) {
        for (int r = 0; r < g.length; r++) {
            for (int c = 0; c < g[0].length; c++) {
                if (g[r][c] != -1) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int t = 1;

        {
            ForzaQuattroPartita p = new ForzaQuattroPartita();
            int[][] g = p.daiGriglia();
            check(t++, g.length == 6 && g[0].length == 6 && allEmpty(g));
        }

        {
            ForzaQuattroPartita p = new ForzaQuattroPartita(6, 7, 4, 2);
            int[][] g = p.daiGriglia();
            check(t++, g.length == 6 && g[0].length == 7);
        }

        expectThrows(t++, IllegalArgumentException.class,
                () -> new ForzaQuattroPartita(6, 6, 2, 2)); // perVincere < 3

        expectThrows(t++, IllegalArgumentException.class,
                () -> new ForzaQuattroPartita(3, 6, 4, 2)); // righe < perVincere

        expectThrows(t++, IllegalArgumentException.class,
                () -> new ForzaQuattroPartita(6, 3, 4, 2)); // colonne < perVincere

        expectThrows(t++, IllegalArgumentException.class,
                () -> new ForzaQuattroPartita(6, 6, 4, 1)); // giocatori < 2

        expectThrows(t++, IllegalArgumentException.class,
                () -> new ForzaQuattroPartita(6, 6, 4, 5)); // giocatori > perVincere

        {
            ForzaQuattroPartita p = new ForzaQuattroPartita();
            p.faiMossa(0);
            p.faiMossa(1);
            p.resetPartita();
            check(t++, p.getGiocatore() == 0 && p.getVincitore() == -1 && allEmpty(p.daiGriglia()));
        }

        {
            ForzaQuattroPartita p = new ForzaQuattroPartita();
            p.faiMossa(0); // player 0
            check(t++, p.getGiocatore() == 1);
        }

        {
            ForzaQuattroPartita p = new ForzaQuattroPartita();
            p.faiMossa(0); // 0
            p.faiMossa(0); // 1
            check(t++, p.getGiocatore() == 0);
        }

        {
            ForzaQuattroPartita p = new ForzaQuattroPartita();
            p.faiMossa(2); // P0 cade in basso
            int[][] g = p.daiGriglia();
            check(t++, cellEquals(g, 5, 2, 0));
        }

        {
            ForzaQuattroPartita p = new ForzaQuattroPartita();
            p.faiMossa(2); // P0 in (5,2)
            p.faiMossa(2); // P1 in (4,2)
            int[][] g = p.daiGriglia();
            check(t++, cellEquals(g, 5, 2, 0) && cellEquals(g, 4, 2, 1));
        }

        {
            ForzaQuattroPartita p = new ForzaQuattroPartita(4, 4, 3, 2);
            // riempi colonna 0 con 4 mosse
            check(t++, p.faiMossa(0));
            check(t++, p.faiMossa(0));
            check(t++, p.faiMossa(0));
            check(t++, p.faiMossa(0));
            // quinta mossa: colonna piena -> false
            check(t++, !p.faiMossa(0));
        }

        {
            ForzaQuattroPartita p = new ForzaQuattroPartita();
            expectThrows(t++, IndexOutOfBoundsException.class, () -> p.faiMossa(-1));
        }

        {
            ForzaQuattroPartita p = new ForzaQuattroPartita();
            expectThrows(t++, IndexOutOfBoundsException.class, () -> p.faiMossa(6));
        }

        {
            ForzaQuattroPartita p = new ForzaQuattroPartita();
            int[][] g1 = p.daiGriglia();
            g1[5][0] = 99; 
            int[][] g2 = p.daiGriglia();
            check(t++, g2[5][0] == -1);
        }

        {
            ForzaQuattroPartita p = new ForzaQuattroPartita(); // 6x6, win 4
            // P0 in col 0 quattro volte, alternando P1 in col 1
            p.faiMossa(0); // 0
            p.faiMossa(1); // 1
            p.faiMossa(0); // 0
            p.faiMossa(1); // 1
            p.faiMossa(0); // 0
            p.faiMossa(1); // 1
            p.faiMossa(0); // 0 vince
            check(t++, p.getVincitore() == 0);
        }

        {
            ForzaQuattroPartita p = new ForzaQuattroPartita();
            // stessa vittoria verticale rapida
            p.faiMossa(0); p.faiMossa(1);
            p.faiMossa(0); p.faiMossa(1);
            p.faiMossa(0); p.faiMossa(1);
            p.faiMossa(0); // vince
            expectThrows(t++, ClosedGameException.class, () -> p.faiMossa(2));
        }

        {
            ForzaQuattroPartita p = new ForzaQuattroPartita();
            p.faiMossa(0); // 0
            p.faiMossa(5); // 1
            p.faiMossa(1); // 0
            p.faiMossa(5); // 1
            p.faiMossa(2); // 0
            p.faiMossa(5); // 1
            p.faiMossa(3); // 0 vince
            check(t++, p.getVincitore() == 0);
        }
        
        {
            ForzaQuattroPartita p = new ForzaQuattroPartita();
            p.faiMossa(0); // P0 -> (5,0)
            p.faiMossa(1); // P1 -> (5,1)

            p.faiMossa(1); // P0 -> (4,1)
            p.faiMossa(2); // P1 -> (5,2)

            p.faiMossa(5); // P0 "sposta turno" irrilevante
            p.faiMossa(2); // P1 -> (4,2)

            p.faiMossa(2); // P0 -> (3,2)
            p.faiMossa(3); // P1 -> (5,3)

            p.faiMossa(5); // P0
            p.faiMossa(3); // P1 -> (4,3)

            p.faiMossa(5); // P0
            p.faiMossa(3); // P1 -> (3,3)

            p.faiMossa(3); // P0 -> (2,3) vince diagonale \
            check(t++, p.getVincitore() == 0);
        }

        {
            ForzaQuattroPartita p = new ForzaQuattroPartita();
            // Diagonale / per P0: (5,3),(4,2),(3,1),(2,0)
            p.faiMossa(3); // P0 -> (5,3)
            p.faiMossa(2); // P1 -> (5,2)

            p.faiMossa(2); // P0 -> (4,2)
            p.faiMossa(1); // P1 -> (5,1)

            p.faiMossa(5); // P0
            p.faiMossa(1); // P1 -> (4,1)

            p.faiMossa(1); // P0 -> (3,1)
            p.faiMossa(0); // P1 -> (5,0)

            p.faiMossa(5); // P0
            p.faiMossa(0); // P1 -> (4,0)

            p.faiMossa(5); // P0
            p.faiMossa(0); // P1 -> (3,0)

            p.faiMossa(0); // P0 -> (2,0) vince diagonale /
            check(t++, p.getVincitore() == 0);
        }

        {
            ForzaQuattroPartita p = new ForzaQuattroPartita();
            p.faiMossa(0);
            p.faiMossa(1);
            p.faiMossa(2);
            check(t++, p.getVincitore() == -1);
        }

        {
            ForzaQuattroPartita p = new ForzaQuattroPartita(4, 4, 3, 2);
            p.faiMossa(0); // 0
            p.faiMossa(3); // 1
            p.faiMossa(1); // 0
            p.faiMossa(3); // 1
            p.faiMossa(2); // 0 vince (3 in fila)
            check(t++, p.getVincitore() == 0);
        }

        {
            ForzaQuattroPartita p = new ForzaQuattroPartita(6, 6, 4, 3);
            check(t++, p.getGiocatore() == 0);
            p.faiMossa(0);
            check(t++, p.getGiocatore() == 1);
            p.faiMossa(0);
            check(t++, p.getGiocatore() == 2);
            p.faiMossa(0);
            check(t++, p.getGiocatore() == 0);
        }

        {
            ForzaQuattroPartita p = new ForzaQuattroPartita(6, 6, 4, 3);
            p.faiMossa(4); // 0
            p.faiMossa(4); // 1
            p.faiMossa(4); // 2
            int[][] g = p.daiGriglia();
            check(t++, g[5][4] == 0 && g[4][4] == 1 && g[3][4] == 2);
        }

        {
            ForzaQuattroPartita p = new ForzaQuattroPartita(3, 3, 3, 2);

            p.faiMossa(0); // 0
            p.faiMossa(0); // 1
            p.faiMossa(0); // 0

            p.faiMossa(1); // 1
            p.faiMossa(1); // 0
            p.faiMossa(1); // 1

            check(t++, p.getVincitore() == -1);

            p.faiMossa(2); // 0

            check(t++, p.getVincitore() == 0);

            expectThrows(t++, ClosedGameException.class, () -> p.faiMossa(0));
        }

        System.out.println("---- RISULTATO ----");
        System.out.println("Passati: " + passed);
        System.out.println("Falliti: " + failed);
        System.out.println("Totale: " + (passed + failed) + " (attesi: 35)");
    }
}
