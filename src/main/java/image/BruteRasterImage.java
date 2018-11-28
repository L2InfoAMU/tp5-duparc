package image;

import javafx.scene.paint.Color;
import util.Matrices;

public class BruteRasterImage implements Image {

    private int width;
    private int height;
    private Color[][] pixels;

    public BruteRasterImage(Color color, int width, int height){
        this.width = width;
        this.height = height;
        pixels = new Color[this.width][this.height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels[x][y] = color;
            }
        }
    }

    public BruteRasterImage(Color[][] colors){
        util.Matrices.requiresNonNull(colors);
        util.Matrices.requiresNonZeroDimensions(colors);
        util.Matrices.requiresRectangularMatrix(colors);

        width = util.Matrices.getColumnCount(colors);
        height = util.Matrices.getRowCount(colors);
        pixels = colors;
    }

    public void createRepresentation(){

    }
}
