package com.jsebfranck.mowitnow.io;

import com.jsebfranck.mowitnow.battery.MowerBatteryOutput;
import com.jsebfranck.mowitnow.mower.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Serialize a mower battery output.
 * @author jsebfranck
 */
class MowerBatteryOutputSerializer {

    private final PositionSerializer positionSerializer = new PositionSerializer();

    List<String> serialize(MowerBatteryOutput mowerBatteryOutput) {
        List<String> finalPositions = new ArrayList<String>();
        for (Position position : mowerBatteryOutput.getPositions()) {
            finalPositions.add(positionSerializer.serialize(position));
        }
        return finalPositions;
    }
}
