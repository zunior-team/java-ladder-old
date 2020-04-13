package ladder.domain;

import ladder.Results;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LadderGame {
    public static final int MINIMUM_MAX_HEIGHT = 1;
    private List<Line> lines;
    private Players players;
    private Results results;

    private LadderGame(Players players, int maxHeight, Results results) {
        Objects.requireNonNull(players);
        Objects.requireNonNull(results);
        validateMaxHeight(maxHeight);

        this.players = players;
        this.results = results;

        final int countOfPerson = players.size();
        final PointGenerator pointGenerator = new RandomPointGenerator(new Random());

        this.lines = IntStream.range(0, countOfPerson)
                .mapToObj(index -> Line.of(countOfPerson, pointGenerator))
                .collect(collectingAndThen(toList(),
                        Collections::unmodifiableList));
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    private void validateMaxHeight(int maxHeight) {
        if (maxHeight < MINIMUM_MAX_HEIGHT) {
            throw new IllegalArgumentException("최대 사다리 높이는 " + MINIMUM_MAX_HEIGHT + " 이상 이어야 합니다.");
        }
    }

    public static LadderGame of(Players players, int maxHeight, Results results) {
        return new LadderGame(players, maxHeight, results);
    }

}
