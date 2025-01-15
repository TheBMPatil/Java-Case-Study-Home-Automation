package com.bm.devices.classes;

import com.bm.devices.interfaces.EntertainmentDevices;
import com.bm.rooms.interfaces.HallMIF;
import com.bm.rooms.interfaces.LivingAreaMIF;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class TV extends Devices implements HallMIF, LivingAreaMIF, EntertainmentDevices {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAX_VOLUME = 100;
    private static final int MIN_VOLUME = 0;

    private int channelNo;
    private int volume;
    private String mode;

    public TV(int deviceId) {
        super(deviceId);
        this.lastActivityTime = LocalTime.now();
        this.onOffStatus = false;
        this.channelNo = 1;
        this.volume = MIN_VOLUME;
        this.mode = "AV";
    }

    @Override
    public void deviceTurnOnOff() {
        if (onOffStatus) {
            System.out.println("Device is active for: " + getCurrentStateTime() + " minutes.");
            if (getUserChoice("turn it OFF")) {
                turnOffDevice();
            }
        } else {
            System.out.println("Device is OFF for: " + getCurrentStateTime() + " minutes.");
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
    public void specialOperations() {
        int choice;
        do {
            System.out.println("""
                        List of specific operations for TV:
                        1) Increase volume
                        2) Decrease volume
                        3) Change Mode
                        4) Change Channel
                        0) Exit
                    """);
            choice = getIntInput();
            switch (choice) {
                case 1 -> increaseVolume();
                case 2 -> decreaseVolume();
                case 3 -> changeMode();
                case 4 -> changeChannel();
                case 0 -> System.out.println("Exiting special operations...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private void changeChannel() {
        int choice;
        do {
            System.out.println("Current Channel No: " + channelNo);
            System.out.println("""
                        1) + channel
                        2) - channel
                        0) Cancel
                    """);
            choice = getIntInput();
            switch (choice) {
                case 1 -> channelNo++;
                case 2 -> channelNo = Math.max(channelNo - 1, 0);
                case 0 -> System.out.println("Channel change canceled.");
                default -> System.out.println("Invalid choice. Please try again.");
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
            System.out.println("Volume is already at maximum.");
        }
    }

    @Override
    public void decreaseVolume() {
        System.out.println("Current Volume: " + volume);
        if (volume > MIN_VOLUME) {
            volume--;
            System.out.println("Volume decreased to: " + volume);
        } else {
            System.out.println("Volume is already at minimum.");
        }
    }

    @Override
    public void changeMode() {
        int choice;
        do {
            System.out.println("Current Mode of TV: " + mode);
            System.out.println("""
                        Choose Mode to change:
                        1) Movie
                        2) Cinema
                        3) Sports
                        4) Vivid
                        5) Dynamic
                        6) Game
                        7) Natural
                        0) Cancel
                    """);
            choice = getIntInput();
            switch (choice) {
                case 1 -> mode = "Movie";
                case 2 -> mode = "Cinema";
                case 3 -> mode = "Sports";
                case 4 -> mode = "Vivid";
                case 5 -> mode = "Dynamic";
                case 6 -> mode = "Game";
                case 7 -> mode = "Natural";
                case 0 -> System.out.println("Mode change canceled.");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
