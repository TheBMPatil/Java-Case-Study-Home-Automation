package com.bm.devices.classes;

import com.bm.devices.interfaces.TemperatureControlDevices;
import com.bm.rooms.interfaces.BedRoomMIF;
import com.bm.rooms.interfaces.HallMIF;
import com.bm.rooms.interfaces.LivingAreaMIF;

import java.util.Scanner;

public class AC extends Devices implements BedRoomMIF, HallMIF, LivingAreaMIF, TemperatureControlDevices {

    private double temperature;
    private String currentMode;
    private static final Scanner sc = new Scanner(System.in);

    // Constants for modes and temperature limits
    private static final String[] MODES = {"Cooling", "Heating", "Fan Only", "Dry Mode"};
    private static final double MAX_TEMP = 30.0;
    private static final double MIN_TEMP = 16.0;

    public AC(int roomID) {
        super(roomID);
        this.temperature = 24.0;
        this.currentMode = MODES[0];
        this.onOffStatus = false;
    }

    @Override
    public void increaseTemperature() {
        if (temperature < MAX_TEMP) {
            temperature++;
            System.out.println("Temperature increased to: " + temperature + "°C");
        } else {
            System.out.println("Temperature is already at the maximum limit.");
        }
    }

    @Override
    public void decreaseTemperature() {
        if (temperature > MIN_TEMP) {
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
            sc.next();
            return;
        }

        int modeIndex = sc.nextInt() - 1;
        if (modeIndex >= 0 && modeIndex < MODES.length) {
            currentMode = MODES[modeIndex];
            System.out.println("Mode changed to: " + currentMode);
        } else {
            System.out.println("Invalid mode selection. Please try again.");
        }
    }

    @Override
    public void specialOperations() {
        int choice = 0;
        do {
            System.out.println("\nSpecial Operations for the AC:");
            System.out.println("1. Increase Temperature");
            System.out.println("2. Decrease Temperature");
            System.out.println("3. Change Mode");
            System.out.println("0. Exit Special Operations");

            System.out.println("Enter your choice:");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid option.");
                sc.next(); // Clear invalid input
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
