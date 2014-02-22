package com.jsebfranck.mowitnow.mower.movement;

import com.jsebfranck.mowitnow.mower.Ground;
import com.jsebfranck.mowitnow.mower.Position;
import com.jsebfranck.mowitnow.mower.Orientation;

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
