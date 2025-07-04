package org.example.surcharge;

public class nightSurcharge implements surchargeStrategy {
    @Override
    public double getSurcharge(){
        return 50;
    }
}
