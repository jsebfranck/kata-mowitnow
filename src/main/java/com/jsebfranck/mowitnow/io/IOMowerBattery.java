package com.jsebfranck.mowitnow.io;

import com.jsebfranck.mowitnow.battery.MowerBattery;
import com.jsebfranck.mowitnow.battery.input.MowerBatteryInput;
import com.jsebfranck.mowitnow.battery.output.MowerBatteryOutput;
import com.jsebfranck.mowitnow.io.deserialize.IOMowerBatteryInputException;
import com.jsebfranck.mowitnow.io.deserialize.MowerBatteryInputDeserializer;
import com.jsebfranck.mowitnow.io.serialize.MowerBatteryOutputSerializer;

import java.util.List;

/**
 * Allow to move several mowers in a battery from string instructions.
 * @author jsebfranck
 */
public class IOMowerBattery {

    private final MowerBattery mowerBattery = new MowerBattery();
    private final MowerBatteryInputDeserializer inputDeserializer = new MowerBatteryInputDeserializer();
    private final MowerBatteryOutputSerializer outputSerializer = new MowerBatteryOutputSerializer();

    public List<String> moveAll(List<String> mowerBatteryLines) throws IOMowerBatteryInputException {
        MowerBatteryInput input = inputDeserializer.deserialize(mowerBatteryLines);
        MowerBatteryOutput output = mowerBattery.moveAll(input);
        return outputSerializer.serialize(output);
    }
}
