package laddergame;

import static laddergame.Util.generateRandomNumber;

public class Ladder {
    private boolean[] lines;

    public Ladder(int horizontal) {
        this.lines = new boolean[horizontal - 1];
    }

    public boolean[] getLines() {
        return this.lines;
    }

    public void makeLine() {
        boolean preResult = false;

        for(int i = 0; i < lines.length; i++) {
            preResult = isMakeLine(i, preResult);
        }
    }

    private boolean isMakeLine(int i, boolean preResult) {
        boolean result = false;
        int randomNumber = generateRandomNumber();

        if ((randomNumber % 2 == 0) && (preResult != true)) {
            result = true;
        }
        lines[i] = result;

        return result;
    }
}
