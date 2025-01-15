package com.bm.devices.classes;

import com.bm.devices.interfaces.EntertainmentDevices;
import com.bm.rooms.interfaces.HallMIF;
import com.bm.rooms.interfaces.LivingAreaMIF;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class TV extends Devices implements HallMIF, LivingAreaMIF, EntertainmentDevices {
    static Scanner sc = new Scanner(System.in);
    int channelNo;
    int volume;
    String mode;

    public TV(int deviceId) {
        super(deviceId);

        this.lastActivityTime = LocalTime.now();
        this.onOffStatus = false;
        this.channelNo = 1;
        this.volume = 0;
        this.mode = "AV";
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
        int ch;
        do {
            System.out.println("List of specific operations for TV:");
            System.out.println("1) Increase volume ");
            System.out.println("2) Decrease volume ");
            System.out.println("3) Change Mode ");
            System.out.println("4) Change Channel ");
            ch = sc.nextInt();
            switch (ch) {
                case 1 -> this.increaseVolume();
                case 2 -> this.decreaseVolume();
                case 3 -> changeMode();
                case 4 -> this.changeChannel();
                case 0 -> {
                    return;
                }
                default -> {
                    System.out.println("Invalid choice...!");
                }
            }
        } while (ch != 0);
    }

    private void changeChannel() {
        int ch;
        do {
            System.out.println("Current Channel no : " + this.channelNo);
            System.out.println("1) + channel");
            System.out.println("2) - channel");
            System.out.println("0) Cancel");
            ch = sc.nextInt();
            switch (ch) {
                case 1 -> this.channelNo++;
                case 2 -> this.channelNo--;
                case 0 -> {
                    return;
                }
            }
        } while (ch != 0);
    }

    @Override
    public void increaseVolume() {
        System.out.println("Current Volume : " + volume);
        if (this.volume < 100) this.volume++;
        System.out.println("After increasing Volume : " + volume);
    }

    @Override
    public void decreaseVolume() {
        System.out.println("Current Volume : " + volume);
        if (this.volume > 0) this.volume--;
        System.out.println("After decreasing Volume : " + volume);
    }

    @Override
    public void changeMode() {
        int ch;
        do {
            System.out.println("Current Mode of TV : " + this.mode);

            System.out.println("Choose Mode to change");
            System.out.println("1) Movie\n2) Cinema\n3) Sports\n4) Vivid\n5) Dynamic\n6) Game\n7) Natural \n 0) Cancel mode change ");
            ch = sc.nextInt();
            switch (ch) {
                case 1 -> this.mode = "Movie";
                case 2 -> this.mode = "Cinema";
                case 3 -> this.mode = "Sports";
                case 4 -> this.mode = "Vivid";
                case 5 -> this.mode = "Dynamic";
                case 6 -> this.mode = "Game";
                case 7 -> this.mode = "Natural";
                case 0 -> {
                    return;
                }
            }
        } while (ch != 0);
    }
}
