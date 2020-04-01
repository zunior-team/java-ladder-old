package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ladder.domain.LadderGame.MINIMUM_PARTICIPANTS;

public class Line {
    private List<Boolean> points = new ArrayList<>();
    private Random random = new Random(System.currentTimeMillis());

    private Line(int countOfPerson) {
        validateCountOfPerson(countOfPerson);
        points.add(random.nextBoolean());
        while (points.size() != countOfPerson) {
            addRandomValue();
        }
    }

    private void validateCountOfPerson(int countOfPerson) {
        if (countOfPerson < MINIMUM_PARTICIPANTS) {
            throw new IllegalArgumentException("참여자 수는 최소 " + MINIMUM_PARTICIPANTS + "명 이상이어야 합니다.");
        }
    }

    private void addRandomValue() {
        final int lastIndex = points.size() - 1;
        if (points.get(lastIndex)) {
            points.add(false);
            return;
        }
        points.add(random.nextBoolean());
    }

    public static Line of(int countOfPerson) {
        return new Line(countOfPerson);
    }
}
