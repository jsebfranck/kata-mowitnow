package com.jsebfranck.mowitnow.movement;

import com.jsebfranck.mowitnow.Ground;
import com.jsebfranck.mowitnow.Position;
import com.jsebfranck.mowitnow.Orientation;

/**
 * Allow to move a mower to the left.
 * @author jsebfranck
 */
class TurnToLeftMovementAction implements MovementAction {

    @Override
    public void move(Ground ground, Position mower) {
        mower.setOrientation(Orientation.getLeftOrientation(mower.getOrientation()));
    }
}
