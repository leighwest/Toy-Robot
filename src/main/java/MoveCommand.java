public class MoveCommand implements ICommand {
    @Override
    public void execute(Robot robot) {
        if (robot.getOnTable()) {
//        log and ignore any move which would result in the robot falling off the table
            switch (robot.getOrientation()) {
                case NORTH:
                    robot.incPosY();
                    break;
                case SOUTH:
                    robot.decPosY();
                    break;
                case EAST:
                    robot.incPosX();
                    break;
                case WEST:
                    robot.decPosX();
                    break;
            }
        }
    }
}



