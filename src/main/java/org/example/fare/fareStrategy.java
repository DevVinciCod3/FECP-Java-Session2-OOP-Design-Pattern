package org.example.fare;

public interface fareStrategy {
    double getBaseFare();
    double getDistanceCost(double distance);
    double getDurationCost(double time);
    double calculateFare(double distance, double time);
}
