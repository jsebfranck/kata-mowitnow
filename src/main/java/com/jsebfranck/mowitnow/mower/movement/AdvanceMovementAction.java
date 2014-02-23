package com.jsebfranck.mowitnow.mower.movement;

import com.jsebfranck.mowitnow.mower.ground.Ground;
import com.jsebfranck.mowitnow.mower.position.Position;

/**
 * Allow to advance a mower.
 * Check that the mower respects the ground limits.
 * @author jsebfranck
 */
class AdvanceMovementAction implements MovementAction {

    @Override
    public void move(Ground ground, Position mower) {
        switch (mower.getOrientation()) {
            case NORTH:
                mower.setY(Math.min(mower.getY() + 1, ground.getHeight()));
                break;
            case WEST:
                mower.setX(Math.max(mower.getX() - 1, 0));
                break;
            case SOUTH:
                mower.setY(Math.max(mower.getY() - 1, 0));
                break;
            case EAST:
                mower.setX(Math.min(mower.getX() + 1, ground.getWidth()));
                break;
        }
    }
}
