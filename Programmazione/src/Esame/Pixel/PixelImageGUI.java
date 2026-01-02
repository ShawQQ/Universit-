package Esame.Pixel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PixelImageGUI extends JFrame {
    
    private PixelImage pixelImage;
    private JPanel panel;

    // Definiamo un array di colori per il ciclo (rosso, verde, blu, bianco, nero)
    private final Color[] COLORS = {Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.WHITE};
    
    // Indice per sapere quale colore selezionare
    private int[] colorIndexes;

    // Costruttore che prende un oggetto PixelImage come parametro
    public PixelImageGUI(PixelImage pixelImage) {
        this.pixelImage = pixelImage;
        this.colorIndexes = new int[pixelImage.getHeigth() * pixelImage.getWight()];
        this.panel = new PixelImagePanel();
        
        // Configura la finestra principale
        setTitle("Pixel Image GUI");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        setLocationRelativeTo(null);  // Posiziona la finestra al centro dello schermo
        
        // Aggiungi il MouseListener per gestire il clic del mouse
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Calcola il pixel cliccato
                int pixelWidth = getWidth() / pixelImage.getWight();
                int pixelHeight = getHeight() / pixelImage.getHeigth();
                int x = e.getX() / pixelWidth; // Coordinate relative al pixel
                int y = e.getY() / pixelHeight;
                
                // Aggiorna il pixel con il prossimo colore
                int index = y * pixelImage.getWight() + x;
                colorIndexes[index] = (colorIndexes[index] + 1) % COLORS.length;

                // Cambia il colore del pixel
                String hexColor = "#" + Integer.toHexString(COLORS[colorIndexes[index]].getRGB()).substring(2);
                Pixel newPixel = new SimplePixel(hexColor);
                pixelImage.updatePixel(y, x, newPixel);

                // Rendi necessario ridisegnare il pannello
                panel.repaint();
            }
        });
    }

    // Classe interna per il pannello che disegna l'immagine
    private class PixelImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            int pixelWidth = getWidth() / pixelImage.getWight();
            int pixelHeight = getHeight() / pixelImage.getHeigth();
            String[][] pixels = pixelImage.getImage();
            for (int h = 0; h < pixelImage.getHeigth(); h++) {
                for (int w = 0; w < pixelImage.getWight(); w++) {
                    String pixel = pixels[h][w];
                    Color color = pixel != null 
                            ? Color.decode(pixel) : Color.BLACK; // Colore vuoto = nero
                    g.setColor(color);
                    g.fillRect(w * pixelWidth, h * pixelHeight, pixelWidth, pixelHeight);
                }
            }
        }
    }
}
