package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class LadderLine {
    private ArrayList<Boolean> points = new ArrayList<>();

    LadderLine(int countOfPersons) {
        this.getLine(countOfPersons);
    }

    public ArrayList<Boolean> getLine() {
        return this.points;
    }

    private void getLine(int countOfPersons) {
        Boolean prevBridge = false;
        for (int i = 0; i < countOfPersons-1; i++) {
            int randomValue = makeRandomValue();
            prevBridge = addBridge(randomValue, prevBridge);
            points.add(prevBridge);
        }
        System.out.println(points.toString());
    }

    public Boolean addBridge(int randomValue, Boolean prevBridge) {
        if ((randomValue == 1) && (prevBridge == false)) {
            return true;
        }
        return false;
    }

    public int makeRandomValue() {
        Random random = new Random();
        return random.nextInt(2);
    }
}