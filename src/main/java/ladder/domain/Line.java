package ladder.domain;

import java.util.*;

import static ladder.domain.LadderGame.MINIMUM_PARTICIPANTS;

public class Line {
    private List<Boolean> points;

    private Line(int countOfPerson, PointGenerator pointGenerator) {
        Objects.requireNonNull(pointGenerator, "PointGenerator can not be null");
        validateCountOfPerson(countOfPerson);

        points = pointGenerator.generate(countOfPerson);
    }


    public static Line of(int countOfPerson, PointGenerator pointGenerator) {
        return new Line(countOfPerson, pointGenerator);
    }

    public List<Boolean> points() {
        return Collections.unmodifiableList(points);
    }

    private void validateCountOfPerson(int countOfPerson) {
        if (countOfPerson < MINIMUM_PARTICIPANTS) {
            throw new IllegalArgumentException("참여자 수는 최소 " + MINIMUM_PARTICIPANTS + "명 이상이어야 합니다.");
        }
    }


}
