package image;

import javafx.scene.paint.Color;
import util.Matrices;

public class BruteRasterImage extends RasterImage {

    private Color[][] pixels;

    public BruteRasterImage(Color color, int width, int height){
        super(color,width,height);
    }

    public BruteRasterImage(Color[][] colors){
        super(colors);
    }

    public void createRepresentation(){ pixels = new Color[getWidth()][getHeight()]; }

    public void setPixelColor(Color color, int x, int y){
        pixels[x][y] = color;
    }

    public Color getPixelColor(int x, int y) {
        return pixels[x][y];
    }

    public void setPixelsColor(Color[][] pixels){
        this.pixels = pixels;
    }

    public void setPixelsColor(Color color){
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                pixels[x][y] = color;
            }
        }
    }
}
