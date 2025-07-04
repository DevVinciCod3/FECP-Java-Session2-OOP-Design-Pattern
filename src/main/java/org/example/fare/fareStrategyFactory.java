package org.example.fare;

public class fareStrategyFactory {
    public static fareStrategy getFareStrategy(String type) {
        if (type.equalsIgnoreCase("premium")) {
            return new premiumFareStrategy();
        } else {
            return new standardFareStrategy();
        }
    }
}
