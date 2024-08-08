package LLD.SnakeAndLadder.SnakeAndLadder;

import java.util.Random;
import java.util.UUID;

class Utils {

    private static final Random random = new Random();

    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    // Both inclusive
    public static int generateRandomNumber(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}
