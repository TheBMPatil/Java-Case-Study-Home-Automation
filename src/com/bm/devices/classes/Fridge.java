package com.bm.devices.classes;

import com.bm.devices.interfaces.TemperatureControlDevices;

public class Fridge extends Devices implements TemperatureControlDevices {
    double temperature;

    public Fridge(int deviceId) {

        super(deviceId);
        this.temperature = 0.0;
    }

    @Override
    public void increaseTemperature() {

    }

    @Override
    public void decreaseTemperature() {

    }

    @Override
    public void deviceTurnOnOff() {

    }

    @Override
    public int getCurrentStateTime() {
        return 0;
    }

    @Override
    public boolean isOn() {
        return false;
    }

    @Override
    public int getDeviceId() {
        return 0;
    }

    @Override
    public void specialOperations() {

    }
}
