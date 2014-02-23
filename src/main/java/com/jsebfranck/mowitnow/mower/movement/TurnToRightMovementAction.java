package com.jsebfranck.mowitnow.mower.movement;

import com.jsebfranck.mowitnow.mower.ground.Ground;
import com.jsebfranck.mowitnow.mower.position.Position;
import com.jsebfranck.mowitnow.mower.position.Orientation;

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
