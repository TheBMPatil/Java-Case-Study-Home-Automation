package com.bm.devices.classes;

import com.bm.devices.interfaces.TemperatureControlDevices;

import java.util.Scanner;

public class Fridge extends Devices implements TemperatureControlDevices {
    private double temperature;
    private String currentMode;
    private static final Scanner sc = new Scanner(System.in);


    private static final String[] MODES = {"Fridge Mode", "Freezer Mode", "Power Freeze Mode", "Power Cool Mode", "Vacation Mode", "Eco Mode"};
    private static final double[] MODE_TEMPERATURES = {5.0, -18.0, -25.0, 2.0, 10.0, 7.0};

    public Fridge(int deviceId) {
        super(deviceId);
        this.temperature = MODE_TEMPERATURES[0];
        this.currentMode = MODES[0];
        this.onOffStatus = false;
    }

    @Override
    public void increaseTemperature() {
        System.out.println("Current temperature: " + temperature + "°C");
        if (temperature < 10.0) {
            temperature++;
            System.out.println("Temperature increased to: " + temperature + "°C");
        } else {
            System.out.println("Temperature is already at the maximum limit.");
        }
    }

    @Override
    public void decreaseTemperature() {
        System.out.println("Current temperature: " + temperature + "°C");
        if (temperature > -25.0) {
            temperature--;
            System.out.println("Temperature decreased to: " + temperature + "°C");
        } else {
            System.out.println("Temperature is already at the minimum limit.");
        }
    }

    @Override
    public void changeMode() {
        System.out.println("Available Modes:");
        for (int i = 0; i < MODES.length; i++) {
            System.out.println((i + 1) + ". " + MODES[i]);
        }

        System.out.println("Enter the mode number to select:");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input. Exiting mode change...");
            sc.next(); // Clear invalid input
            return;
        }

        int mode = sc.nextInt();
        if (mode >= 1 && mode <= MODES.length) {
            setMode(mode - 1); // Index is mode - 1
        } else {
            System.out.println("Invalid mode selection. Please try again.");
        }
    }

    private void setMode(int modeIndex) {
        this.currentMode = MODES[modeIndex];
        this.temperature = MODE_TEMPERATURES[modeIndex];
        System.out.println("Mode changed to: " + currentMode);
        System.out.println("Temperature set to: " + temperature + "°C");
    }

    @Override
    public void specialOperations() {
        int choice = 0;
        do {
            System.out.println("\nSpecial Operations for the Fridge:");
            System.out.println("1. Increase Temperature");
            System.out.println("2. Decrease Temperature");
            System.out.println("3. Change Mode");
            System.out.println("0. Exit Special Operations");

            System.out.println("Enter your choice:");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid option.");
                sc.next();
                continue;
            }

            choice = sc.nextInt();
            switch (choice) {
                case 1 -> increaseTemperature();
                case 2 -> decreaseTemperature();
                case 3 -> changeMode();
                case 0 -> System.out.println("Exiting special operations...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
}
