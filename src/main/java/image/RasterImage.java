package image;

public abstract class RasterImage implements Image {
    protected int width;
    protected int height;

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
