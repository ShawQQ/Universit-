package Esame.Pixel;

public class SimplePixel implements Pixel {
    private String rgb;
    /**
     * Controlla che i numeri vadano da 0 a 255
     * @param r
     * @param g
     * @param b
     */
    public SimplePixel(int r, int g, int b){
        if(!isValid(r) || !isValid(g) || !isValid(b)) throw new IllegalArgumentException("Colore non valido");
        this.rgb = this.toHex(r) + this.toHex(g) + this.toHex(b);
    }

    /**
     * Controlla che il formato sia corretto
     * @param hexColor
     */
    public SimplePixel(String hexColor){
        if(!isValid(hexColor)) throw new IllegalArgumentException("Colore non valido");
        this.rgb = hexColor;
    }

    @Override
    public String getRGB() {
        return this.rgb;
    }

    private boolean isValid(int i) {
        return i >= 0 && i <= 255;
    }
    private boolean isValid(String hex){
        if(hex.length() != 7) return false;
        hex = hex.toUpperCase();
        String validChar = "";
        for(int i = 0; i < 16; i++){
            validChar = ""+getMostSignificantHexDigit(i);
            hex = hex.replaceAll(validChar, "");
        }
        return hex.equals("#");
    }

    private String toHex(int i){
        String hex = "";
        do{
            hex = getMostSignificantHexDigit(i % 16) + hex;
            i /= 16;
        }while(i != 0);
        return hex;
    }

    private String getMostSignificantHexDigit(int i){
        if(i < 10){
            return ""+i;
        }else{
            return ""+(char)('A'+(i - 10));
        }
    }
}
