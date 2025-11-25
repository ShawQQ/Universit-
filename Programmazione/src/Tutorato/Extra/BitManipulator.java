package Tutorato.Extra;
/**
 * Tralasciando il main, che serve per fare i test, i seguenti medoti
 * sono implementati, ma non funzionano (infatti non passano i test).
 * Occore dunque debuggare l'implementazione dei metodi.
 */
public class BitManipulator {
    public boolean main() {
        boolean success = true;
        boolean[][] tests = {
            {false, true, true},
            {true, true, true, true, false},
            {false, false, false},
            {false, false, true},
            {true},
            {true, false, false, false},
            {true, false, true, false},
            {true, true, true, true},
            {true, false, false, false, false, false},
            {true, false, false, true},
            {false, true, false, false, true, true}
        };

        int[] expected1 = {
            3,
            30,
            0,
            1,
            1,
            8,
            10,
            15,
            32,
            9,
            19
        };

        String[] expected2 = {
            "11",
            "11110",
            "0",
            "1",
            "1",
            "1000",
            "1010",
            "1111",
            "100000",
            "1001",
            "10011"
        };

        for (int i = 0; i < tests.length; i++) {
            int got = fromBitsArrayToInt(tests[i]);
            if (got == expected1[i]) {
                System.out.println("Test " + i + " OK (valore: " + got + ")");
            } else {
                success = false;
                System.out.println("Test " + i + " FALLITO: atteso " + expected1[i] + " ma ottenuto " + got);
            }
        }
        for (int i = 0; i < tests.length; i++) {
            String got = fromBitsToString(tests[i]);
            if (got.equals(expected2[i])) {
                System.out.println("Test " + i + " OK (valore: " + got + ")");
            } else {
                success = false;
                System.out.println("Test " + i + " FALLITO: atteso " + expected2[i] + " ma ottenuto " + got);
            }
        }
        return success;
    }

    /**
     * Questo metodo prende in input un array di booleani come
     * se fossero una sequenza di bit (true è 1 e false è 0)
     * e le converte in un numero in base decimale
     * @param bits
     * @return
     */
    public int fromBitsArrayToInt(boolean[] bits){
        int base = 1;
        int result = 0;
        for (int i = bits.length - 1; i >= 0; i--) {
            if(bits[i]){
                result += base;
            }
            base <<= 1;
        }
        return result;
    }

    /**
     * Questo metodo prende in input un array di booleani come
     * se fossero una sequenza di bit (true è 1 e false è 0)
     * e li converte in una rappresentazione a Stringa
     * @param bits
     * @return
     */
    public String fromBitsToString(boolean[] bits){
        String result = "";
        for (int i = 0; i < bits.length; i++) {
            String currentChar = bits[i] ? "1" : "0";
            if(!currentChar.equals("0") || !result.isEmpty()){
                result += currentChar;
            }
        }
        return result.isEmpty() ? "0" : result;
    }
}
