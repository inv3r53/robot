package com.launch.robot;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectionTest {

    @Test
    public void begin_east_direction_transition_next_states(){
        Direction currentDirection = Direction.EAST;
        assertEquals( currentDirection.left(),Direction.NORTH);
        assertEquals( currentDirection.right(),Direction.SOUTH);
        assertEquals(currentDirection.getX(),1);
        assertEquals(currentDirection.getY(),0);
    }

    @Test
    public void begin_west_direction_transition_next_states(){
        Direction currentDirection = Direction.WEST;
        assertEquals( currentDirection.left(),Direction.SOUTH);
        assertEquals( currentDirection.right(),Direction.NORTH);
        assertEquals(currentDirection.getX(),-1);
        assertEquals(currentDirection.getY(),0);
    }

    @Test
    public void begin_north_direction_transition_next_states(){
        Direction currentDirection = Direction.NORTH;
        assertEquals( currentDirection.left(),Direction.WEST);
        assertEquals( currentDirection.right(),Direction.EAST);
        assertEquals(currentDirection.getX(),0);
        assertEquals(currentDirection.getY(),1);
    }

    @Test
    public void begin_south_direction_transition_next_states(){
        Direction currentDirection = Direction.SOUTH;
        assertEquals( currentDirection.left(),Direction.EAST);
        assertEquals( currentDirection.right(),Direction.WEST);
        assertEquals(currentDirection.getX(),0);
        assertEquals(currentDirection.getY(),-1);
    }
}
