package com.bm.devices.classes;

import com.bm.devices.DeviceOperatons;
import com.bm.rooms.interfaces.HallMIF;
import com.bm.rooms.interfaces.LivingAreaMIF;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class TV extends Devices implements HallMIF, LivingAreaMIF {
    static Scanner sc = new Scanner(System.in);
    private boolean onOffStatus = false;
    private LocalTime lastActivityTime;

    public TV(int deviceId) {
        super(deviceId);
        // Initialize lastActivityTime when device is created.
        this.lastActivityTime = LocalTime.now();
    }

    @Override
    public void deviceTurnOnOff() {
        if (onOffStatus) {
            System.out.println("Device is active for: " + getCurrentStateTime() + " minutes.");
            if (getUserChoice("turn it OFF") == 1) {
                turnOffDevice();
            }
        } else {
            System.out.println("Device is OFF for: " + getCurrentStateTime() + " minutes.");
            if (getUserChoice("turn it ON") == 1) {
                turnOnDevice();
            }
        }
    }

    private int getUserChoice(String action) {
        System.out.println("Do you want to " + action + "? (Yes 1 / No 2)");
        int choice = sc.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.println("Invalid choice. Please enter 1 for Yes or 2 for No.");
            choice = sc.nextInt();
        }
        return choice;
    }

    private void turnOffDevice() {
        onOffStatus = false;
        lastActivityTime = LocalTime.now();
        System.out.println("Device turned off.");
    }

    private void turnOnDevice() {
        onOffStatus = true;
        lastActivityTime = LocalTime.now();
        System.out.println("Device turned on.");
    }

    @Override
    public int getCurrentStateTime() {
        // If the device has been turned on and off before
        if (lastActivityTime != null) {
            Duration duration = Duration.between(lastActivityTime, LocalTime.now());
            return (int) duration.toMinutes();
        } else {
            return 0;
        }
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
    public void specialOperations() {
        System.out.println("List of specific operations for TV:");


    }
}
