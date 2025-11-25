package Tutorato.Extra;

/**
 * Conosci il gioco del sudoku? Una tabella numerica (generalmente 9x9)
 * dove alcuni numeri sono già presenti, altri devono essere aggiunti.
 * Ma non possono essere aggiunti a caso, non si accettano ripetizioni
 * nella stessa riga, colonna o quadrante (quindi i 9 sottocubi 3x3 che si formano)
 */
public class SudokuChecker {

    /**
     * Ritorna true se e solo se quella passata è una combinazione
     * corretta (un array di nove posizioni, con numeri da 1 a 9 senza ripetizioni)
     * ci possono essere zeri, che fungono da jolly (contano come se nel gioco non
     * hai ancora deciso che numero mettere in quella casella)
     * @param combination
     * @return torna true se è una combinazione corretta, false in tutti gli altri ambiti
     */
    private boolean checkCombination(int[] combination){
        if(combination == null || combination.length != 9) return false;
        int[] found = new int[9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < i; j++){
                if(combination[i] == found[j]) return false;
            }
            found[i] = combination[i];
        }
        return true;
    }

    /**
     * Ritorna la riga correttamente, tuttavia sarebbe meglio gestire i casi di errore
     * se table è null, di dimensione diversa o l'index è sbagliato, torna un array con nove 0.
     * Consiglio: adopera il try catch
     * @param table
     * @param rowIndex
     * @return
     */
    private int[] getRow(int[][] table, int rowIndex){
        if(!isValid(table) || !isValid(rowIndex)){
            return new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        }
        return table[rowIndex];
    }
    
    /**
     * Come sopra, funziona per i casi buoni, ma noi dobbiamo gestire quelli
     * inaspettati. Questa volta controlla prima gli argomenti e, se sbagliati
     * lancia una IllegalArgumentException
     * @param table
     * @param columnIndex
     * @return
     */
    private int[] getColumn(int[][] table, int columnIndex){
        if(!isValid(table) || !isValid(columnIndex)) throw new IllegalArgumentException("Argomenti non validi");
        int[] result = new int[9];
        for (int i = 0; i < result.length; i++) {
            result[i] = table[i][columnIndex];
        }
        return result;
    }

    /**
     * Controlla se una tabella e' valida per il sudoku
     * @param table tabella da controllare
     * @return true se la tabella e' valida, false altrimenti
     */
    private boolean isValid(int[][] table){
        return table != null && table.length == 9 && table[0].length == 9;
    }

    /**
     * Controlla se un indice e' valido
     * @param index indice da controllare
     * @return true se l'indice e' valido, false altrimenti
     */
    private boolean isValid(int index){
        return index >= 0 && index < 9;
    }

    /**
     * Ritorna i numeri del quadrante, inserire anche qui un controllo simile
     * a quello fatto su getColumn per evitare input dannosi. se la tabella 
     * non va bene lancia l'eccezione, mentre se 
     * @param table
     * @param quadrantIndex
     * @return
     */
    private int[] getQuadrant(int[][] table, int quadrantIndex) {
        if(!isValid(table) || !isValid(quadrantIndex)){
            throw new IllegalArgumentException("Parametri non validi");
        }
        int[] result = new int[9];
        // mi calcolo le posizioni iniziali
        int startRow = (quadrantIndex / 3) * 3;
        int startCol = (quadrantIndex % 3) * 3;
        // indice di appoggio per inserire facilmente nell'array
        int k = 0;
        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {
                // r e c sono le posizioni che scorrono nella tabella
                // questo uso del for permette di "naviagare" 
                // comodamente in una matrice
                result[k++] = table[r][c];
            }
        }
        return result;
    }

    /**
     * Spesso una funzione complessa non è altro che
     * un'insieme di tante funzioni semplici. Nella programmazione
     * ad oggetti una classe dovrebbe fare UNA cosa, esponendola 
     * tramite un metodo pubblico. la logica viene quindi spezzettata
     * e suddivisa nei vari metodi privati, non esposti ma fondamentali
     * per il servizio offerto dalla classe.
     * @param table
     * @return
     */
    public boolean checkSudoku(int[][] table){
        for (int i = 0; i < 9; i++) {
            if(!checkCombination(getRow(table, i)))
                return false;
            if(!checkCombination(getColumn(table, i)))
                return false;
            if(!checkCombination(getQuadrant(table, i)))
                return false;
        }
        return true;
    }

}
