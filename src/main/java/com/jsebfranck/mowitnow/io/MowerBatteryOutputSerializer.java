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

    List<String> serialize(MowerBatteryOutput mowerBatteryOutput) {
        List<String> result = new ArrayList<String>();

        for (Position position : mowerBatteryOutput.getPositions()) {
            result.add(position.getX() + " " + position.getY() + " " + position.getOrientation().toString().charAt(0));
        }

        return result;
    }
}
