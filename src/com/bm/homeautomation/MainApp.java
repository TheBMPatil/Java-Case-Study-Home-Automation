package com.bm.homeautomation;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        final int PASSWORD = 8408;
        final int MAX_ATTEMPTS = 3;
        Scanner sc = new Scanner(System.in);

        System.out.println("Shree Ganesh...! :>");
        System.out.println("Welcome to Home Automation!");
        System.out.print("Please enter your password: ");

        int attempts = 0;

        while (attempts < MAX_ATTEMPTS) {
            int userPass = getValidIntegerInput(sc);

            if (userPass == PASSWORD) {
                System.out.println("Password validated. Access granted!");
                HomeAutomation.startAutomation();
                break;
            } else {
                attempts++;
                if (attempts < MAX_ATTEMPTS) {
                    System.out.println("Invalid password. Try again. Attempts remaining: " + (MAX_ATTEMPTS - attempts));
                }
            }
        }

        if (attempts == MAX_ATTEMPTS) {
            System.out.println("Failed to login after " + MAX_ATTEMPTS + " attempts. Access denied.");
        }

        System.out.println("Goodbye...!");
    }


    private static int getValidIntegerInput(Scanner sc) {
        while (true) {
            try {
                return sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number: ");
                sc.next(); // Clear the invalid input from scanner buffer.
            }
        }
    }
}
