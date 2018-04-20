public class piece {
    boolean goesDown;
    boolean isKing;

    public piece(boolean goesDown){
        this.goesDown = goesDown;
    }

    public boolean isDown() {
        return goesDown;
    }

    public boolean isKing() {
        return isKing;
    }
}
