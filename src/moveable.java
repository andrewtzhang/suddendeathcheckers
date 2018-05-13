public class moveable extends object{
    private int vX, vY;
    public moveable(int X, int Y, int width, int height, int vX, int vY){
        super(X,Y,width,height);
        this.vX = vX;
        this.vY = vY;
    }

    public int getvX() {
        return vX;
    }

    public void setvX(int vX) {
        this.vX = vX;
    }

    public int getvY() {
        return vY;
    }

    public void setvY(int vY) {
        this.vY = vY;
    }

    public void increment(){
        setX(getX()+vX);
        setY(getY()+vY);
    }
}