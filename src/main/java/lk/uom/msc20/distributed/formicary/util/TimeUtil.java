package lk.uom.msc20.distributed.formicary.util;

import java.time.Duration;
import java.time.Instant;

public class TimeUtil {
    private TimeUtil() {
    }

    public static String upTime(Instant startedTime) {
        Duration timeElapsed = Duration.between(startedTime, Instant.now());
        long seconds = timeElapsed.toMillis() / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;
        return days + ":" + hours % 24 + ":" + minutes % 60 + ":" + seconds % 60;
    }
}
