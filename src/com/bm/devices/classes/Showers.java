package com.bm.devices.classes;

import com.bm.devices.interfaces.TemperatureControlDevices;
import com.bm.devices.interfaces.WaterFlowControlDevice;
import com.bm.rooms.interfaces.WashRoomMIF;

import java.util.Scanner;

public class Showers extends Devices implements WashRoomMIF, TemperatureControlDevices, WaterFlowControlDevice {
    private int temperature;
    private int waterFlow;
    private String mode;

    private static final int MAX_TEMPERATURE = 50;
    private static final int MIN_TEMPERATURE = 10;
    private static final int MAX_FLOW = 10;
    private static final int MIN_FLOW = 1;

    private static final Scanner sc = new Scanner(System.in);

    public Showers(int deviceId) {
        super(deviceId);
        this.temperature = 30;
        this.waterFlow = 5;
        this.mode = "Rain";
        this.onOffStatus = false;
    }

    @Override
    public void specialOperations() {
        int choice;
        do {
            System.out.println("Special operations for Showers:");
            System.out.println("1) Increase Temperature");
            System.out.println("2) Decrease Temperature");
            System.out.println("3) Change Mode");
            System.out.println("4) Increase Water Flow");
            System.out.println("5) Decrease Water Flow");
            System.out.println("6) Display Current Status");
            System.out.println("0) Exit");
            choice = getIntInput();
            switch (choice) {
                case 1 -> increaseTemperature();
                case 2 -> decreaseTemperature();
                case 3 -> changeMode();
                case 4 -> increaseFlow();
                case 5 -> decreaseFlow();
                case 6 -> displayStatus();
                case 0 -> System.out.println("Exiting special operations.");
                default -> System.out.println("Invalid choice! Please select again.");
            }
        } while (choice != 0);
    }

    @Override
    public void increaseTemperature() {
        System.out.println("Current Temperature: " + temperature + "°C");
        if (temperature < MAX_TEMPERATURE) {
            temperature++;
            System.out.println("Temperature increased to: " + temperature + "°C");
        } else {
            System.out.println("Temperature is already at the maximum limit.");
        }
    }

    @Override
    public void decreaseTemperature() {
        System.out.println("Current Temperature: " + temperature + "°C");
        if (temperature > MIN_TEMPERATURE) {
            temperature--;
            System.out.println("Temperature decreased to: " + temperature + "°C");
        } else {
            System.out.println("Temperature is already at the minimum limit.");
        }
    }

    @Override
    public void changeMode() {
        int choice;
        do {
            System.out.println("Current Mode: " + mode);
            System.out.println("Choose Mode:");
            System.out.println("1) Rain");
            System.out.println("2) Jet");
            System.out.println("3) Mist");
            System.out.println("4) Massage");
            System.out.println("0) Cancel");
            choice = getIntInput();
            switch (choice) {
                case 1 -> mode = "Rain";
                case 2 -> mode = "Jet";
                case 3 -> mode = "Mist";
                case 4 -> mode = "Massage";
                case 0 -> System.out.println("Mode change canceled.");
                default -> System.out.println("Invalid choice! Please select again.");
            }
        } while (choice != 0);
        System.out.println("Mode set to: " + mode);
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

    private void displayStatus() {
        System.out.println("Shower Status:");
        System.out.println("- Power: " + (onOffStatus ? "On" : "Off"));
        System.out.println("- Temperature: " + temperature + "°C");
        System.out.println("- Water Flow: " + waterFlow + " liters/min");
        System.out.println("- Mode: " + mode);
    }


}
