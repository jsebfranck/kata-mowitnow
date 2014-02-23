package com.jsebfranck.mowitnow.battery.input;


import com.jsebfranck.mowitnow.mower.ground.Ground;

import java.util.List;

/**
 * Contains all parameters needed for a mower battery.
 * @author jsebfranck
 */
public class MowerBatteryInput {

    private final Ground ground;
    private final List<MowerBatteryInputEntry> entries;

    public MowerBatteryInput(Ground ground, List<MowerBatteryInputEntry> entries) {
        this.ground = ground;
        this.entries = entries;
    }

    public Ground getGround() {
        return ground;
    }

    public List<MowerBatteryInputEntry> getEntries() {
        return entries;
    }
}
