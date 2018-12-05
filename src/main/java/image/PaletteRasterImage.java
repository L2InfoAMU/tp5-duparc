package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage implements Image {

    private int width;
    private int height;
    private int[][] indexesOfColor;
    private List<Color> palette;

    public PaletteRasterImage(Color color, int width, int height){
        this.width = width;
        this.height = height;
        indexesOfColor = new int[width][height];
        palette = new ArrayList<Color>();
        palette.add(color);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                indexesOfColor[x][y] = palette.indexOf(color);
            }
        }
    }

    public PaletteRasterImage(Color[][] pixels){
        width = util.Matrices.getRowCount(pixels);
        height = util.Matrices.getColumnCount(pixels);
        indexesOfColor = new int[width][height];
        palette = new ArrayList<Color>();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                while (!palette.contains(pixels[x][y]))
                    palette.add(pixels[x][y]);
                indexesOfColor[x][y] = palette.indexOf(pixels[x][y]);
            }
        }
    }

    public void createRepresentation(){

    }

    public void setPixelsColor(Color[][] pixels){

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
