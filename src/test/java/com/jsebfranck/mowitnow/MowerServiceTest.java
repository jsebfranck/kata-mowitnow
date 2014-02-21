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

                { "with left control, should turn to left",
                        new Ground(10, 10), new Mower(0, 0, NORTH), Arrays.asList(TURN_LEFT),
                        0, 0, WEST },

                { "with right control, should turn to right",
                        new Ground(10, 10), new Mower(0, 0, NORTH), Arrays.asList(TURN_RIGHT),
                        0, 0, EAST },

                { "with advance control, should advance",
                        new Ground(10, 10), new Mower(0, 0, NORTH), Arrays.asList(ADVANCE),
                        0, 1, NORTH },
        });
    }

    @Test
    public void moveMower() {
        // When
        mowerService.moveMower(ground, mower, mowerControls);

        // Then
        assertThatMowerPositionIs(mower, expectedX, expectedY, expectedOrientation);
    }

    private void assertThatMowerPositionIs(Mower mower, int expectedX, int expectedY, Orientation expectedOrientation) {
        assertEquals(expectedX, mower.getX());
        assertEquals(expectedY, mower.getY());
        assertEquals(expectedOrientation, mower.getOrientation());
    }
}
