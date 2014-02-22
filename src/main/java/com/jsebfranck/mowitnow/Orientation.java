package com.jsebfranck.mowitnow;

/**
 * All possible orientations of the mower.
 * @author jsebfranck
 */
public enum Orientation {
    NORTH("WEST", "EAST"),
    SOUTH("EAST", "WEST"),
    WEST("SOUTH", "NORTH"),
    EAST("NORTH", "SOUTH");

    private final String leftOrientation;
    private final String rightOrientation;

    private Orientation(String leftDirection, String rightDirection) {
        this.leftOrientation = leftDirection;
        this.rightOrientation = rightDirection;
    }

    public static Orientation getLeftOrientation(Orientation orientation) {
        return Orientation.valueOf(orientation.leftOrientation);
    }

    public static Orientation getRightOrientation(Orientation orientation) {
        return Orientation.valueOf(orientation.rightOrientation);
    }
}
