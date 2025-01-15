package com.bm.devices.classes;

import com.bm.devices.DeviceOperatons;

import java.time.LocalTime;
import java.util.Scanner;

public abstract class Devices implements DeviceOperatons {
    int deviceId;
    boolean onOffStatus;
    static Scanner sc = new Scanner(System.in);
    LocalTime lastActivityTime;

    public Devices(int deviceId) {
        this.deviceId = deviceId;
        this.onOffStatus = false;
    }
}
