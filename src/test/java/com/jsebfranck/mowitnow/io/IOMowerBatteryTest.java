package com.jsebfranck.mowitnow.io;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author jsebfranck
 * @see IOMowerBattery
 */
public class IOMowerBatteryTest {

    private IOMowerBattery mowerBattery;

    @Before
    public void setUp() {
        mowerBattery = new IOMowerBattery();
    }

    @Test(expected = IOMowerBatteryInputException.class)
    public void moveAll_withEmptyLines_shouldThrowsException() throws IOMowerBatteryInputException {
        // Given
        List<String> mowerBatteryLines = Collections.emptyList();

        // When
        mowerBattery.moveAll(mowerBatteryLines);
    }

    @Test(expected = IOMowerBatteryInputException.class)
    public void moveAll_withInvalidGround_shouldThrowsException() throws IOMowerBatteryInputException {
        // Given
        List<String> mowerBatteryLines = Arrays.asList(
                "5 W"
        );

        // When
        mowerBattery.moveAll(mowerBatteryLines);
    }

    @Test(expected = IOMowerBatteryInputException.class)
    public void moveAll_withInvalidPosition_shouldThrowsException() throws IOMowerBatteryInputException {
        // Given
        List<String> mowerBatteryLines = Arrays.asList(
                "5 5",
                "1 2 3"
        );

        // When
        mowerBattery.moveAll(mowerBatteryLines);
    }

    @Test(expected = IOMowerBatteryInputException.class)
    public void moveAll_withUnknownPosition_shouldThrowsException() throws IOMowerBatteryInputException {
        // Given
        List<String> mowerBatteryLines = Arrays.asList(
                "5 5",
                "1 2 C"
        );

        // When
        mowerBattery.moveAll(mowerBatteryLines);
    }

    @Test(expected = IOMowerBatteryInputException.class)
    public void moveAll_withUnknownMovement_shouldThrowsException() throws IOMowerBatteryInputException {
        // Given
        List<String> mowerBatteryLines = Arrays.asList(
                "5 5",
                "1 2 N",
                "AGDCAG"
        );

        // When
        mowerBattery.moveAll(mowerBatteryLines);
    }

    @Test(expected = IOMowerBatteryInputException.class)
    public void moveAll_withPositionWithoutMovement_shouldThrowsException() throws IOMowerBatteryInputException {
        // Given
        List<String> mowerBatteryLines = Arrays.asList(
                "5 5",
                "1 2 N",
                "AGDAG",
                "1 5 E"
        );

        // When
        mowerBattery.moveAll(mowerBatteryLines);
    }

    @Test
    public void moveAll_withTwoMowers_shouldMoveBothMowers() throws IOMowerBatteryInputException {
        // Given
        List<String> mowerBatteryLines = Arrays.asList(
                "5 5",
                "1 2 N",
                "GAGAGAGAA",
                "3 3 E",
                "AADAADADDA"
        );

        // When
        List<String> result = mowerBattery.moveAll(mowerBatteryLines);

        // Then
        assertEquals("We should have two mover positions", 2, result.size());
        assertEquals("First mower position is incorrect", "1 3 N", result.get(0));
        assertEquals("Second mower position is incorrect", "5 1 E", result.get(1));
    }

    @Test
    public void moveAll_withFourMowers_shouldMoveAllMowers() throws IOMowerBatteryInputException {
        // Given
        List<String> mowerBatteryLines = Arrays.asList(
                "2 2",
                "0 0 E",
                "A",
                "1 0 N",
                "A",
                "1 1 W",
                "A",
                "0 1 S",
                "A"
        );

        // When
        List<String> result = mowerBattery.moveAll(mowerBatteryLines);

        // Then
        assertEquals("We should have four mover positions", 4, result.size());
        assertEquals("First mower position is incorrect", "1 0 E", result.get(0));
        assertEquals("Second mower position is incorrect", "1 1 N", result.get(1));
        assertEquals("Third mower position is incorrect", "0 1 W", result.get(2));
        assertEquals("Fourth mower position is incorrect", "0 0 S", result.get(3));
    }
}
