package org.example.fare;

public class standardFareStrategy implements fareStrategy {

    public double getBaseFare(){
        return 50;
    }

    public double getDistanceCost(double distance){
        return distance * 10;
    }

    public double getDurationCost(double time){
        return time * 2;
    }

    public double calculateFare(double distance, double time){
        return getBaseFare() + getDistanceCost(distance) + getDurationCost(time);
    }
}
