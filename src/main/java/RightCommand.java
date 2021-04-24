public class RightCommand implements ICommand {
    @Override
    public void execute(Robot robot) {
        if (robot.getOnTable()) {
            switch (robot.getOrientation()) {
                case NORTH:
                    robot.setOrientation(Orientation.EAST);
                    break;
                case EAST:
                    robot.setOrientation(Orientation.SOUTH);
                    break;
                case SOUTH:
                    robot.setOrientation(Orientation.WEST);
                    break;
                case WEST:
                    robot.setOrientation(Orientation.NORTH);
                    break;
            }
        }
    }


}

