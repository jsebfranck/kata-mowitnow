package com.jsebfranck.mowitnow.battery;


import com.jsebfranck.mowitnow.mower.Ground;

import java.util.List;

/**
 * Contains all parameters needed for a mower battery.
 * @author jsebfranck
 */
public class MowerBatteryInput {

    private final Ground ground;
    private final List<MowerBatteryEntry> entries;

    public MowerBatteryInput(Ground ground, List<MowerBatteryEntry> entries) {
        this.ground = ground;
        this.entries = entries;
    }

    public Ground getGround() {
        return ground;
    }

    public List<MowerBatteryEntry> getEntries() {
        return entries;
    }
}
