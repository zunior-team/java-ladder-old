package laddergame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    static final int RANDOM_MAX_NUM = 10;
    static final int IS_TRUE = 5;

    public static boolean isTrue() {
        Random random = new Random();
        int randomNum = random.nextInt(RANDOM_MAX_NUM);
        return randomNum >= IS_TRUE;
    }

    // isException 의 결과에 따라 exception 을 변경해 구현
    public static ArrayList<Boolean> getOneLine(int person) {
        ArrayList<Boolean> ladder = new ArrayList<>();
        boolean exception = false;
        for (int i = 0; i < person - 1; i++) {
            exception = isException(ladder, exception);
        }
        return ladder;
    }

    // exception 이 false 면 isTrue 호출 isTrue 를 리턴 exception 이 true 면 false 리턴
    private static boolean isException(ArrayList<Boolean> ladder, boolean exception) {
        if (exception == false) {
            boolean addBoolean = isTrue();
            ladder.add(addBoolean);
            return addBoolean;
        }
        ladder.add(false);
        return false;
    }

    // ArrayList 와 List 의 관계
    public static List<ArrayList> getHeight(int person, int height) {
        List<ArrayList> ladders = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladders.add(getOneLine(person));
        }
        return ladders;
    }
}
