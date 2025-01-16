package com.bm.devices.classes;

import com.bm.devices.interfaces.TemperatureControlDevices;
import com.bm.devices.interfaces.WaterFlowControlDevice;
import com.bm.rooms.interfaces.WashRoomMIF;

import java.util.Scanner;

public class WashingMachine extends Devices implements WashRoomMIF, WaterFlowControlDevice, TemperatureControlDevices {
    private int waterFlow;
    private int temperature;
    private String mode;

    private static final int MAX_TEMPERATURE = 60;
    private static final int MIN_TEMPERATURE = 20;
    private static final int MAX_FLOW = 10;
    private static final int MIN_FLOW = 1;


    public WashingMachine(int deviceId) {
        super(deviceId);
        this.waterFlow = 5;
        this.temperature = 30;
        this.mode = "Normal";
        this.onOffStatus = false;
    }

    @Override
    public void specialOperations() {
        int choice;
        do {
            System.out.println("Special operations for Washing Machine:");
            System.out.println("1) Increase Water Flow");
            System.out.println("2) Decrease Water Flow");
            System.out.println("3) Increase Temperature");
            System.out.println("4) Decrease Temperature");
            System.out.println("5) Change Washing Mode");
            System.out.println("6) Display Current Status");
            System.out.println("0) Exit");
            choice = getIntInput();
            switch (choice) {
                case 1 -> increaseFlow();
                case 2 -> decreaseFlow();
                case 3 -> increaseTemperature();
                case 4 -> decreaseTemperature();
                case 5 -> changeMode();
                case 6 -> displayStatus();
                case 0 -> System.out.println("Exiting special operations.");
                default -> System.out.println("Invalid choice! Please select again.");
            }
        } while (choice != 0);
    }

    @Override
    public void increaseFlow() {
        System.out.println("Current Water Flow: " + waterFlow + " liters/min");
        if (waterFlow < MAX_FLOW) {
            waterFlow++;
            System.out.println("Water flow increased to: " + waterFlow + " liters/min");
        } else {
            System.out.println("Water flow is already at the maximum limit.");
        }
    }

    @Override
    public void decreaseFlow() {
        System.out.println("Current Water Flow: " + waterFlow + " liters/min");
        if (waterFlow > MIN_FLOW) {
            waterFlow--;
            System.out.println("Water flow decreased to: " + waterFlow + " liters/min");
        } else {
            System.out.println("Water flow is already at the minimum limit.");
        }
    }

    @Override
    public void increaseTemperature() {
        System.out.println("Current Temperature: " + temperature + "°C");
        if (temperature < MAX_TEMPERATURE) {
            temperature += 5; // Increment temperature by 5°C
            System.out.println("Temperature increased to: " + temperature + "°C");
        } else {
            System.out.println("Temperature is already at the maximum limit.");
        }
    }

    @Override
    public void decreaseTemperature() {
        System.out.println("Current Temperature: " + temperature + "°C");
        if (temperature > MIN_TEMPERATURE) {
            temperature -= 5; // Decrement temperature by 5°C
            System.out.println("Temperature decreased to: " + temperature + "°C");
        } else {
            System.out.println("Temperature is already at the minimum limit.");
        }
    }

    @Override
    public void changeMode() {
        int choice;
        do {
            System.out.println("Current Washing Mode: " + mode);
            System.out.println("Choose Washing Mode:");
            System.out.println("1) Normal");
            System.out.println("2) Delicate");
            System.out.println("3) Heavy");
            System.out.println("4) Quick Wash");
            System.out.println("0) Cancel");
            choice = getIntInput();
            switch (choice) {
                case 1 -> mode = "Normal";
                case 2 -> mode = "Delicate";
                case 3 -> mode = "Heavy";
                case 4 -> mode = "Quick Wash";
                case 0 -> System.out.println("Mode change canceled.");
                default -> System.out.println("Invalid choice! Please select again.");
            }
        } while (choice != 0);
        System.out.println("Washing mode set to: " + mode);
    }

    private void displayStatus() {
        System.out.println("Washing Machine Status:");
        System.out.println("- Power: " + (onOffStatus ? "On" : "Off"));
        System.out.println("- Water Flow: " + waterFlow + " liters/min");
        System.out.println("- Temperature: " + temperature + "°C");
        System.out.println("- Washing Mode: " + mode);
    }


}
