package com.jsebfranck.mowitnow.io;

import com.jsebfranck.mowitnow.mower.Orientation;
import com.jsebfranck.mowitnow.mower.Position;

import java.util.List;

/**
 * Allow to deserialize a mower position.
 * @author jsebfranck
 */
class PositionDeserializer {

    Position deserialize(String positionLine) throws IOMowerBatteryInputException {
        List<String> positionParameters = RegexUtils.findByPattern(positionLine, "(\\d)\\s(\\d)\\s(\\p{Upper})", "Invalid position provided " + positionLine);
        int x = Integer.valueOf(positionParameters.get(0));
        int y = Integer.valueOf(positionParameters.get(1));
        Orientation orientation = getOrientationFromLabel(positionParameters.get(2));

        return new Position(x, y, orientation);
    }

    private Orientation getOrientationFromLabel(String label) throws IOMowerBatteryInputException {
        switch (label) {
            case "N":
                return Orientation.NORTH;
            case "S":
                return Orientation.SOUTH;
            case "W":
                return Orientation.WEST;
            case "E":
                return Orientation.EAST;
            default:
                throw new IOMowerBatteryInputException("Unknown position provided " + label);
        }
    }
}
