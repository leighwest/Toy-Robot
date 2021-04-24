import org.junit.Test;

import static org.junit.Assert.*;


public class RobotTest {
    @Test
    public void robotSuccessfullyPlacedOnTable() {
        // Setup
        Robot robot = new Robot();
        PlaceCommand pc = new PlaceCommand(3, 2, "NORTH");

        // Precondition
        assertFalse(robot.getOnTable());

        // Test function
        pc.execute(robot);

        // Post-condition
        assertTrue(robot.getOnTable());
        assertEquals(3, robot.getPosX());
        assertEquals(2, robot.getPosY());
        assertEquals(Orientation.NORTH, robot.getOrientation());


    }

    @Test
    public void robotSuccessfullyMovesNorth() {
        // Setup
        Robot robot = new Robot();
        PlaceCommand pc = new PlaceCommand(1, 2, "NORTH");
        pc.execute(robot);

        // Precondition
        assertTrue(robot.getOnTable());
        assertEquals(1, robot.getPosX());
        assertEquals(2, robot.getPosY());
        assertEquals(Orientation.NORTH, robot.getOrientation());

        // Test function
        MoveCommand mc = new MoveCommand();
        mc.execute(robot);

        // Post-condition
        assertTrue(robot.getOnTable());
        assertEquals(1, robot.getPosX());
        assertEquals(3, robot.getPosY());
        assertEquals(Orientation.NORTH, robot.getOrientation());

    }

    @Test
    public void robotSuccessfullyMovesWest() {
        // Setup
        Robot robot = new Robot();
        PlaceCommand pc = new PlaceCommand(4, 2, "WEST");
        pc.execute(robot);

        // Precondition
        assertTrue(robot.getOnTable());
        assertEquals(4, robot.getPosX());
        assertEquals(2, robot.getPosY());
        assertEquals(Orientation.WEST, robot.getOrientation());

        // Test function
        MoveCommand mc = new MoveCommand();
        mc.execute(robot);

        // Post-condition
        assertTrue(robot.getOnTable());
        assertEquals(3, robot.getPosX());
        assertEquals(2, robot.getPosY());
        assertEquals(Orientation.WEST, robot.getOrientation());

    }

    @Test
    public void robotDoesNotFallOffTable() {
        // Setup
        Robot robot = new Robot();
        PlaceCommand pc = new PlaceCommand(4, 2, "EAST");
        pc.execute(robot);

        // Precondition
        assertTrue(robot.getOnTable());
        assertEquals(4, robot.getPosX());
        assertEquals(2, robot.getPosY());
        assertEquals(Orientation.EAST, robot.getOrientation());

        // Test function
        MoveCommand mc = new MoveCommand();
        mc.execute(robot);

        // Post-condition
        assertTrue(robot.getOnTable());
        assertEquals(4, robot.getPosX());
        assertEquals(2, robot.getPosY());
        assertEquals(Orientation.EAST, robot.getOrientation());
    }

    @Test
    public void robotCanTurnLeft() {
        // Setup
        Robot robot = new Robot();
        PlaceCommand pc = new PlaceCommand(4, 2, "EAST");
        pc.execute(robot);

        // Precondition
        assertTrue(robot.getOnTable());
        assertEquals(4, robot.getPosX());
        assertEquals(2, robot.getPosY());
        assertEquals(Orientation.EAST, robot.getOrientation());

        // Test function
        LeftCommand lc = new LeftCommand();
        lc.execute(robot);

        // Post-condition
        assertTrue(robot.getOnTable());
        assertEquals(4, robot.getPosX());
        assertEquals(2, robot.getPosY());
        assertEquals(Orientation.NORTH, robot.getOrientation());


    }

    @Test
    public void robotCanTurn180() {
        // Setup
        Robot robot = new Robot();
        PlaceCommand pc = new PlaceCommand(4, 2, "EAST");
        pc.execute(robot);

        // Precondition
        assertTrue(robot.getOnTable());
        assertEquals(4, robot.getPosX());
        assertEquals(2, robot.getPosY());
        assertEquals(Orientation.EAST, robot.getOrientation());

        // Test function
        RightCommand rc = new RightCommand();
        rc.execute(robot);
        rc.execute(robot);

        // Post-condition
        assertTrue(robot.getOnTable());
        assertEquals(4, robot.getPosX());
        assertEquals(2, robot.getPosY());
        assertEquals(Orientation.WEST, robot.getOrientation());
    }
}
