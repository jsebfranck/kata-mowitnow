package com.jsebfranck.mowitnow.io;

import com.jsebfranck.mowitnow.mower.movement.Movement;

import java.util.ArrayList;
import java.util.List;

/**
 * Allow to deserialize the mower movements.
 */
class MovementDeserializer {

    List<Movement> deserialize(String movementsLine) throws IOMowerBatteryInputException {
        List<Movement> movements = new ArrayList<Movement>();

        for (int i = 0 ; i < movementsLine.length() ; i++) {
            char label = movementsLine.charAt(i);
            movements.add(getMovementFromLabel(label));
        }
        return movements;
    }

    private Movement getMovementFromLabel(char label) throws IOMowerBatteryInputException {
        switch (label) {
            case 'G':
                return Movement.TURN_LEFT;
            case 'D':
                return Movement.TURN_RIGHT;
            case 'A':
                return Movement.ADVANCE;
        }
        throw new IOMowerBatteryInputException("Unknown movement provided " + label);
    }
}
