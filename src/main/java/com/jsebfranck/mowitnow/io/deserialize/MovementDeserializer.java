package com.jsebfranck.mowitnow.io.deserialize;

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
            movements.add(deserializeMovement(label));
        }
        return movements;
    }

    private Movement deserializeMovement(char label) throws IOMowerBatteryInputException {
        switch (label) {
            case 'G':
                return Movement.TURN_LEFT;
            case 'D':
                return Movement.TURN_RIGHT;
            case 'A':
                return Movement.ADVANCE;
            default:
                throw new IOMowerBatteryInputException("Unknown movement provided " + label);
        }
    }
}
