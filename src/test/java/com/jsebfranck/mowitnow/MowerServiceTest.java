package com.jsebfranck.mowitnow;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

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

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][] {
                // without controls, should not move
                { new Ground(10, 10), new Mower(0, 0, Orientation.NORTH), 0, 0, Orientation.NORTH, ctrl()},

                // with left control, should turn to left
                { new Ground(10, 10), new Mower(0, 0, Orientation.NORTH), 0, 0, Orientation.WEST, ctrl(MowerControl.TURN_LEFT)},

                // with right control, should turn to right
                { new Ground(10, 10), new Mower(0, 0, Orientation.NORTH), 0, 0, Orientation.EAST, ctrl(MowerControl.TURN_RIGHT)},

                // with advance control, should advance
                { new Ground(10, 10), new Mower(0, 0, Orientation.NORTH), 0, 1, Orientation.NORTH, ctrl(MowerControl.ADVANCE)},
        });
    }

    public static List<MowerControl> ctrl(MowerControl... mowerControls) {
        return (mowerControls == null) ? Collections.<MowerControl>emptyList() : Arrays.asList(mowerControls);
    }

    public MowerServiceTest(Ground ground, Mower mower, int expectedX, int expectedY, Orientation expectedOrientation, List<MowerControl> mowerControls) {
        this.ground = ground;
        this.mower = mower;
        this.expectedX = expectedX;
        this.expectedY = expectedY;
        this.expectedOrientation = expectedOrientation;
        this.mowerControls = mowerControls;
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
