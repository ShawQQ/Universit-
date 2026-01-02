package Esame.Pixel;

public class App {
    
    /*
        **ISTRUZIONI**
        Implementate le classi SimplePixel e PixelImage seguendo queste linee guida.
        1. avete un'ora di tempo.
        2. non usate fonti di informazioni esterne, cercate di farlo senza nessun tipo di aiuto.
        3. coprite tutti i casi di errore con una appropriata RuntimeException
        4. avviando il programma dovrebbe apparire un'interfaccia funzionante, se tutto è andato bene.
    */
    
    public static void main(String[] args) {
        Pixel[][] pixels = new Pixel[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                pixels[i][j] = new SimplePixel(0,0,0);
            }
        }
        
        PixelImage pixelImage = new PixelImage(pixels);
        PixelImageGUI gui = new PixelImageGUI(pixelImage);
        gui.setVisible(true);
    }
}
