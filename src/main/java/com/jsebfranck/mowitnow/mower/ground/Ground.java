package com.jsebfranck.mowitnow.mower.ground;

/**
 * Represents the ground where a mower can be moved.
 * @author jsebfranck
 */
public class Ground {

    private final int width;
    private final int height;

    public Ground(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}
