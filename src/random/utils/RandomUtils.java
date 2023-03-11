package random.utils;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Random;


public class RandomUtils {

    public static final String RANDOM_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    private static final Random random = new Random(LocalDateTime.now().getNano());

    public static Integer getInt() {
        return random.nextInt(200 - 1 + 1) + 1;
    }


    public static BigDecimal getBigDecimal() {
        double v = 100 * random.nextDouble();
        return BigDecimal.valueOf(v);


    }

    public BigDecimal randomIntegerBigDecimal(int min, int max) {
        return BigDecimal.valueOf(inRange(min, max));
    }


    public static Instant randomInstantBetween(LocalDate start, LocalDate end) {
        return randomInstantBetween(
                start.atStartOfDay(ZoneId.systemDefault()).toInstant(),
                end.atStartOfDay(ZoneId.systemDefault()).toInstant()
        );
    }

    public static Instant randomInstantBetween(Instant start, Instant end) {
        long minSec = start.getEpochSecond();
        long maxSec = end.getEpochSecond();
        long callSec = (long) (randomDouble() * (maxSec - minSec) + minSec);
        return Instant.ofEpochSecond(callSec);
    }

    public static double randomDouble() {
        return random.nextDouble();
    }


    public static String randomString(int length) {
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = RANDOM_CHARS.charAt(inRange(0, RANDOM_CHARS.length()));
        }
        return String.valueOf(chars);
    }

    private static int inRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }


}
