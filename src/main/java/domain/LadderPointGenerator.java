package domain;

import java.util.concurrent.ThreadLocalRandom;

public class LadderPointGenerator {
    public static boolean generatePoint() {
        // 0 - false. 1,2,3 - true.
        if (ThreadLocalRandom.current().nextInt(3) > 0) {
            return true;
        }
        return false;
    }
}
