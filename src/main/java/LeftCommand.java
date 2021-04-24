public class LeftCommand implements ICommand {
    @Override
    public void execute(Robot robot) {
        if (robot.getOnTable()) {
            switch (robot.getOrientation()) {
                case NORTH:
                    robot.setOrientation(Orientation.WEST);
                    break;
                case EAST:
                    robot.setOrientation(Orientation.NORTH);
                    break;
                case SOUTH:
                    robot.setOrientation(Orientation.EAST);
                    break;
                case WEST:
                    robot.setOrientation(Orientation.SOUTH);
                    break;
            }
        }
    }
}
