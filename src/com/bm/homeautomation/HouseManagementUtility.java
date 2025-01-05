package com.bm.homeautomation;

import com.bm.rooms.classes.Hall;
import com.bm.rooms.classes.Rooms;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class HouseManagementUtility {
    static Scanner sc = new Scanner(System.in);

    public static void deleteRoom(House myHouse) {
        if (myHouse.getRooms().isEmpty()) {
            System.out.println("No rooms available to delete.");
            return;
        }

        listRooms(myHouse);
        System.out.print("Enter Room ID to delete: ");
        int roomId = getValidIntInput();

        boolean removed = myHouse.getRooms().removeIf(room -> room.getRoomID() == roomId);
        if (removed) {
            System.out.println("Room with ID " + roomId + " deleted successfully.");
        } else {
            System.out.println("Room with ID " + roomId + " not found.");
        }
    }

    public static void listRooms(House myHouse) {
        if (myHouse.getRooms().isEmpty()) {
            System.out.println("No rooms available.");
        } else {
            System.out.println("Available rooms:");
            for (Rooms room : myHouse.getRooms()) {
                System.out.println("Room ID: " + room.getRoomID() + ", Type: " + room.getClass().getSimpleName());
            }
        }
    }

    public static void addRoom(House myHouse) {
        System.out.println("Which room do you want to add?");
        System.out.println("1: Hall \t 2: Kitchen \t 0: Cancel");
        int roomType = getValidChoice(2);

        if (roomType == 0) {
            System.out.println("Room addition cancelled.");
            return;
        }

        System.out.print("Enter Room ID: ");
        int roomId = getValidIntInput();


        if (myHouse.getRooms().stream().anyMatch(room -> room.getRoomID() == roomId)) {
            System.out.println("Room ID already exists. Please use a unique ID.");
            return;
        }

        Rooms newRoom = switch (roomType) {
            case 1 -> new Hall(roomId);

            case 2 -> {
                System.out.println("Kitchen room type not implemented yet.");
                yield null;
            }
            default -> {
                System.out.println("Invalid room type.");
                yield null;
            }
        };

        if (newRoom != null) {
            myHouse.getRooms().add(newRoom);
            System.out.println("Room added successfully: ID " + roomId + ", Type " + newRoom.getClass().getSimpleName());
        } else {
            System.out.println("Room addition failed.");
        }
    }


    private static int getValidIntInput() {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next(); // Clear invalid input
            }
        }
    }

    private static int getValidChoice(int maxOption) {
        while (true) {
            try {
                int choice = sc.nextInt();
                if (choice >= 0 && choice <= maxOption) {
                    return choice;
                } else {
                    System.out.println("Please enter a number between 0 and " + maxOption + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // Clear invalid input
            }
        }
    }
}
