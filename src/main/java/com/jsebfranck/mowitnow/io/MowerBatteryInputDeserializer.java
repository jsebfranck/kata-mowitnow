package com.jsebfranck.mowitnow.io;

import com.jsebfranck.mowitnow.battery.MowerBatteryEntry;
import com.jsebfranck.mowitnow.battery.MowerBatteryInput;
import com.jsebfranck.mowitnow.mower.Ground;
import com.jsebfranck.mowitnow.mower.Orientation;
import com.jsebfranck.mowitnow.mower.Position;
import com.jsebfranck.mowitnow.mower.movement.Movement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Deserialize mower battery lines in mower battery input.
 * @author jsebfranck
 */
class MowerBatteryInputDeserializer {

    MowerBatteryInput deserialize(List<String> mowerBatteryLines) {
        Iterator<String> iterator = mowerBatteryLines.iterator();

        // First line is the ground
        Ground ground = getGround(iterator.next());

        // Next lines are mower positions and movements
        List<MowerBatteryEntry> entries = new ArrayList<MowerBatteryEntry>();
        while (iterator.hasNext()) {
            Position position = getPosition(iterator.next());
            List<Movement> movements = getMovements(iterator.next());
            entries.add(new MowerBatteryEntry(position, movements));
        }

        return new MowerBatteryInput(ground, entries);
    }

    private Ground getGround(String groundLine) {
        Pattern pattern = Pattern.compile("(\\d)\\s(\\d)");
        Matcher matcher = pattern.matcher(groundLine);
        matcher.find();

        int width = Integer.valueOf(matcher.group(1));
        int height = Integer.valueOf(matcher.group(2));
        return new Ground(width, height);
    }

    private Position getPosition(String positionLine) {
        Pattern pattern = Pattern.compile("(\\d)\\s(\\d)\\s(\\p{Upper})");
        Matcher matcher = pattern.matcher(positionLine);
        matcher.find();

        int x = Integer.valueOf(matcher.group(1));
        int y = Integer.valueOf(matcher.group(2));
        Orientation orientation = getOrientationFromLabel(matcher.group(3));

        return new Position(x, y, orientation);
    }

    private Orientation getOrientationFromLabel(String label) {
        switch (label) {
            case "N":
                return Orientation.NORTH;
            case "S":
                return Orientation.SOUTH;
            case "W":
                return Orientation.WEST;
            case "E":
                return Orientation.EAST;
        }
        return null;
    }

    private List<Movement> getMovements(String movementsLine) {
        List<Movement> movements = new ArrayList<Movement>();

        for (int i = 0 ; i < movementsLine.length() ; i++) {
            char label = movementsLine.charAt(i);
            movements.add(getMovementFromLabel(label));
        }
        return movements;
    }

    private Movement getMovementFromLabel(char label) {
        switch (label) {
            case 'G':
                return Movement.TURN_LEFT;
            case 'D':
                return Movement.TURN_RIGHT;
            case 'A':
                return Movement.ADVANCE;
        }
        return null;
    }
}
