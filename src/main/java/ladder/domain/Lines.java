package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Lines {
    private final List<Line> lines;

    private Lines(int countOfPerson, PointGenerator pointGenerator) {
        Objects.requireNonNull(pointGenerator, "pointGenerator can not be null");
        this.lines = IntStream.range(0, countOfPerson)
                .mapToObj(index -> Line.of(countOfPerson, pointGenerator))
                .collect(collectingAndThen(toList(),
                        Collections::unmodifiableList));
    }

    public static Lines of(int countOfPerson, PointGenerator pointGenerator) {
        return new Lines(countOfPerson, pointGenerator);
    }

    public int findEndPoint(int startPoint) {
        return lines.stream()
                .reduce(startPoint, this::checkNextPoint,
                        (x, y) -> {
                            throw new RuntimeException("병렬처리를 지원하지 않습니다");
                        });
    }

    private int checkNextPoint(int currentPosition, Line line) {
        if (line.hasRightBridge(currentPosition)) {
            return currentPosition + 1;
        }

        if (line.hasLeftBridge(currentPosition)) {
            return currentPosition - 1;
        }
        return currentPosition;
    }

    public Stream<Line> stream() {
        return this.lines.stream();
    }
}
