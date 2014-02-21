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

        switch (mowerControls.get(0)) {
            case TURN_LEFT:
                mower.setOrientation(Orientation.WEST);
                break;
            case TURN_RIGHT:
                mower.setOrientation(Orientation.EAST);
                break;
            case ADVANCE:
                mower.setY(mower.getY() + 1);
                break;
        }
    }
}
