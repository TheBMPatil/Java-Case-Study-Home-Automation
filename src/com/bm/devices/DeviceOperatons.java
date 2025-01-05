package com.bm.devices;

public interface DeviceOperatons {
    public void deviceTurnOnOff();

    public int getCurrentStateTime();

    public boolean isOn();

    public int getDeviceId();

    public void specialOperations();
}