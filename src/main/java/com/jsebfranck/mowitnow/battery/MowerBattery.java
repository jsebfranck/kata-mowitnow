package com.jsebfranck.mowitnow.battery;

import com.jsebfranck.mowitnow.mower.AutomaticMower;
import com.jsebfranck.mowitnow.mower.Position;
import com.jsebfranck.mowitnow.mower.movement.Movement;

import java.util.ArrayList;
import java.util.List;

/**
 * Allow to move several mowers on a ground.
 * @author jsebfranck
 */
public class MowerBattery {

    public MowerBatteryOutput moveAll(MowerBatteryInput input) {

        List<Position> resultPositions = new ArrayList<>();

        for (int i = 0 ; i < input.getPositions().size() ; i++) {
            Position position = input.getPositions().get(i);
            List<Movement> movements = input.getMovements().get(i);

            AutomaticMower automaticMower = new AutomaticMower();
            automaticMower.move(input.getGround(), position, movements);

            resultPositions.add(position);
        }

        return new MowerBatteryOutput(resultPositions);
    }
}
