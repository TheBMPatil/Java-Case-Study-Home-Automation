package com.bm.devices.classes;

import com.bm.devices.interfaces.EntertainmentDevices;
import com.bm.rooms.interfaces.BedRoomMIF;
import com.bm.rooms.interfaces.CorridorsMIF;
import com.bm.rooms.interfaces.HallMIF;
import com.bm.rooms.interfaces.LivingAreaMIF;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class MusicPlayer extends Devices implements EntertainmentDevices, HallMIF, LivingAreaMIF, BedRoomMIF, CorridorsMIF {
    private int volume;
    private String mode;
    private static final Scanner sc = new Scanner(System.in);

    public MusicPlayer(int deviceId) {
        super(deviceId);
        this.volume = 10; // Default volume
        this.mode = "Normal"; // Default mode
        this.onOffStatus = false;
        this.lastActivityTime = LocalTime.now();
    }

    @Override
    public void deviceTurnOnOff() {
        if (onOffStatus) {
            System.out.println("Music Player is ON for: " + getCurrentStateTime() + " minutes.");
            if (getUserChoice("turn it OFF") == 1) {
                turnOffDevice();
            }
        } else {
            System.out.println("Music Player is OFF for: " + getCurrentStateTime() + " minutes.");
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
        System.out.println("Music Player turned off.");
    }

    private void turnOnDevice() {
        onOffStatus = true;
        lastActivityTime = LocalTime.now();
        System.out.println("Music Player turned on.");
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
            System.out.println("Special operations for the Music Player:");
            System.out.println("1) Increase volume");
            System.out.println("2) Decrease volume");
            System.out.println("3) Change mode");
            System.out.println("0) Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> increaseVolume();
                case 2 -> decreaseVolume();
                case 3 -> changeMode();
                case 0 -> System.out.println("Exiting special operations.");
                default -> System.out.println("Invalid choice! Please select again.");
            }
        } while (choice != 0);
    }

    @Override
    public void increaseVolume() {
        System.out.println("Current Volume: " + volume);
        if (volume < 100) { // Maximum volume
            volume++;
            System.out.println("Volume increased to: " + volume);
        } else {
            System.out.println("Volume is already at the maximum limit.");
        }
    }

    @Override
    public void decreaseVolume() {
        System.out.println("Current Volume: " + volume);
        if (volume > 0) { // Minimum volume
            volume--;
            System.out.println("Volume decreased to: " + volume);
        } else {
            System.out.println("Volume is already at the minimum limit.");
        }
    }

    @Override
    public void changeMode() {
        int choice;
        do {
            System.out.println("Current Mode: " + mode);
            System.out.println("Choose Mode:");
            System.out.println("1) Normal");
            System.out.println("2) Bass Boost");
            System.out.println("3) Treble Boost");
            System.out.println("4) Surround");
            System.out.println("0) Cancel");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> mode = "Normal";
                case 2 -> mode = "Bass Boost";
                case 3 -> mode = "Treble Boost";
                case 4 -> mode = "Surround";
                case 0 -> System.out.println("Mode change canceled.");
                default -> System.out.println("Invalid choice! Please select again.");
            }
        } while (choice != 0);
        System.out.println("Mode set to: " + mode);
    }
}
