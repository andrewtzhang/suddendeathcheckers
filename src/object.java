public class object {
    private int X, Y, width, height;

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public object(int X, int Y, int width, int height){
        this.X = X;
        this.Y = Y;
        this.width = width;
        this.height = height;
    }
}
