package com.jsebfranck.mowitnow.battery;

import com.jsebfranck.mowitnow.mower.AutomaticMower;
import com.jsebfranck.mowitnow.mower.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * Allow to move several mowers on a ground.
 * @author jsebfranck
 */
public class MowerBattery {

    public MowerBatteryOutput moveAll(MowerBatteryInput input) {
        List<Position> finalPositions = new ArrayList<>();

        for (MowerBatteryEntry entry : input.getEntries()) {
            AutomaticMower automaticMower = new AutomaticMower();
            automaticMower.move(input.getGround(), entry.getPosition(), entry.getMovements());
            finalPositions.add(entry.getPosition());
        }

        return new MowerBatteryOutput(finalPositions);
    }
}
