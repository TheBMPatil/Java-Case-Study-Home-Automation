package com.bm.devices.classes;

import com.bm.devices.DeviceOperatons;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public abstract class Devices implements DeviceOperatons {
    static final Scanner sc = new Scanner(System.in);
    protected int deviceId;
    protected boolean onOffStatus;
    LocalTime lastActivityTime;
    protected String deviceName; // Optional: Device name for better identification

    // Constructor with optional deviceName
    public Devices(int deviceId) {
        this.deviceId = deviceId;
        this.deviceName = this.getClass().getName();
        this.onOffStatus = false;
    }

    public int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    @Override
    public int getCurrentStateTime() {
        if (lastActivityTime != null) {
            Duration duration = Duration.between(lastActivityTime, LocalTime.now());
            return (int) duration.toMinutes();
        }
        return 0;
    }

    @Override
    public boolean isOn() {
        return onOffStatus;
    }

    @Override
    public int getDeviceId() {
        return this.deviceId;
    }

    @Override
    public void deviceTurnOnOff() {
        if (onOffStatus) {
            System.out.println(deviceName + " is active for: " + formatDuration(getCurrentStateTime()));
            if (getUserChoice("turn it OFF")) {
                turnOffDevice();
            }
        } else {
            System.out.println(deviceName + " is OFF for: " + formatDuration(getCurrentStateTime()));
            if (getUserChoice("turn it ON")) {
                turnOnDevice();
            }
        }
    }

    private boolean getUserChoice(String action) {
        System.out.println("Do you want to " + action + "? (Yes: 1 / No: 2)");
        int choice = getIntInput();
        return choice == 1;
    }

    public void turnOffDevice() {
        onOffStatus = false;
        lastActivityTime = LocalTime.now();
        System.out.println(deviceName + " turned off.");
    }

    public void turnOnDevice() {
        onOffStatus = true;
        lastActivityTime = LocalTime.now();
        System.out.println(deviceName + " turned on.");
    }

    private String formatDuration(int minutes) {
        int hours = minutes / 60;
        int remainingMinutes = minutes % 60;
        return hours > 0 ? hours + " hours and " + remainingMinutes + " minutes" : remainingMinutes + " minutes";
    }
}
