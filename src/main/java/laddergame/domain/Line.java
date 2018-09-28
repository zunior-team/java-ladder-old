package laddergame.domain;

import laddergame.util.MyRandom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private List<Boolean> footholds;

    Line(int width) {
        footholds = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            footholds.add(false);
        }
    }

    public boolean get(int i) {
        return footholds.get(i);
    }

    void makeLine() {
        firstFootholdSet();
        for (int i = 1; i < footholds.size(); i++) {
            extraFootholdSet(i);
        }
    }

    private void firstFootholdSet() {
        randomize(0);
    }

    private void extraFootholdSet(int index){
        if (!hasPrevFoothold(index)) {
            randomize(index);
        }
    }

    private void randomize(int index) {
        set(index, MyRandom.nextBoolean());
    }

    private boolean hasPrevFoothold(int index) {
        return footholds.get(index - 1);
    }

    public int size() {
        return footholds.size();
    }

    void set(int index, boolean value) {
        footholds.set(index, value);
    }

    void swap(List<String> names) {
        for (int i = 0; i < footholds.size(); i++) {
            if(footholds.get(i)) {
                Collections.swap(names, i, i + 1);
            }
        }
    }
}
