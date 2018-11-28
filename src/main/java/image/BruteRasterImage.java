package image;

import javafx.scene.paint.Color;
import util.Matrices;

public class BruteRasterImage implements Image {

    private int width;
    private int height;
    private Color[][] pixels = new Color[width][height];

    public BruteRasterImage(Color color, int width, int height){
        this.width = width;
        this.height = height;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels[x][y] = color;
            }
        }
    }
}
