package org.example.surcharge;

import java.time.LocalTime;
import java.util.Random;

public class surchargeFactory {
    public static LocalTime generatedTime;

    public static surchargeStrategy getSurchargeStrategy() {
        Random random = new Random();
        int hour = random.nextInt(24);
        int minute = random.nextInt(60);
        int second = random.nextInt(60);

        generatedTime = LocalTime.of(hour, minute, second);

        LocalTime nightStart = LocalTime.of(17, 59, 59);
        LocalTime nightEnd = LocalTime.of(6, 0, 0);

        if (generatedTime.isAfter(nightStart) || generatedTime.isBefore(nightEnd)) {
            return new nightSurcharge();
        } else {
            return new normalSurcharge();
        }
    }
}

