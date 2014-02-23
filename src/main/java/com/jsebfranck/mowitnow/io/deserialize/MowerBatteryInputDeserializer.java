package com.jsebfranck.mowitnow.io.deserialize;

import com.jsebfranck.mowitnow.battery.input.MowerBatteryInput;
import com.jsebfranck.mowitnow.battery.input.MowerBatteryInputEntry;
import com.jsebfranck.mowitnow.mower.ground.Ground;
import com.jsebfranck.mowitnow.mower.position.Position;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Deserialize mower battery lines in mower battery input.
 * @author jsebfranck
 */
public class MowerBatteryInputDeserializer {

    private final GroundDeserializer groundDeserializer = new GroundDeserializer();
    private final PositionDeserializer positionDeserializer = new PositionDeserializer();
    private final MovementDeserializer movementDeserializer = new MovementDeserializer();

    public MowerBatteryInput deserialize(List<String> mowerBatteryLines) throws IOMowerBatteryInputException {
        Iterator<String> iterator = mowerBatteryLines.iterator();

        if (! iterator.hasNext()) {
            throw new IOMowerBatteryInputException("Lines cannot be empty");
        }

        // First line is the ground
        Ground ground = groundDeserializer.deserialize(iterator.next());

        // Next lines are mower positions and movements
        List<MowerBatteryInputEntry> entries = new ArrayList<>();
        while (iterator.hasNext()) {
            Position position = positionDeserializer.deserialize(iterator.next());
            if (! iterator.hasNext()) {
                throw new IOMowerBatteryInputException("A mower has no position");
            }
            entries.add(new MowerBatteryInputEntry(position, movementDeserializer.deserialize(iterator.next())));
        }

        return new MowerBatteryInput(ground, entries);
    }
}
