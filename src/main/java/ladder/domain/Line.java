package ladder.domain;

import java.util.ArrayList;
import java.util.Random;

public class Line {

    private ArrayList<Boolean> points = new ArrayList<>();

    Line(int colSize) {
        drawLine(colSize);
    }

    private void drawLine(int colSize) {
        Random random = new Random();
        for (int i = 0; i < colSize; i++) {
            points.add(compareWithPreIndex(i, random.nextBoolean()));
        }
    }

    private boolean compareWithPreIndex(int currentPoint, boolean checker) {
        Random random = new Random();
        if (currentPoint == 0) {
            return checker;
        }
        return !points.get(currentPoint - 1) && random.nextBoolean();
    }

    public ArrayList<Boolean> getLine() {
        return this.points;
    }
}


