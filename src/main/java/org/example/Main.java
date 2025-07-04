package org.example;
import org.example.fare.*;
import org.example.surcharge.*;
import java.util.Scanner;

public class Main {
    private static boolean isRunning = true;
    private static String currentRideType;
    private static double currentDistance;
    private static double currentDuration;
    private static String currentFareType;
    private static double lastFare;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (isRunning) {
            System.out.println("\n=== G-Ride Booking System ===");
            System.out.println("1. Book a ride");
            System.out.println("2. Calculate Fare");
            System.out.println("3. View Receipt ");
            System.out.println("4. Exit");
            System.out.print("Enter choice (1-4): ");

            String input = sc.nextLine();
            int option;

            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number from 1 to 4.");
                continue;
            }

            switch (option) {
                case 1 -> bookARide(sc);
                case 2 -> calculateFare(sc);
                case 3 -> viewReceipt();
                case 4 -> {
                    System.out.println("=== Thank You!! ===");
                    isRunning = false;
                }
                default -> System.out.println("Invalid choice. Please enter 1, 2, 3, or 4.");
            }
        }
    }

    private static void bookARide(Scanner sc) {
        while (true) {
            System.out.print("Enter Ride Type (Standard/Premium): ");
            currentRideType = sc.nextLine().trim();
            if (currentRideType.equalsIgnoreCase("Standard") || currentRideType.equalsIgnoreCase("Premium")) {
                break;
            } else {
                System.out.println("Invalid Ride Type. Please enter 'Standard' or 'Premium'.");
            }
        }
        while (true) {
            System.out.print("Enter Distance (km): ");
            String input = sc.nextLine();
            try {
                currentDistance = Double.parseDouble(input);
                if (currentDistance < 0) {
                    System.out.println("Distance cannot be negative.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        while (true) {
            System.out.print("Enter Duration (mins): ");
            String input = sc.nextLine();
            try {
                currentDuration = Double.parseDouble(input);
                if (currentDuration < 0) {
                    System.out.println("Duration cannot be negative.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        System.out.println("Ride Booked Successfully!");
    }
    private static void calculateFare(Scanner sc) {
        if (currentRideType == null) {
            System.out.println("No ride booked yet. Please book a ride first.");
            return;
        }
        while (true) {
            System.out.print("Fare Type (Normal/Night): ");
            currentFareType = sc.nextLine().trim();
            if (currentFareType.equalsIgnoreCase("Normal") || currentFareType.equalsIgnoreCase("Night")) {
                break;
            } else {
                System.out.println("Invalid Fare Type. Please enter 'Normal' or 'Night'.");
            }
        }
        fareStrategy fare;
        if (currentRideType.equalsIgnoreCase("Standard")) {
            fare = new standardFareStrategy();
        } else if (currentRideType.equalsIgnoreCase("Premium")) {
            fare = new premiumFareStrategy();
        } else {
            System.out.println("Invalid Ride Type.");
            return;
        }
        surchargeStrategy surcharge;
        if (currentFareType.equalsIgnoreCase("Night")) {
            surcharge = new nightSurcharge();
        } else {
            surcharge = new normalSurcharge();
        }
        rideFareCalculator calculator = new rideFareCalculator(fare, surcharge);
        lastFare = calculator.calculateFare(currentDistance, currentDuration);
        double distanceCost = fare.getDistanceCost(currentDistance);
        double durationCost = fare.getDurationCost(currentDuration);
        double baseFare = distanceCost + durationCost;
        double surchargeAmount = surcharge.getSurcharge();

        System.out.println("Base Fare: " + baseFare);
        System.out.println("Distance Cost: " + distanceCost);
        System.out.println("Duration Cost: " + durationCost);
        System.out.println("Surcharge: " + surchargeAmount);
        System.out.println("Total Fare: " + lastFare);

    }
    private static void viewReceipt() {
        if (currentRideType == null || currentFareType == null) {
            System.out.println("No complete fare data. Book and calculate fare first.");
            return;
        }
        System.out.println("=== Receipt ===");
        System.out.println("Ride Type: " + currentRideType);
        System.out.println("Distance: " + currentDistance + " km");
        System.out.println("Duration: " + currentDuration + " mins");
        System.out.println("Fare Type: " + currentFareType);
        System.out.println("Total Fare: " + lastFare);
    }
}
