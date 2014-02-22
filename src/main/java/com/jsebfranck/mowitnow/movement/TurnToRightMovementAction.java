package com.jsebfranck.mowitnow.movement;

import com.jsebfranck.mowitnow.Ground;
import com.jsebfranck.mowitnow.Position;
import com.jsebfranck.mowitnow.Orientation;

/**
 * Allow to move a mower to the right.
 * @author jsebfranck
 */
class TurnToRightMovementAction implements MovementAction {

    @Override
    public void move(Ground ground, Position mower) {
        mower.setOrientation(Orientation.getRightOrientation(mower.getOrientation()));
    }
}
