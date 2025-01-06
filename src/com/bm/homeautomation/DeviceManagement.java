package com.bm.homeautomation;

import com.bm.devices.DeviceOperatons;
import com.bm.devices.classes.TV;
import com.bm.rooms.classes.Hall;
import com.bm.rooms.classes.Rooms;

import java.util.List;
import java.util.Scanner;

public class DeviceManagement {
    static Scanner sc = new Scanner(System.in);

    public static void deviceManager(House myHouse) {
        Rooms room = getRoom(myHouse);
        if (room == null) return;

        int choice;
        do {
            displayMainMenu();
            choice = getUserInput("Enter your choice: ");
            switch (choice) {
                case 1 -> addNewDevice(room);
                case 2 -> removeExistingDevice(room);
                case 3 -> handleDeviceOptions(room);
                case 0 -> System.out.println("Exiting the program...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private static void handleDeviceOptions(Rooms room) {
        int innerChoice;
        do {
            DeviceOperatons choosenDevice = getDevice(room);
            if (choosenDevice == null) return;

            displayDeviceMenu();
            innerChoice = getUserInput("Enter your choice: ");
            switch (innerChoice) {
                case 1 -> System.out.println(choosenDevice.isOn() ? "Device is ON" : "Device is OFF");
                case 2 -> System.out.println("Device is active for: " + choosenDevice.getCurrentStateTime() + " Mins.");
                case 3 -> choosenDevice.deviceTurnOnOff();
                case 4 -> choosenDevice.specialOperations();
                case 0 -> System.out.println("Exiting device menu...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (innerChoice != 0);
    }

    private static Rooms getRoom(House myHouse) {
        List<Rooms> rooms = myHouse.getRooms();
        if (rooms.isEmpty()) {
            System.out.println("No rooms available.");
            return null;
        }

        System.out.println("Available Rooms:");
        for (Rooms room : rooms) {
            System.out.println("Room ID: " + room.getRoomID());
        }

        int roomId = getUserInput("Enter Room ID to access devices: ");
        for (Rooms room : rooms) {
            if (room.getRoomID() == roomId) {
                return room;
            }
        }

        System.out.println("Invalid Room ID. Please try again.");
        return null;
    }

    private static DeviceOperatons getDevice(Rooms room) {
        List<DeviceOperatons> devices = room.getAllDevices();
        if (devices.isEmpty()) {
            System.out.println("No devices available in this room.");
            return null;
        }

        System.out.println("Available Devices:");
        for (DeviceOperatons device : devices) {
            System.out.println("Device ID: " + device.getDeviceId());
        }

        int deviceId = getUserInput("Enter Device ID to access options: ");
        for (DeviceOperatons device : devices) {
            if (device.getDeviceId() == deviceId) {
                return device;
            }
        }

        System.out.println("Invalid Device ID. Please try again.");
        return null;
    }

    private static int getUserInput(String prompt) {
        System.out.print(prompt);
        try {
            return sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
            sc.next(); // Clear invalid input
            return -1;
        }
    }

    private static void displayMainMenu() {
        System.out.println("What do you want to do?");
        System.out.println("1 : Add new Device ");
        System.out.println("2 : Remove Device ");
        System.out.println("3 : Device specific options ");
        System.out.println("0 : Exit ");
    }

    private static void displayDeviceMenu() {
        System.out.println("1 : Check Device status");
        System.out.println("2 : Check Device Active time");
        System.out.println("3 : Check Device Status and turn it ON or OFF");
        System.out.println("4 : Special Options");
        System.out.println("0 : Exit");
    }

    private static void addNewDevice(Rooms room) {
        System.out.println("Adding new Device");


        if (room == null) {
            System.out.println("Room not found. Cannot add device.");
            return;
        }

        // Get the list of devices in the room
        List<DeviceOperatons> devices = room.getAllDevices();
        System.out.println(devices);
        // Prompt user for the device type
        System.out.println("Enter which device you want to add :");
        System.out.println("1 : TV \t 2 : AC (To be implemented) \t 3 : Music Player (To be implemented) \n 0 : Cancel");
        int deviceType = sc.nextInt();

        switch (deviceType) {
            case 1 -> {
                // Add a TV device
                System.out.println("Enter device ID");
                int devId = sc.nextInt();
                DeviceOperatons tv = new TV(devId); // Assuming TV is a class implementing DeviceOperatons
                devices.add(tv);
                System.out.println("TV added successfully.");
            }
            case 2, 3 -> {
                // Placeholder for future implementation
                System.out.println("This device type is not implemented yet. Please try again later.");
            }
            case 0 -> {
                // Cancel operation
                System.out.println("Device addition canceled.");
            }
            default -> {
                // Invalid input handling
                System.out.println("Invalid choice. Please select a valid device type.");
            }
        }
    }


    private static void removeExistingDevice(Rooms room) {
        System.out.println("Removing an existing device");

        if (room == null) {
            System.out.println("Room not found. Cannot remove device.");
            return;
        }
        List<DeviceOperatons> devices = room.getAllDevices();

        if (devices.isEmpty()) {
            System.out.println("No devices found in this room to remove.");
            return;
        }

        System.out.println("Devices in the room:");
        for (int i = 0; i < devices.size(); i++) {
            System.out.println((i + 1) + ": " + devices.get(i).getClass().getSimpleName());
        }

        System.out.println("Enter the number of the device you want to remove (0 to cancel):");
        int choice = sc.nextInt();

        if (choice == 0) {
            System.out.println("Device removal canceled.");
            return;
        }

        if (choice < 1 || choice > devices.size()) {
            System.out.println("Invalid choice. Please select a valid device number.");
            return;
        }

        DeviceOperatons removedDevice = devices.remove(choice - 1);
        System.out.println(removedDevice.getClass().getSimpleName() + " removed successfully.");
    }


}
