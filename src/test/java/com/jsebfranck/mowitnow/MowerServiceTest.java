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
        assertEquals(0, mower.getX());
        assertEquals(0, mower.getY());
        assertEquals(Orientation.NORTH, mower.getOrientation());
    }


    @Test
    public void moveMower_withLeftControl_shouldTurnToLeft() {
        // Given
        Ground ground = new Ground(10, 10);
        Mower mower = new Mower(0, 0, Orientation.NORTH);

        // When
        mowerService.moveMower(ground, mower, Arrays.asList(MowerControl.TURN_LEFT));

        // Then
        assertEquals(0, mower.getX());
        assertEquals(0, mower.getY());
        assertEquals(Orientation.WEST, mower.getOrientation());
    }
}
