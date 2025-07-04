package org.example;

import org.example.fare.*;
import org.example.surcharge.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RideFareCalculatorTest {

    @Test
    void testStandardNormalFare() {
        fareStrategy fare = new standardFareStrategy();
        surchargeStrategy surcharge = new normalSurcharge();
        rideFareCalculator calc = new rideFareCalculator(fare, surcharge);

        double result = calc.calculateFare(10, 15);
        double expected = fare.calculateFare(10, 15) + surcharge.getSurcharge();

        assertEquals(expected, result, 0.01);
    }

    @Test
    void testStandardNightFare(){
        fareStrategy fare = new standardFareStrategy();
        surchargeStrategy surcharge = new nightSurcharge();
        rideFareCalculator calc = new rideFareCalculator(fare, surcharge);

        double result = calc.calculateFare(6, 50);
        double expected = fare.calculateFare(6, 50) + surcharge.getSurcharge();

        assertEquals(expected, result, 0.01);
    }

    @Test
    void testPremiumNormalFare() {
        fareStrategy fare = new premiumFareStrategy();
        surchargeStrategy surcharge = new normalSurcharge();
        rideFareCalculator calc = new rideFareCalculator(fare, surcharge);

        double result = calc.calculateFare(7, 30);
        double expected = fare.calculateFare(7, 30) + surcharge.getSurcharge();

        assertEquals(expected, result, 0.01);
    }


    @Test
    void testPremiumNightFare() {
        fareStrategy fare = new premiumFareStrategy();
        surchargeStrategy surcharge = new nightSurcharge();
        rideFareCalculator calc = new rideFareCalculator(fare, surcharge);

        double result = calc.calculateFare(8, 12);
        double expected = fare.calculateFare(8, 12) + surcharge.getSurcharge();

        assertEquals(expected, result, 0.01);
    }



    @Test
    void testZeroDistanceAndDuration() {
        fareStrategy fare = new standardFareStrategy();
        surchargeStrategy surcharge = new normalSurcharge();
        rideFareCalculator calc = new rideFareCalculator(fare, surcharge);

        double result = calc.calculateFare(0, 0);
        double expected = fare.calculateFare(0, 0) + surcharge.getSurcharge();

        assertEquals(expected, result, 0.01);
    }

    @Test
    void testNegativeDistanceShouldStillCalculate() {
        fareStrategy fare = new premiumFareStrategy();
        surchargeStrategy surcharge = new normalSurcharge();
        rideFareCalculator calc = new rideFareCalculator(fare, surcharge);

        double result = calc.calculateFare(-5, 10);
        double expected = fare.calculateFare(-5, 10) + surcharge.getSurcharge();

        assertEquals(expected, result, 0.01);
    }
}