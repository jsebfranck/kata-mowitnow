package com.jsebfranck.mowitnow.battery;

import com.jsebfranck.mowitnow.mower.position.Position;
import com.jsebfranck.mowitnow.mower.movement.Movement;

import java.util.List;

/**
 * Represents a single mower to move within a battery.
 * @author jsebfranck
 */
public class MowerBatteryEntry {
    private final Position position;
    private final List<Movement> movements;

    public MowerBatteryEntry(Position position, List<Movement> movements) {
        this.position = position;
        this.movements = movements;
    }

    public Position getPosition() {
        return position;
    }

    public List<Movement> getMovements() {
        return movements;
    }
}
