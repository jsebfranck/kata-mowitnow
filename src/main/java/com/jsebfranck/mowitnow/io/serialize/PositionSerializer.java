package com.jsebfranck.mowitnow.io.serialize;

import com.jsebfranck.mowitnow.mower.position.Position;

/**
 * Allow to serialize a position line.
 * @author jsebfranck
 */
public class PositionSerializer {

    String serialize(Position position) {
        return String.format("%d %d %c", position.getX(), position.getY(), position.getOrientation().toString().charAt(0));
    }
}
