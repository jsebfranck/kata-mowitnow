package com.jsebfranck.mowitnow.battery;

import com.jsebfranck.mowitnow.mower.Ground;
import com.jsebfranck.mowitnow.mower.Position;
import com.jsebfranck.mowitnow.mower.movement.Movement;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.jsebfranck.mowitnow.mower.Orientation.EAST;
import static com.jsebfranck.mowitnow.mower.Orientation.NORTH;
import static com.jsebfranck.mowitnow.mower.movement.Movement.*;
import static org.junit.Assert.assertEquals;

/**
 * @see MowerBattery
 * @author jsebfranck
 */
public class MowerBatteryTest {

    private MowerBattery mowerBattery;

    @Before
    public void setUp() {
        mowerBattery = new MowerBattery();
    }

    @Test
    public void moveAll() {
        // Given
        Ground ground = new Ground(5, 5);

        Position positionMower1 = new Position(1, 2, NORTH);
        List<Movement> movementsMower1 = Arrays.asList(TURN_LEFT, ADVANCE, TURN_LEFT, ADVANCE, TURN_LEFT, ADVANCE, TURN_LEFT, ADVANCE, ADVANCE);

        Position positionMower2 = new Position(3, 3, EAST);
        List<Movement> movementsMower2 = Arrays.asList(ADVANCE, ADVANCE, TURN_RIGHT, ADVANCE, ADVANCE, TURN_RIGHT, ADVANCE, TURN_RIGHT, TURN_RIGHT, ADVANCE);

        MowerBatteryInput input = new MowerBatteryInput(ground, Arrays.asList(positionMower1, positionMower2), Arrays.asList(movementsMower1, movementsMower2));

        // When
        MowerBatteryOutput output = mowerBattery.moveAll(input);

        // Then
        assertEquals(2, output.getPositions().size());
        assertThatPositionIs(new Position(1, 3, NORTH), output.getPositions().get(0));
        assertThatPositionIs(new Position(5, 1, EAST), output.getPositions().get(1));
    }

    private void assertThatPositionIs(Position expectedPosition, Position position) {
        assertEquals(expectedPosition.getOrientation(), position.getOrientation());
        assertEquals(expectedPosition.getX(), position.getX());
        assertEquals(expectedPosition.getY(), position.getY());
    }
}
