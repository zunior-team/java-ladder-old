package ladder.domain;

import java.util.ArrayList;
import java.util.Random;

public class Movement {
    private ArrayList<ArrayList<Boolean>> userCount = new ArrayList<>();

    public ArrayList<Boolean> size(int input) {
        Random r = new Random();
        ArrayList<Boolean> userInput = new ArrayList<>();
        for (int j = 0; j < input - 1; j++) {
            userInput.add(r.nextBoolean());
        }
        return userInput;
    }

    public ArrayList<ArrayList<Boolean>> userRepetition(int input, int height) {
        for (int i = 0; i < height; i++) {
            userCount.add(size(input));
        }
        return userCount;
    }
}