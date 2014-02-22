package com.jsebfranck.mowitnow.movement;

import com.jsebfranck.mowitnow.Ground;
import com.jsebfranck.mowitnow.Position;

/**
 * Allow to move a mover.
 */
public interface MovementAction {

    void move(Ground ground, Position mower);
}
