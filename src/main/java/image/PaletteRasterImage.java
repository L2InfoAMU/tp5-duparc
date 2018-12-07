package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage extends RasterImage {

    private int[][] indexesOfColor;
    private List<Color> palette;

    public PaletteRasterImage(Color color, int width, int height){
        super(color,width,height);
    }

    public PaletteRasterImage(Color[][] pixels){
        super(pixels);
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
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                while (!palette.contains(pixels[x][y]))
                    palette.add(pixels[x][y]);
                indexesOfColor[x][y] = palette.indexOf(pixels[x][y]);
            }
        }
    }

    public void setPixelsColor(Color color){
        if (!palette.contains(color))
            palette.add(color);

        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                indexesOfColor[x][y] = palette.indexOf(color);
            }
        }
    }
}
