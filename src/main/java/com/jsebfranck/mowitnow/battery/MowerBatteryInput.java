package com.jsebfranck.mowitnow.battery;


import com.jsebfranck.mowitnow.mower.Ground;
import com.jsebfranck.mowitnow.mower.Position;
import com.jsebfranck.mowitnow.mower.movement.Movement;

import java.util.List;

/**
 * Contains all parameters needed for a mower battery.
 * @author jsebfranck
 */
public class MowerBatteryInput {

    private final Ground ground;
    private final List<Position> positions;
    private final List<List<Movement>> movements;

    public MowerBatteryInput(Ground ground, List<Position> positions, List<List<Movement>> movements) {
        this.ground = ground;
        this.positions = positions;
        this.movements = movements;
    }

    public Ground getGround() {
        return ground;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public List<List<Movement>> getMovements() {
        return movements;
    }
}
