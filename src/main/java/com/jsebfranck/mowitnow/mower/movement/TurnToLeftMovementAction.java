package com.jsebfranck.mowitnow.mower.movement;

import com.jsebfranck.mowitnow.mower.ground.Ground;
import com.jsebfranck.mowitnow.mower.position.Orientation;
import com.jsebfranck.mowitnow.mower.position.Position;

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
