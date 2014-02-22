package com.jsebfranck.mowitnow.battery;

import com.jsebfranck.mowitnow.mower.Position;

import java.util.List;

/**
 * Result of a mower battery.
 */
public class MowerBatteryOutput {

    private final List<Position> positions;

    public MowerBatteryOutput(List<Position> positions) {
        this.positions = positions;
    }

    public List<Position> getPositions() {
        return positions;
    }
}
