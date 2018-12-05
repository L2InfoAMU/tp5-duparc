package image;

import javafx.scene.paint.Color;
import util.Matrices;

public class BruteRasterImage extends RasterImage {

    private Color[][] pixels;

    public BruteRasterImage(Color color, int width, int height){
        this.width = width;
        this.height = height;
        createRepresentation();
        setPixelsColor(color);
    }

    public BruteRasterImage(Color[][] colors){
        util.Matrices.requiresNonNull(colors);
        util.Matrices.requiresNonZeroDimensions(colors);
        util.Matrices.requiresRectangularMatrix(colors);

        width = util.Matrices.getRowCount(colors);
        height = util.Matrices.getColumnCount(colors);
        createRepresentation();

        setPixelsColor(colors);
    }

    public void createRepresentation(){
        pixels = new Color[this.width][this.height];
    }

    public void setPixelColor(Color color, int x, int y){
        pixels[x][y] = color;
    }

    public Color getPixelColor(int x, int y) {
        return pixels[x][y];
    }

    private void setPixelsColor(Color[][] pixels){
        this.pixels = pixels;
    }

    private void setPixelsColor(Color color){
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels[x][y] = color;
            }
        }
    }
}
