package image;

import javafx.scene.paint.Color;

public abstract class RasterImage implements Image {
    protected int width;
    protected int height;

    protected RasterImage(Color color, int width, int height){
        setWidth(width);
        setHeight(height);
        createRepresentation();
        setPixelsColor(color);
    }

    protected RasterImage(Color[][] pixels){
        util.Matrices.requiresNonNull(pixels);
        util.Matrices.requiresNonZeroDimensions(pixels);
        util.Matrices.requiresRectangularMatrix(pixels);

        setWidth(util.Matrices.getRowCount(pixels));
        setHeight(util.Matrices.getColumnCount(pixels));
        createRepresentation();
        setPixelsColor(pixels);
    }

    public abstract void createRepresentation();

    public abstract void setPixelsColor(Color[][] pixels);

    public abstract void setPixelColor(Color color, int x, int y);

    public abstract void setPixelsColor(Color color);

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
