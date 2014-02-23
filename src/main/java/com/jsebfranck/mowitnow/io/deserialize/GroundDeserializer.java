package com.jsebfranck.mowitnow.io.deserialize;

import com.jsebfranck.mowitnow.mower.ground.Ground;

import java.util.List;

/**
 * Allow to deserialize a ground.
 * @author jsebfranck
 */
class GroundDeserializer {

    Ground deserialize(String groundLine) throws IOMowerBatteryInputException {
        List<String> groundParameters = RegexUtils.findByPattern(groundLine, "(\\d)\\s(\\d)", "Invalid ground provided " + groundLine);
        int width = Integer.valueOf(groundParameters.get(0));
        int height = Integer.valueOf(groundParameters.get(1));

        return new Ground(width, height);
    }
}
