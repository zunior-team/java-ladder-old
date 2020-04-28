package ladder.domain;

import java.util.List;
import java.util.Objects;

import static ladder.domain.Players.MINIMUM_PARTICIPANTS;


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

    public boolean hasRightBridge(int index) {
        if (!isValid(index)) {
            return false;
        }
        return points.get(index);
    }

    public boolean hasLeftBridge(int index) {
        final int leftIndex = index - 1;
        if (!isValid(leftIndex)) {
            return false;
        }
        return points.get(leftIndex);
    }

    private boolean isValid(int index) {
        return index >= 0 && index < points.size();
    }

    public int playerCount() {
        return points.size();
    }

    private void validateCountOfPerson(int countOfPerson) {
        if (countOfPerson < MINIMUM_PARTICIPANTS) {
            throw new IllegalArgumentException("참여자 수는 최소 " + MINIMUM_PARTICIPANTS + "명 이상이어야 합니다.");
        }
    }


}
