package com.bm.devices.classes;

import com.bm.devices.interfaces.TemperatureControlDevices;
import com.bm.rooms.interfaces.KitchenMIF;

public class Induction extends Devices implements KitchenMIF, TemperatureControlDevices {
    private int temperature;
    final int MAX_TEMPERATURE = 10000;
    final int TEMPERATURE_INCREMENT = 100;
    final int MIN_TEMPERATURE = 100;
    final int TEMPERATURE_DECREMENT = 100;
    final String[] MODES = {"Off", "Boil", "Simmer", "Fry", "Warm"};
    final int[] MODE_TEMPERATURES = {0, 8000, 2000, 6000, 1000};

    public Induction(int deviceId) {
        super(deviceId);
        this.temperature = 0;
    }

    @Override
    public void specialOperations() {
        while (true) {
            System.out.println("Special Operations Menu:");
            System.out.println("1. Increase Temperature");
            System.out.println("2. Decrease Temperature");
            System.out.println("3. Change Mode");
            System.out.println("4. Exit Special Operations");

            System.out.println("Enter your choice:");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid option.");
                sc.next(); // Clear invalid input
                continue;
            }

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> increaseTemperature();
                case 2 -> decreaseTemperature();
                case 3 -> changeMode();
                case 4 -> {
                    System.out.println("Exiting special operations...");
                    return; // Exit the method
                }
                default -> System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }


    @Override
    public void increaseTemperature() {
        while (true) {
            System.out.println("Current temperature: " + this.temperature);

            if (this.temperature < MAX_TEMPERATURE) {
                this.temperature += TEMPERATURE_INCREMENT;
                System.out.println("After increasing, current temperature: " + this.temperature);
            } else {
                System.out.println("Temperature has reached the maximum limit: " + MAX_TEMPERATURE);
                break;
            }

            System.out.println("Want to increase more? Enter 1 for Yes, 2 for No:");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Exiting...");
                break;
            }
            int choice = sc.nextInt();
            if (choice != 1) {
                break;
            }
        }
    }


    @Override
    public void decreaseTemperature() {
        while (true) {
            System.out.println("Current temperature: " + this.temperature);

            if (this.temperature > MIN_TEMPERATURE) {
                this.temperature -= TEMPERATURE_DECREMENT;
                System.out.println("After decreasing, current temperature: " + this.temperature);
            } else {
                System.out.println("Temperature has reached the minimum limit: " + MIN_TEMPERATURE);
                break;
            }

            System.out.println("Want to decrease more? Enter 1 for Yes, 2 for No:");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Exiting...");
                break;
            }

            int choice = sc.nextInt();
            if (choice != 1) {
                break;
            }
        }
    }


    @Override
    public void changeMode() {

        int currentMode = 0;

        while (true) {
            System.out.println("Current mode: " + MODES[currentMode] + " | Current temperature: " + this.temperature);


            System.out.println("Select a mode: ");
            for (int i = 0; i < MODES.length; i++)
                System.out.println(i + ": " + MODES[i]);

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Exiting mode change...");
                sc.next();
                break;
            }

            int selectedMode = sc.nextInt();
            if (selectedMode >= 0 && selectedMode < MODES.length) {
                currentMode = selectedMode;
                int targetTemperature = MODE_TEMPERATURES[currentMode];
                if (this.temperature < targetTemperature)
                    while (this.temperature < targetTemperature) this.temperature += TEMPERATURE_INCREMENT;
                else if (this.temperature > targetTemperature)
                    while (this.temperature > targetTemperature) this.temperature -= TEMPERATURE_DECREMENT;

                System.out.println("Mode changed to: " + MODES[currentMode] + " | Temperature set to: " + this.temperature);

                if (selectedMode == 0) this.turnOffDevice();
                else this.turnOnDevice();

            } else System.out.println("Invalid mode selection. Please try again.");


            System.out.println("Do you want to change the mode again? Enter 1 for Yes, 2 for No:");
            if (!sc.hasNextInt() || sc.nextInt() != 1) break;

        }
    }

}
