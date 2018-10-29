package ladder.domain;

import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    private ArrayList<Boolean> value = new ArrayList<>();
    private Random r = new Random();
    private static final int MINUS = 2;

    public Ladder(boolean value) {
        this.value.add(value);
    }

    public ArrayList<Boolean> getValue() {
        return value;
    }

    public ArrayList<Boolean> randomInput(String[] name) {
        for (int i = 0; i < name.length - MINUS; i++) {
            sizeInput(i);
        }
        return value;
    }

    private void sizeInput(int i) {
        if (value.get(i)) {
            value.add(false);
            return;
        }
        value.add(r.nextBoolean());
    }
}
