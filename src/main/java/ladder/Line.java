package ladder;

import java.util.ArrayList;
import java.util.Random;

public class Line {
    private ArrayList<Boolean> points = new ArrayList<>();

    public ArrayList<Boolean> getPoints() {
        return points;
    }

    public ArrayList<Boolean> oneLine(int people) {
        points.add(false);
        for (int i = 1; i < people; i++) {
            boolean random = random();
            points.add(checkNextLine(i, random));
        }
        return points;
    }

    public boolean checkNextLine(int num, boolean random) {
        if (points.get(num - 1)) {
            return false;
        }
        return random;
    }

    public boolean random() {
        Random random = new Random();
        return random.nextBoolean();
    }
}