package com.jsebfranck.mowitnow.mower.movement;

import com.jsebfranck.mowitnow.mower.Ground;
import com.jsebfranck.mowitnow.mower.Position;

/**
 * Allow to move a mover.
 * @author jsebfranck
 */
public interface MovementAction {

    void move(Ground ground, Position mower);
}
