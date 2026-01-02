package Esame.Pixel;

public class PixelImage {
    private Pixel[][] pixels;
    public PixelImage(Pixel[][] pixels){
        if(pixels == null) throw new IllegalArgumentException("Immagine non valida");
        this.pixels = pixels;
    }

    /**
     * torna tutti pixel sotto forma di codice hex
     * @return
     */
    public String[][] getImage(){
        String[][] result = new String[this.getHeigth()][this.getWight()];
        for(int i = 0; i < this.getHeigth(); i++){
            for(int j = 0; j < this.getWight(); j++){
                result[i][j] = this.pixels[i][j].getRGB();
            }
        }
        return result;
    }

    /**
     * Almeno un pixel è null
     * @return
     */
    public boolean hasVoid(){
        for(int i = 0; i < this.getHeigth(); i++){
            for(int j = 0; j < this.getWight(); j++){
                if(this.pixels[i][j] == null) return true;
            }
        }
        return false;
    }

    /**
     * altezza in pixel dell'immagine
     * @return
     */
    public int getHeigth(){
        return this.pixels.length;
    }

    /**
     * larghezza in pixel dell'immagine
     * @return
     */
    public int getWight(){
        return this.getHeigth() > 0 ? this.pixels[0].length : 0;
    }

    /**
     * true se le coordinate h e w sono nel limite
     * @param h
     * @param w
     * @param pixel
     * @return
     */
    public boolean updatePixel(int h, int w, Pixel pixel){
        if(h < 0 || w < 0 || h > this.getHeigth() || w > this.getWight()) return false;
        this.pixels[h][w] = pixel;
        return true;
    }

}
