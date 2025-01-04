package com.bm.homeautomation;

import com.bm.rooms.classes.Hall;
import com.bm.rooms.classes.Rooms;

import java.util.Scanner;

public class HomeAutomation {

    static Scanner sc = new Scanner(System.in);

    public static void startAutomation() {
        House myHouse = new House(123);
        int choice;

        System.out.println("Welcome Home...");

        do {
            System.out.println("What do you want to do ?");
            System.out.println("1. Home Management ");
            System.out.println("2. Rooms Management ");
            System.out.println("3. Device Management ");
            System.out.println("0. Exit ");

            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    choice = houseMenu();
                    switch (choice) {
                        case 1:
                            sc.nextLine();
                            System.out.println("Old House name is : " + myHouse.getHouseName());
                            System.out.println("Enter name for house :");
                            String houseName = sc.nextLine();
                            myHouse.setHouseName(houseName);
                            break;
                        case 2:
                            System.out.println("Old house Number is : " + myHouse.getHouseNo());
                            System.out.println("Enter new House number :");
                            int houseNo = sc.nextInt();
                            myHouse.setHouseNo(houseNo);
                            break;
                        default:
                            System.out.println("Invalid Choice na bro...!");
                    }
                }
                case 2 -> {
                    choice = roomMenu();
                    switch (choice) {
                        case 1:
                            System.out.println("Add Rooms.");
                            myHouse.getRooms().add(addRoom());
                    }

                }
                case 3 -> DeviceManagement.deviceManager(myHouse);

                case 0 -> {
                    return;
                }
                default -> {
                    System.out.println("Invalid Choice..! try again.");
                }
            }
        } while (choice != 0);


    }



    private static Rooms addRoom() {
        System.out.println("Which room do you want to add ?");
        System.out.println("1 : Hall \t 2 : Kitchen etc 0 : Cancel ");
        switch (sc.nextInt()) {
            case 1 -> {
                System.out.println("Enter room ID");
                int roomId = sc.nextInt();
                return new Hall(roomId);
            }
            case 0 -> {
                return null;
            }
        }
        return null;
    }

    private static int roomMenu() {
        System.out.println("What do you want to do ?");
        System.out.println("1 : Add Rooms ");
        System.out.println("2 : Delete rooms");
        System.out.println("3 : List All Rooms ");

        return sc.nextInt();
    }


    private static int houseMenu() {
        System.out.println("What do you want to do ?");
        System.out.println("1 : Rename House ");
        System.out.println("2 : Update House Number");
        return sc.nextInt();
    }
}
