public class PlaceCommand implements ICommand {

    int posX;
    int posY;
    Orientation orientation;

    public PlaceCommand(int posX, int posY, String orientation) {
        this.posX = posX;
        this.posY = posY;
        this.orientation = Orientation.valueOf(orientation);
    }

    @Override
    public void execute(Robot robot) {
        if (robot.isValidX(posX) && robot.isValidY(posY)) {
            robot.setOnTable(true);
            robot.setPosX(posX);
            robot.setPosY(posY);
            robot.setOrientation(orientation);
        }
        else {
            System.err.println("Robot must be placed on the table");
        }
    }
}
