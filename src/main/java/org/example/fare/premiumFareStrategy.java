package org.example.fare;

public class premiumFareStrategy implements fareStrategy {

    public double getBaseFare(){
        return 100;
    }

    public double getDistanceCost(double distance){
        return distance * 20;
    }

    public double getDurationCost(double time){
        return time * 5;
    }

    public double calculateFare(double distance, double time){
        return getBaseFare() + getDistanceCost(distance) + getDurationCost(time);
    }
}
