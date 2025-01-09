package com.bm.devices.classes;

import com.bm.devices.DeviceOperatons;

import java.util.Scanner;

public abstract class Devices implements DeviceOperatons {
    int deviceId;
    boolean onOffStatus;
    static Scanner sc = new Scanner(System.in);

    public Devices(int deviceId) {
        this.deviceId = deviceId;
        this.onOffStatus = false;
    }

    @Override
    public void deviceTurnOnOff() {
        if (onOffStatus) {
            System.out.println("Device is on. Do yoy want to turn it OFF ? (1 :Yes 2: NO) ");

        }
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
