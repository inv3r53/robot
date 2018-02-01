package com.launch.robot;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RobotApplicationTest {

    private static final String PLACE_COMMAND="PLACE %d,%d,%s";
    private static final String MOVE_COMMAND="MOVE";
    private static final String TURN_LEFT_COMMAND="LEFT";
    private static final String TURN_RIGHT_COMMAND="RIGHT";

    @Test
    public void testPlacementResponse() {
        Robot robot = new Robot();
        RobotApplication app = new RobotApplication(robot);
        app.executeCommand(place(5,5,Direction.EAST));
        assertEquals(robot.isInvalidState(), true);
        app.executeCommand(place(-1,-1,Direction.WEST));
        assertEquals(robot.isInvalidState(), true);
        app.executeCommand(MOVE_COMMAND);
        assertEquals(robot.isInvalidState(), true);
        app.executeCommand(TURN_LEFT_COMMAND);
        assertEquals(robot.isInvalidState(), true);
        app.executeCommand(TURN_RIGHT_COMMAND);
        assertEquals(robot.isInvalidState(), true);
        app.executeCommand(place(1,1,Direction.WEST));
        assertEquals(robot.isInvalidState(), false);
        app.executeCommand(place(5,5,Direction.WEST));
        assertEquals(robot.isInvalidState(), true);
    }

    @Test
    public void testMoveResponse() {
        Robot robot = new Robot();
        RobotApplication app = new RobotApplication(robot);
        app.executeCommand(place(1,1,Direction.EAST));
        assertEquals(robot.isInvalidState(), false);
        app.executeCommand(MOVE_COMMAND);
        assertEquals(robot.getX(),2);
        assertEquals(robot.getY(),1);
        app.executeCommand(MOVE_COMMAND);
        app.executeCommand(MOVE_COMMAND);
        assertEquals(robot.getX(),4);
        assertEquals(robot.getY(),1);
        app.executeCommand(MOVE_COMMAND);
        app.executeCommand(MOVE_COMMAND);
        assertEquals(robot.getX(),4);
        assertEquals(robot.getY(),1);
    }

    @Test
    public void testMoveNearEdge() {
        Robot robot = new Robot();
        RobotApplication app = new RobotApplication(robot);
        app.executeCommand(place(4,4,Direction.EAST));
        assertEquals(robot.isInvalidState(), false);
        app.executeCommand(MOVE_COMMAND);
        assertEquals(robot.getX(),4);
        assertEquals(robot.getY(),4);
        robot.turnLeft();
        app.executeCommand(MOVE_COMMAND);
        assertEquals(robot.getX(),4);
        assertEquals(robot.getY(),4);
        robot.turnLeft();
        app.executeCommand(MOVE_COMMAND);
        assertEquals(robot.getX(),3);
        assertEquals(robot.getY(),4);
    }


    private String place(int x, int y , Direction d){
        return String.format(PLACE_COMMAND,x,y,d);
    }

}
