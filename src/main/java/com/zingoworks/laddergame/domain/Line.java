package com.zingoworks.laddergame.domain;

import java.util.ArrayList;
import java.util.Random;

public class Line {
    public ArrayList<Boolean> rung = new ArrayList<>();

    Random random = new Random();

    public Line(int numOfUser) {
        for (int i = 0; i < numOfUser - 1; i++) {
            rung.add(random.nextBoolean());
        }
        makeUnconnectedLine();
    }

    public Boolean getRungExistence(int i) {
        return rung.get(i);
    }

    public int getLineLength() {
        return rung.size();
    }

    private void makeUnconnectedLine() {
        for (int i = 0; i < rung.size() - 1; i++) {
            makePointDiscontinuously(i);
        }
    }

    private void makePointDiscontinuously(int i) {
        if ((rung.get(i) == true) && (rung.get(i + 1) == true)) {
            rung.set(i + 1, false);
        }
    }
}
