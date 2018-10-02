package ladder;

import java.util.*;

public class Line {
    private ArrayList<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        Random rnd = new Random();
        points.add(rnd.nextBoolean());
        for (int i = 1; i < countOfPerson - 1; i++) {                    // 페달 수는 사람수보다 1보다 적으므로 1개를 뺏다.
            points.add(points.get(i - 1) ? false : rnd.nextBoolean());    // 페달 2번째(=인덱스 1)부터는 이전의 값에 따라 값이 달라진다.
        }
        points.add(false);
    }

    public int move(int position) {
        if (points.get(position)) {
            position++;
            return position;
        }
        if (position > 0 && points.get(position - 1))
            position--;
        return position;
    }

    public ArrayList<Boolean> getPoints() {
        return points;
    }
}
