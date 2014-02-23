package com.jsebfranck.mowitnow.mower;

import com.jsebfranck.mowitnow.mower.ground.Ground;
import com.jsebfranck.mowitnow.mower.movement.Movement;
import com.jsebfranck.mowitnow.mower.position.Orientation;
import com.jsebfranck.mowitnow.mower.position.Position;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static com.jsebfranck.mowitnow.mower.position.Orientation.*;
import static com.jsebfranck.mowitnow.mower.movement.Movement.*;

/**
 * @see AutomaticMower
 * @author jsebfranck
 */
@RunWith(Parameterized.class)
public class AutomaticMowerTest {

    private AutomaticMower automaticMower;

    @Before
    public void setUp() {
        automaticMower = new AutomaticMower();
    }

    private final Ground ground;
    private final Position position;
    private final List<Movement> movements;
    private final int expectedX;
    private final int expectedY;
    private final Orientation expectedOrientation;

    public AutomaticMowerTest(String testDescription, Ground ground, Position position, List<Movement> movements, int expectedX, int expectedY, Orientation expectedOrientation) {
        this.ground = ground;
        this.position = position;
        this.movements = movements;
        this.expectedX = expectedX;
        this.expectedY = expectedY;
        this.expectedOrientation = expectedOrientation;
    }

    @Parameters(name = "{0}")
    public static Collection parameters() {
        return Arrays.asList(new Object[][] {

                { "without movements, should not move",
                        new Ground(10, 10), new Position(0, 0, NORTH), Collections.emptyList(),
                        0, 0, NORTH },

                /************ Advance tests *************/

                { "with advance movement on north direction, should advance to north",
                        new Ground(10, 10), new Position(5, 5, NORTH), Arrays.asList(ADVANCE),
                        5, 6, NORTH },

                { "with advance movement on south direction, should advance to south",
                        new Ground(10, 10), new Position(5, 5, SOUTH), Arrays.asList(ADVANCE),
                        5, 4, SOUTH },

                { "with advance movement on west direction, should advance to west",
                        new Ground(10, 10), new Position(5, 5, WEST), Arrays.asList(ADVANCE),
                        4, 5, WEST },

                { "with advance movement on east direction, should advance to east",
                        new Ground(10, 10), new Position(5, 5, EAST), Arrays.asList(ADVANCE),
                        6, 5, EAST },

                /************ Turn to left tests *****************/

                { "with left movement on north direction, should turn to be on west direction",
                        new Ground(10, 10), new Position(0, 0, NORTH), Arrays.asList(TURN_LEFT),
                        0, 0, WEST },

                { "with left movement on south direction, should turn to be on east direction",
                        new Ground(10, 10), new Position(0, 0, SOUTH), Arrays.asList(TURN_LEFT),
                        0, 0, EAST },

                { "with left movement on west direction, should turn to be on west direction",
                        new Ground(10, 10), new Position(0, 0, WEST), Arrays.asList(TURN_LEFT),
                        0, 0, SOUTH },

                { "with left movement on east direction, should turn to be on west direction",
                        new Ground(10, 10), new Position(0, 0, EAST), Arrays.asList(TURN_LEFT),
                        0, 0, NORTH },

                /************ Turn to right tests *****************/

                { "with right movement on north direction, should turn to be on east direction",
                        new Ground(10, 10), new Position(0, 0, NORTH), Arrays.asList(TURN_RIGHT),
                        0, 0, EAST },

                { "with right movement on south direction, should turn to be on west direction",
                        new Ground(10, 10), new Position(0, 0, SOUTH), Arrays.asList(TURN_RIGHT),
                        0, 0, WEST },

                { "with right movement on west direction, should turn to be on north direction",
                        new Ground(10, 10), new Position(0, 0, WEST), Arrays.asList(TURN_RIGHT),
                        0, 0, NORTH },

                { "with right movement on east direction, should turn to be on south direction",
                        new Ground(10, 10), new Position(0, 0, EAST), Arrays.asList(TURN_RIGHT),
                        0, 0, SOUTH },

                /************ Ground limits tests *************/

                { "with advance movement on north direction and north border, should not move",
                        new Ground(10, 10), new Position(5, 10, NORTH), Arrays.asList(ADVANCE),
                        5, 10, NORTH },

                { "with advance movement on south direction and south border, should not move",
                        new Ground(10, 10), new Position(5, 0, SOUTH), Arrays.asList(ADVANCE),
                        5, 0, SOUTH },

                { "with advance movement on west direction and west border, should not move",
                        new Ground(10, 10), new Position(0, 5, WEST), Arrays.asList(ADVANCE),
                        0, 5, WEST },

                { "with advance movement on east direction and east border, should not move",
                        new Ground(10, 10), new Position(10, 5, EAST), Arrays.asList(ADVANCE),
                        10, 5, EAST },

                /************ Several movements tests *************/

                { "with several movements, should move several times",
                        new Ground(5, 5), new Position(1, 2, NORTH),
                        Arrays.asList(TURN_LEFT, ADVANCE, TURN_LEFT, ADVANCE, TURN_LEFT, ADVANCE, TURN_LEFT, ADVANCE, ADVANCE),
                        1, 3, NORTH },

                { "with several different movements, should still move several times",
                        new Ground(5, 5), new Position(3, 3, EAST),
                        Arrays.asList(ADVANCE, ADVANCE, TURN_RIGHT, ADVANCE, ADVANCE, TURN_RIGHT, ADVANCE, TURN_RIGHT, TURN_RIGHT, ADVANCE),
                        5, 1, EAST },

                /************ Weird cases tests *************/

                { "with mower out of the ground, should quickly join the ground after three moves",
                        new Ground(5, 5), new Position(10, 10, NORTH),
                        Arrays.asList(ADVANCE, TURN_RIGHT, ADVANCE),
                        5, 5, EAST }
        });
    }

    @Test
    public void moveMower() {
        // Given a ground with a mower, and several movements to do

        // When we move the mower
        automaticMower.move(ground, position, movements);

        // Then we check the mower position
        assertEquals("The mower is not at the expected x position", expectedX, position.getX());
        assertEquals("The mower is not at the expected y position", expectedY, position.getY());
        assertEquals("The mower is not oriented as expected", expectedOrientation, position.getOrientation());
    }
}
