package com.jsebfranck.mowitnow.io;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
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

    @Test
    public void moveAll() {
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
}
