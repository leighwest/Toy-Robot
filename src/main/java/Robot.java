public class Robot {

    private static final int MAX_X = 4;
    private static final int MAX_Y = 4;
    private static final int MIN_X = 0;
    private static final int MIN_Y = 0;

    private int posX;
    private int posY;
    private Orientation orientation;
    private boolean onTable;

    public Robot() {
        onTable = false;
    }

    public void setPosX(int value) {
        if (isValidX(value)) {
            posX = value;
        }
    }

    public void incPosX() {
        setPosX(posX + 1);
    }

    public void decPosX() {
        setPosX(posX - 1);
    }

    public void incPosY() {
        setPosY(posY + 1);
    }

    public void decPosY() {
        setPosY(posY - 1);
    }

    public int getPosX() {return posX;}

    public void setPosY(int value) {
        if (isValidY(value)) {
            posY = value;
        }
    }
    public int getPosY() {return posY;}

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Orientation getOrientation() {return this.orientation;}

    public void setOnTable(boolean value) {
        onTable = value;
    }

    public boolean getOnTable() {return this.onTable;}

    public boolean isValidX(int value) {
        return (value <= Robot.MAX_X && value >= Robot.MIN_X);
    }

    public boolean isValidY(int value) {
        return (value <= Robot.MAX_Y && value >= Robot.MIN_Y);
    }
}
