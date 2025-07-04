package org.example;
import java.util.*;
public class Main {
    private static boolean isRunning = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (isRunning) {
            System.out.println("\n=== G-Ride Booking System ===");
            System.out.println("1. Book a ride");
            System.out.println("2. Calculate Fare");
            System.out.println("3. View Receipt ");
            System.out.println("4. Exit");
            System.out.print("Enter choice (1-4): ");

            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> bookARide(sc);
                case 2 -> calculateFare(sc);
                case 3 -> viewReceipt();
                case 4 -> {
                    System.out.println("=== Thank You!! ===");
                    isRunning = false;
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void bookARide(Scanner sc) {
        System.out.print("Enter Ride Type (Standard/Premium): ");
        String rideType = sc.nextLine();
        System.out.print("Enter Distance (km): ");
        int distance = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Duration (mins): ");
        int duration = sc.nextInt();
        sc.nextLine();
        System.out.println("Ride Booked Successfully!");
    }

    private static void calculateFare(Scanner sc) {
        System.out.print("Fare Type (Normal / Night): ");
        String fareType = sc.nextLine();

        System.out.println("Base Fare: ");
        System.out.println("Distance Cost: ");
        System.out.println("Duration Cost: ");
        System.out.println("Surcharge (Night): ");
        System.out.println("Total Fare: ");

    }

    private static void viewReceipt() {
        System.out.println("=== Receipt ===");
        System.out.println("Ride Type: ");
        System.out.println("Distance: ");
        System.out.println("Duration: ");
        System.out.println("Total Fare: ");
    }
}
