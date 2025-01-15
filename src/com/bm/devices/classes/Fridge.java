package com.bm.devices.classes;

import com.bm.devices.interfaces.TemperatureControlDevices;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class Fridge extends Devices implements TemperatureControlDevices {
    private double temperature;
    private static final Scanner sc = new Scanner(System.in);

    public Fridge(int deviceId) {
        super(deviceId);
        this.temperature = 5.0; // Default temperature
        this.onOffStatus = false;
        this.lastActivityTime = LocalTime.now();
    }

    @Override
    public void increaseTemperature() {
        System.out.println("Current temperature: " + temperature + "°C");
        if (temperature < 10.0) { // Assume max temperature is 10°C
            temperature++;
            System.out.println("Temperature increased to: " + temperature + "°C");
        } else {
            System.out.println("Temperature is already at the maximum limit.");
        }
    }

    @Override
    public void decreaseTemperature() {
        System.out.println("Current temperature: " + temperature + "°C");
        if (temperature > -10.0) { // Assume min temperature is -10°C
            temperature--;
            System.out.println("Temperature decreased to: " + temperature + "°C");
        } else {
            System.out.println("Temperature is already at the minimum limit.");
        }
    }

    @Override
    public void deviceTurnOnOff() {
        if (onOffStatus) {
            System.out.println("Fridge is ON for: " + getCurrentStateTime() + " minutes.");
            if (getUserChoice("turn it OFF") == 1) {
                turnOffDevice();
            }
        } else {
            System.out.println("Fridge is OFF for: " + getCurrentStateTime() + " minutes.");
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
        System.out.println("Fridge turned off.");
    }

    private void turnOnDevice() {
        onOffStatus = true;
        lastActivityTime = LocalTime.now();
        System.out.println("Fridge turned on.");
    }

    @Override
    public int getCurrentStateTime() {
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
        return deviceId;
    }

    @Override
    public void specialOperations() {
        int choice;
        do {
            System.out.println("Special operations for the fridge:");
            System.out.println("1) Increase temperature");
            System.out.println("2) Decrease temperature");
            System.out.println("0) Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> increaseTemperature();
                case 2 -> decreaseTemperature();
                case 0 -> System.out.println("Exiting special operations.");
                default -> System.out.println("Invalid choice! Please select again.");
            }
        } while (choice != 0);
    }
}
