package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static ladder.domain.LadderGame.MINIMUM_PARTICIPANTS;

public class Line {
    private List<Boolean> points = new ArrayList<>();
    private Random random;

    private Line(int countOfPerson, Random random) {
        assert random != null;
        validateCountOfPerson(countOfPerson);

        this.random = random;
        random.setSeed(System.nanoTime());

        initPoints(countOfPerson, random);
    }

    private void initPoints(int countOfPerson, Random random) {
        points.add(random.nextBoolean());
        while (points.size() != countOfPerson - 1) {
            points.add(nextRandomValue());
        }
    }

    public static Line of(int countOfPerson, Random random) {
        return new Line(countOfPerson, random);
    }

    public List<Boolean> points() {
        return Collections.unmodifiableList(points);
    }

    private void validateCountOfPerson(int countOfPerson) {
        if (countOfPerson < MINIMUM_PARTICIPANTS) {
            throw new IllegalArgumentException("참여자 수는 최소 " + MINIMUM_PARTICIPANTS + "명 이상이어야 합니다.");
        }
    }

    private boolean nextRandomValue() {
        final int lastIndex = points.size() - 1;
        if (points.get(lastIndex)) {
            return false;
        }
        return random.nextBoolean();
    }
}
