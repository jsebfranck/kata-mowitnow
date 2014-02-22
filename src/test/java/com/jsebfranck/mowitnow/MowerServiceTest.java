package com.jsebfranck.mowitnow;

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
import static com.jsebfranck.mowitnow.Orientation.*;
import static com.jsebfranck.mowitnow.MowerControl.*;

/**
 * @see com.jsebfranck.mowitnow.MowerService
 * @author jsebfranck
 */
@RunWith(Parameterized.class)
public class MowerServiceTest {

    private MowerService mowerService;

    @Before
    public void setUp() {
        mowerService = new MowerService();
    }

    private final Ground ground;
    private final Mower mower;
    private final List<MowerControl> mowerControls;
    private final int expectedX;
    private final int expectedY;
    private final Orientation expectedOrientation;

    public MowerServiceTest(String testDescription, Ground ground, Mower mower, List<MowerControl> mowerControls, int expectedX, int expectedY, Orientation expectedOrientation) {
        this.ground = ground;
        this.mower = mower;
        this.mowerControls = mowerControls;
        this.expectedX = expectedX;
        this.expectedY = expectedY;
        this.expectedOrientation = expectedOrientation;
    }

    @Parameters(name = "{0}")
    public static Collection parameters() {
        return Arrays.asList(new Object[][] {

                { "without controls, should not move",
                        new Ground(10, 10), new Mower(0, 0, NORTH), Collections.emptyList(),
                        0, 0, NORTH },

                /************ Advance tests *************/

                { "with advance control on north direction, should advance to north",
                        new Ground(10, 10), new Mower(5, 5, NORTH), Arrays.asList(ADVANCE),
                        5, 6, NORTH },

                { "with advance control on south direction, should advance to south",
                        new Ground(10, 10), new Mower(5, 5, SOUTH), Arrays.asList(ADVANCE),
                        5, 4, SOUTH },

                { "with advance control on west direction, should advance to west",
                        new Ground(10, 10), new Mower(5, 5, WEST), Arrays.asList(ADVANCE),
                        4, 5, WEST },

                { "with advance control on east direction, should advance to east",
                        new Ground(10, 10), new Mower(5, 5, EAST), Arrays.asList(ADVANCE),
                        6, 5, EAST },

                /************ Turn to left tests *****************/

                { "with left control on north direction, should turn to be on west direction",
                        new Ground(10, 10), new Mower(0, 0, NORTH), Arrays.asList(TURN_LEFT),
                        0, 0, WEST },

                { "with left control on south direction, should turn to be on east direction",
                        new Ground(10, 10), new Mower(0, 0, SOUTH), Arrays.asList(TURN_LEFT),
                        0, 0, EAST },

                { "with left control on west direction, should turn to be on west direction",
                        new Ground(10, 10), new Mower(0, 0, WEST), Arrays.asList(TURN_LEFT),
                        0, 0, SOUTH },

                { "with left control on east direction, should turn to be on west direction",
                        new Ground(10, 10), new Mower(0, 0, EAST), Arrays.asList(TURN_LEFT),
                        0, 0, NORTH },

                /************ Turn to right tests *****************/

                { "with right control on north direction, should turn to be on east direction",
                        new Ground(10, 10), new Mower(0, 0, NORTH), Arrays.asList(TURN_RIGHT),
                        0, 0, EAST },

                { "with right control on south direction, should turn to be on west direction",
                        new Ground(10, 10), new Mower(0, 0, SOUTH), Arrays.asList(TURN_RIGHT),
                        0, 0, WEST },

                { "with right control on west direction, should turn to be on north direction",
                        new Ground(10, 10), new Mower(0, 0, WEST), Arrays.asList(TURN_RIGHT),
                        0, 0, NORTH },

                { "with right control on east direction, should turn to be on south direction",
                        new Ground(10, 10), new Mower(0, 0, EAST), Arrays.asList(TURN_RIGHT),
                        0, 0, SOUTH },

                /************ Ground limits tests *************/

                { "with advance control on north direction and north border, should not move",
                        new Ground(10, 10), new Mower(5, 10, NORTH), Arrays.asList(ADVANCE),
                        5, 10, NORTH },

                { "with advance control on south direction and south border, should not move",
                        new Ground(10, 10), new Mower(5, 0, SOUTH), Arrays.asList(ADVANCE),
                        5, 0, SOUTH },

                { "with advance control on west direction and west border, should not move",
                        new Ground(10, 10), new Mower(0, 5, WEST), Arrays.asList(ADVANCE),
                        0, 5, WEST },

                { "with advance control on east direction and east border, should not move",
                        new Ground(10, 10), new Mower(10, 5, EAST), Arrays.asList(ADVANCE),
                        10, 5, EAST },

                /************ Several movements tests *************/

                { "with several movements, should move several times",
                        new Ground(5, 5), new Mower(1, 2, NORTH),
                        Arrays.asList(TURN_LEFT, ADVANCE, TURN_LEFT, ADVANCE, TURN_LEFT, ADVANCE, TURN_LEFT, ADVANCE, ADVANCE),
                        1, 3, NORTH }
        });
    }

    @Test
    public void moveMower() {
        // Given a ground with a mower, and several movements to do

        // When we move the mower
        mowerService.moveMower(ground, mower, mowerControls);

        // Then we check the mower position
        assertEquals("The mower is not at the expected x position", expectedX, mower.getX());
        assertEquals("The mower is not at the expected y position", expectedY, mower.getY());
        assertEquals("The mower is not oriented as expected", expectedOrientation, mower.getOrientation());
    }
}
