package com.jsebfranck.mowitnow;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * @see com.jsebfranck.mowitnow.MowerService
 * @author jsebfranck
 */
public class MowerServiceTest {

    private MowerService mowerService;

    @Before
    public void setUp() {
        mowerService = new MowerService();
    }

    @Test
    public void moveMower_withoutControl_shouldNotMove() {
        // Given
        Ground ground = new Ground(10, 10);
        Mower mower = new Mower(0, 0, Orientation.NORTH);

        // When
        mowerService.moveMower(ground, mower, Collections.<MowerControl>emptyList());

        // Then
        assertThatMowerPositionIs(mower, 0, 0, Orientation.NORTH);
    }

    @Test
    public void moveMower_withLeftControl_shouldTurnToLeft() {
        // Given
        Ground ground = new Ground(10, 10);
        Mower mower = new Mower(0, 0, Orientation.NORTH);

        // When
        mowerService.moveMower(ground, mower, Arrays.asList(MowerControl.TURN_LEFT));

        // Then
        assertThatMowerPositionIs(mower, 0, 0, Orientation.WEST);
    }

    @Test
    public void moveMower_withLeftControl_shouldTurnToRight() {
        // Given
        Ground ground = new Ground(10, 10);
        Mower mower = new Mower(0, 0, Orientation.NORTH);

        // When
        mowerService.moveMower(ground, mower, Arrays.asList(MowerControl.TURN_RIGHT));

        // Then
        assertThatMowerPositionIs(mower, 0, 0, Orientation.EAST);
    }

    @Test
    public void moveMower_withAdvanceControl_shouldAdvance() {
        // Given
        Ground ground = new Ground(10, 10);
        Mower mower = new Mower(0, 0, Orientation.NORTH);

        // When
        mowerService.moveMower(ground, mower, Arrays.asList(MowerControl.ADVANCE));

        // Then
        assertThatMowerPositionIs(mower, 0, 1, Orientation.NORTH);
    }

    private void assertThatMowerPositionIs(Mower mower, int expectedX, int expectedY, Orientation expectedOrientation) {
        assertEquals(expectedX, mower.getX());
        assertEquals(expectedY, mower.getY());
        assertEquals(expectedOrientation, mower.getOrientation());
    }
}
