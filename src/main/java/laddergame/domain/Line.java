package laddergame.domain;

import java.util.ArrayList;
import java.util.Random;

public class Line {
    private static final int RANDOM_MAX_NUM = 10;
    private static final int IS_TRUE = 5;

    private ArrayList<Boolean> point;

    public Line(int countOfPerson) {
        this.point = makeLine(countOfPerson);
    }

    public static ArrayList<Boolean> makeLine(int person) {
        ArrayList<Boolean> line = new ArrayList<>();
        boolean exception = false;
        for (int i = 0; i < person - 1; i++) {
            exception = isException(line, exception);
        }
        return line;
    }

    // exception 이 false 면 isTrue 호출 isTrue 를 리턴 exception 이 true 면 false 리턴
    private static boolean isException(ArrayList<Boolean> ladder, boolean exception) {
        if (!exception) {
            boolean addBoolean = isTrue();
            ladder.add(addBoolean);
            return addBoolean;
        }
        ladder.add(false);
        return false;
    }

    public static boolean isTrue() {
        Random random = new Random();
        int randomNum = random.nextInt(RANDOM_MAX_NUM);
        return randomNum >= IS_TRUE;
    }

    public ArrayList<Boolean> getLine() {
        return this.point;
    }
}
