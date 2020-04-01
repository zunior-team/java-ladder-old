package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static ladder.domain.LadderGame.MINIMUM_PARTICIPANTS;

public class Line {
    private List<Boolean> points = new ArrayList<>();
    private Random random = new Random(System.nanoTime());

    private Line(int countOfPerson) {
        random.setSeed(System.nanoTime());
        validateCountOfPerson(countOfPerson);
        points.add(random.nextBoolean());
        while (points.size() != countOfPerson - 1) {
            addRandomValue();
        }
    }

    public List<Boolean> points() {
        return Collections.unmodifiableList(points);
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
