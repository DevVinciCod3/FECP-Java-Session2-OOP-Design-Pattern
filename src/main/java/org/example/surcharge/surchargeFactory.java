package org.example.surcharge;

import java.time.LocalTime;
import java.util.Random;

public class surchargeFactory {
    public static surchargeStrategy getSurchargeStrategy(){

        Random random = new Random();
        int hour = random.nextInt(24);   // 0 - 23
        int minute = random.nextInt(60); // 0 - 59
        int second = random.nextInt(60); // 0 - 59

        LocalTime randomTime = LocalTime.of(hour, minute, second);

        if (randomTime.getHour() < 6){
            return new normalSurcharge();
        }
        else {
            return new nightSurcharge();
        }
    }

}
