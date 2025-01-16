package com.bm.devices.classes;

import com.bm.devices.interfaces.BrightnessControlDevice;
import com.bm.rooms.interfaces.*;

import java.util.Scanner;

public class Light extends Devices implements HallMIF, KitchenMIF, CorridorsMIF, BedRoomMIF, LivingAreaMIF, WashRoomMIF, DiningRoomMIF, BrightnessControlDevice {

    private int brightness;
    private boolean isOn;


    private static final int MAX_BRIGHTNESS = 100;
    private static final int MIN_BRIGHTNESS = 0;

    public Light(int deviceId) {
        super(deviceId);
        this.brightness = 50;
        this.isOn = false;
    }

    @Override
    public void increaseBrightness() {
        if (brightness < MAX_BRIGHTNESS) {
            brightness += 10;
            System.out.println("Brightness increased to: " + brightness + "%");
        } else {
            System.out.println("Brightness is already at the maximum level.");
        }
    }

    @Override
    public void decreaseBrightness() {
        if (brightness > MIN_BRIGHTNESS) {
            brightness -= 10;
            System.out.println("Brightness decreased to: " + brightness + "%");
        } else {
            System.out.println("Brightness is already at the minimum level.");
        }
    }

    @Override
    public void specialOperations() {
        int choice = 0;
        do {
            System.out.println("\nSpecial Operations for the Light:");
            System.out.println("1. Increase Brightness");
            System.out.println("2. Decrease Brightness");

            System.out.println("3. View Current Brightness");
            System.out.println("0. Exit Special Operations");

            System.out.println("Enter your choice:");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid option.");
                sc.next(); // Clear invalid input
                continue;
            }

            choice = sc.nextInt();
            switch (choice) {
                case 1 -> increaseBrightness();
                case 2 -> decreaseBrightness();
                case 3 -> showCurrentBrightness();
                case 0 -> System.out.println("Exiting special operations...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }


    private void showCurrentBrightness() {
        System.out.println("Current brightness: " + brightness + "%");
    }
}
