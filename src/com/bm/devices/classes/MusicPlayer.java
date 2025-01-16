package com.bm.devices.classes;

import com.bm.devices.interfaces.EntertainmentDevices;
import com.bm.rooms.interfaces.BedRoomMIF;
import com.bm.rooms.interfaces.CorridorsMIF;
import com.bm.rooms.interfaces.HallMIF;
import com.bm.rooms.interfaces.LivingAreaMIF;

import java.time.LocalTime;
import java.util.Scanner;

public class MusicPlayer extends Devices implements EntertainmentDevices, HallMIF, LivingAreaMIF, BedRoomMIF, CorridorsMIF {
    private static final int MAX_VOLUME = 100;
    private static final int MIN_VOLUME = 0;

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
    public void specialOperations() {
        int choice;
        do {
            System.out.println("Special operations for the Music Player:");
            System.out.println("1) Increase volume");
            System.out.println("2) Decrease volume");
            System.out.println("3) Change mode");
            System.out.println("4) Display current status");
            System.out.println("0) Exit");
            choice = getIntInput();
            switch (choice) {
                case 1 -> increaseVolume();
                case 2 -> decreaseVolume();
                case 3 -> changeMode();
                case 4 -> displayStatus();
                case 0 -> System.out.println("Exiting special operations.");
                default -> System.out.println("Invalid choice! Please select again.");
            }
        } while (choice != 0);
    }

    @Override
    public void increaseVolume() {
        System.out.println("Current Volume: " + volume);
        if (volume < MAX_VOLUME) {
            volume++;
            System.out.println("Volume increased to: " + volume);
        } else {
            System.out.println("Volume is already at the maximum limit.");
        }
    }

    @Override
    public void decreaseVolume() {
        System.out.println("Current Volume: " + volume);
        if (volume > MIN_VOLUME) {
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
            choice = getIntInput();
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

    private void displayStatus() {
        System.out.println("Music Player Status:");
        System.out.println("- Power: " + (onOffStatus ? "On" : "Off"));
        System.out.println("- Volume: " + volume);
        System.out.println("- Mode: " + mode);
    }
}
