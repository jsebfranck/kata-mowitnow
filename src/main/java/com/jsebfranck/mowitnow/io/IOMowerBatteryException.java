package com.jsebfranck.mowitnow.io;

/**
 * Thrown if the IO mower battery lines are invalid.
 * @author jsebfranck
 */
class IOMowerBatteryException extends Exception {

    IOMowerBatteryException(String message) {
        super(message);
    }
}
