package viewer;

import image.Point;
import image.RasterImage;
import javafx.scene.paint.Color;

import java.util.HashMap;


public class SparseRasterImage extends RasterImage {

    private HashMap<Point,Color> map;

    public SparseRasterImage(Color color, int width, int height){
        super(color,width,height);
    }

    public SparseRasterImage(Color[][] pixels){
        super(pixels);
    }

    @Override
    public void createRepresentation() {
        setMap(new HashMap<Point,Color>());
    }

    public HashMap getMap() {
        return map;
    }

    public void setMap(HashMap map) {
        this.map = map;
    }

    @Override
    public void setPixelColor(Color color, int x, int y) {
        map.put(new Point(x,y),color);
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return map.get(new Point(x,y));
    }

    @Override
    public void setPixelsColor(Color[][] pixels) {
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                setPixelColor(pixels[x][y],x,y);
            }
        }
    }

    @Override
    public void setPixelsColor(Color color) {
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                setPixelColor(color,x,y);
            }
        }
    }
}
