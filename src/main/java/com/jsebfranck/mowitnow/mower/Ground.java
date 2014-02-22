package com.jsebfranck.mowitnow.mower;

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

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
