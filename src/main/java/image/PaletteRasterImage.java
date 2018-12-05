package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage extends RasterImage {

    private int[][] indexesOfColor;
    private List<Color> palette;

    public PaletteRasterImage(Color color, int width, int height){
        this.width = width;
        this.height = height;
        createRepresentation();
        setPixelsColor(color);
    }

    public PaletteRasterImage(Color[][] pixels){
        util.Matrices.requiresNonNull(pixels);
        util.Matrices.requiresNonZeroDimensions(pixels);
        util.Matrices.requiresRectangularMatrix(pixels);

        width = util.Matrices.getRowCount(pixels);
        height = util.Matrices.getColumnCount(pixels);
        createRepresentation();

        setPixelsColor(pixels);
    }

    public void createRepresentation(){
        indexesOfColor = new int[width][height];
        palette = new ArrayList<Color>();
    }

    public void setPixelColor(Color color, int x, int y){
        if(!palette.contains(color))
            palette.add(color);
        indexesOfColor[x][y] = palette.indexOf(color);
    }

    public Color getPixelColor(int x, int y) {
        return palette.get(indexesOfColor[x][y]);
    }

    public void setPixelsColor(Color[][] pixels){
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                while (!palette.contains(pixels[x][y]))
                    palette.add(pixels[x][y]);
                indexesOfColor[x][y] = palette.indexOf(pixels[x][y]);
            }
        }
    }

    public void setPixelsColor(Color color){
        if (!palette.contains(color))
            palette.add(color);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                indexesOfColor[x][y] = palette.indexOf(color);
            }
        }
    }
}
