package com.jsebfranck.mowitnow.io.deserialize;

/**
 * Thrown if the IO mower battery lines are invalid.
 * @author jsebfranck
 */
public class IOMowerBatteryInputException extends Exception {

    IOMowerBatteryInputException(String message) {
        super(message);
    }
}
