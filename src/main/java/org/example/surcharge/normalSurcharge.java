package org.example.surcharge;

public class normalSurcharge implements surchargeStrategy {
    @Override
    public double getSurcharge(){
        return 0;
    }
}
