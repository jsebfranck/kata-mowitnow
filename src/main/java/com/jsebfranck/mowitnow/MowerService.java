package com.jsebfranck.mowitnow;

import java.util.List;

/**
 * Provides method allowing to move a mower.
 * @author jsebfranck
 */
public class MowerService {

    public void moveMower(Ground ground, Mower mower, List<MowerControl> mowerControls) {

        if (mowerControls.isEmpty()) {
            return;
        }

        MowerControl mowerControl = mowerControls.get(0);

        switch (mowerControl) {
            case TURN_LEFT:
                mower.setOrientation(Orientation.getLeftOrientation(mower.getOrientation()));
                break;
            case TURN_RIGHT:
                mower.setOrientation(Orientation.getRightOrientation(mower.getOrientation()));
                break;
            case ADVANCE:
                advanceMower(ground, mower);
                break;
        }
    }

    private void advanceMower(Ground ground, Mower mower) {
        switch (mower.getOrientation()) {
            case NORTH:
                mower.setY(Math.min(mower.getY() + 1, ground.getHeight() - 1));
                break;
            case WEST:
                mower.setX(Math.max(mower.getX() - 1, 0));
                break;
            case SOUTH:
                mower.setY(Math.max(mower.getY() - 1, 0));
                break;
            case EAST:
                mower.setX(Math.min(mower.getX() + 1, ground.getWidth() - 1));
                break;
        }
    }
}
