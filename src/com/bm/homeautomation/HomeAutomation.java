package com.bm.homeautomation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeAutomation {

    static Scanner sc = new Scanner(System.in);

    public static void startAutomation() {
        House myHouse = new House(123);
        int choice;

        System.out.println("Welcome Home...");

        do {
            printMainMenu();
            choice = getValidChoice(3);

            switch (choice) {
                case 1 -> {
                    int houseChoice = houseMenu();
                    switch (houseChoice) {
                        case 1 -> renameHouse(myHouse);
                        case 2 -> updateHouseNumber(myHouse);
                        default -> System.out.println("Invalid Choice, returning to main menu.");
                    }
                }
                case 2 -> {
                    int roomChoice = roomMenu();
                    switch (roomChoice) {
                        case 1 -> HouseManagementUtility.addRoom(myHouse);
                        case 2 -> HouseManagementUtility.deleteRoom(myHouse);
                        case 3 -> HouseManagementUtility.listRooms(myHouse);
                        default -> System.out.println("Invalid Choice, returning to main menu.");
                    }
                }
                case 3 -> DeviceManagement.deviceManager(myHouse);
                case 0 -> System.out.println("Exiting the program...");
                default -> System.out.println("Invalid Choice, please try again.");
            }
        } while (choice != 0);
    }

    private static void printMainMenu() {
        System.out.println("What do you want to do?");
        System.out.println("1. Home Management");
        System.out.println("2. Rooms Management");
        System.out.println("3. Device Management");
        System.out.println("0. Exit");
    }

    private static int houseMenu() {
        System.out.println("What do you want to do?");
        System.out.println("1. Rename House");
        System.out.println("2. Update House Number");
        return getValidChoice(2);
    }

    private static int roomMenu() {
        System.out.println("What do you want to do?");
        System.out.println("1. Add Rooms");
        System.out.println("2. Delete Rooms");
        System.out.println("3. List All Rooms");
        return getValidChoice(3);
    }

    private static void renameHouse(House myHouse) {
        sc.nextLine(); // Clear buffer
        System.out.println("Old House Name: " + myHouse.getHouseName());
        System.out.print("Enter new House Name: ");
        String houseName = sc.nextLine();
        myHouse.setHouseName(houseName);
        System.out.println("House renamed successfully to: " + houseName);
    }

    private static void updateHouseNumber(House myHouse) {
        System.out.println("Old House Number: " + myHouse.getHouseNo());
        System.out.print("Enter new House Number: ");
        int houseNo = getValidIntInput();
        myHouse.setHouseNo(houseNo);
        System.out.println("House number updated successfully to: " + houseNo);
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
}
