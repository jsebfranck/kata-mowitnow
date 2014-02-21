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

        mower.setOrientation(Orientation.WEST);
    }
}
