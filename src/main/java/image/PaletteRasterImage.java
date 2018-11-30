package image;

import javafx.scene.paint.Color;

public class PaletteRasterImage implements Image {

    private int width;
    private int height;
    private Color[][] pixels;

    public PaletteRasterImage(Color color, int width, int height){
        this.width = width;
        this.height = height;
        pixels = new Color[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixels[x][y] = color;
            }
        }
    }

    public PaletteRasterImage(Color[][] pixels){
        width = util.Matrices.getRowCount(pixels);
        height = util.Matrices.getColumnCount(pixels);
        this.pixels = pixels;
    }

    public void createRepresentation(){

    }
}
