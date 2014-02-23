package com.jsebfranck.mowitnow.io.serialize;

import com.jsebfranck.mowitnow.battery.output.MowerBatteryOutput;
import com.jsebfranck.mowitnow.mower.position.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Serialize a mower battery output.
 * @author jsebfranck
 */
public class MowerBatteryOutputSerializer {

    private final PositionSerializer positionSerializer = new PositionSerializer();

    public List<String> serialize(MowerBatteryOutput mowerBatteryOutput) {
        List<String> finalPositions = new ArrayList<String>();
        for (Position position : mowerBatteryOutput.getPositions()) {
            finalPositions.add(positionSerializer.serialize(position));
        }
        return finalPositions;
    }
}
