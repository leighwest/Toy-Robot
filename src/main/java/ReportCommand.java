public class ReportCommand implements ICommand {
    @Override
    public void execute(Robot robot) {
        if (robot.getOnTable()) {
            System.out.println("Robot is at coordinates (" + robot.getPosX() + ", " + robot.getPosY() + ") and is facing " + robot.getOrientation() + ".");
        } else {
            System.out.println("Robot is not on the table.");
        }
    }
}
