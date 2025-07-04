package org.example;

import org.example.fare.fareStrategy;
import org.example.surcharge.surchargeStrategy;

public class rideFareCalculator {
    private final fareStrategy fareStrategy;
    private final surchargeStrategy surchargeStrategy;

    public rideFareCalculator(fareStrategy fareStrategy, surchargeStrategy surchargeStrategy) {
        this.fareStrategy = fareStrategy;
        this.surchargeStrategy = surchargeStrategy;
    }

    public double calculateFare(double distance, double time) {
        double baseFare = fareStrategy.calculateFare(distance, time);
        double surcharge = surchargeStrategy.getSurcharge();
        return baseFare + surcharge;
    }
}
