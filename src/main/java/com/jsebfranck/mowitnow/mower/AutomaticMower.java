package com.jsebfranck.mowitnow.mower;

import com.jsebfranck.mowitnow.mower.movement.Movement;

import java.util.List;

/**
 * Provides method allowing to move a mower.
 * @author jsebfranck
 */
public class AutomaticMower {

    public void move(Ground ground, Position position, List<Movement> movements) {
        for (Movement movement : movements) {
            movement.getMovementAction().move(ground, position);
        }
    }
}
