package com.bm.homeautomation;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int password = 8408;
        System.out.println("Shree Ganesh...! :>");
        System.out.println("Get inside house...!");
        System.out.println("Enter your Password : ");
        int count = 0;
        while (count != 3) {
            int userPass = sc.nextInt();
            if (password == userPass) {
                System.out.println("Passwod validated");

                HomeAutomation.startAutomation();
                break;

            } else {
                System.out.println("Invalid password..\nTry again.. re-try count : " + (count + 1));
                count++;
            }
        }
        if (count == 3) {
            System.out.println("Faild to login in 3 trails..!");
        } else {
            System.out.println("Good Bye...!");
        }


    }


}
