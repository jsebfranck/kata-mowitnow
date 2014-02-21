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
                advanceMower(mower);
                break;
        }
    }

    private void advanceMower(Mower mower) {
        switch (mower.getOrientation()) {
            case NORTH:
                mower.setY(mower.getY() + 1);
                break;
            case WEST:
                mower.setX(mower.getX() - 1);
                break;
            case SOUTH:
                mower.setY(mower.getY() - 1);
                break;
            case EAST:
                mower.setX(mower.getX() + 1);
                break;
        }
    }
}
