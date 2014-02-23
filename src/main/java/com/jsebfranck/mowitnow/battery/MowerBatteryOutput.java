package com.jsebfranck.mowitnow.battery;

import com.jsebfranck.mowitnow.mower.position.Position;

import java.util.List;

/**
 * Result of a mower battery for all the mowers.
 * @author jsebfranck
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
