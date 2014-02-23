package com.jsebfranck.mowitnow.io;

/**
 * Thrown if the IO mower battery lines are invalid.
 * @author jsebfranck
 */
class IOMowerBatteryInputException extends Exception {

    IOMowerBatteryInputException(String message) {
        super(message);
    }
}
