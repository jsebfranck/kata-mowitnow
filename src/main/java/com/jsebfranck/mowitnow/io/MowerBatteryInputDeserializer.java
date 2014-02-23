package com.jsebfranck.mowitnow.io;

import com.jsebfranck.mowitnow.battery.MowerBatteryEntry;
import com.jsebfranck.mowitnow.battery.MowerBatteryInput;
import com.jsebfranck.mowitnow.mower.Ground;
import com.jsebfranck.mowitnow.mower.Position;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Deserialize mower battery lines in mower battery input.
 * @author jsebfranck
 */
class MowerBatteryInputDeserializer {

    private final GroundDeserializer groundDeserializer = new GroundDeserializer();
    private final PositionDeserializer positionDeserializer = new PositionDeserializer();
    private final MovementDeserializer movementDeserializer = new MovementDeserializer();

    MowerBatteryInput deserialize(List<String> mowerBatteryLines) throws IOMowerBatteryException {
        Iterator<String> iterator = mowerBatteryLines.iterator();

        if (! iterator.hasNext()) {
            throw new IOMowerBatteryException("Lines cannot be empty");
        }

        // First line is the ground
        Ground ground = groundDeserializer.deserialize(iterator.next());

        // Next lines are mower positions and movements
        List<MowerBatteryEntry> entries = new ArrayList<>();
        while (iterator.hasNext()) {
            Position position = positionDeserializer.deserialize(iterator.next());
            if (! iterator.hasNext()) {
                throw new IOMowerBatteryException("A mower has no position");
            }
            entries.add(new MowerBatteryEntry(position, movementDeserializer.deserialize(iterator.next())));
        }

        return new MowerBatteryInput(ground, entries);
    }
}
