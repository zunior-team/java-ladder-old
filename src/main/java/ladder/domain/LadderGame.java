package ladder.domain;

import java.util.Objects;
import java.util.Random;

public class LadderGame {
    public static final int MINIMUM_MAX_HEIGHT = 1;
    private final Lines lines;
    private final Players players;
    private final Results results;

    private LadderGame(Players players, int maxHeight, Results results) {
        Objects.requireNonNull(players);
        Objects.requireNonNull(results);
        validateMaxHeight(maxHeight);

        this.players = players;
        this.results = results;

        final int countOfPerson = players.size();
        final PointGenerator pointGenerator = new RandomPointGenerator(new Random());

        this.lines = Lines.of(countOfPerson, pointGenerator);
    }


    private void validateMaxHeight(int maxHeight) {
        if (maxHeight < MINIMUM_MAX_HEIGHT) {
            throw new IllegalArgumentException("최대 사다리 높이는 " + MINIMUM_MAX_HEIGHT + " 이상 이어야 합니다.");
        }
    }

    public static LadderGame of(Players players, int maxHeight, Results results) {
        return new LadderGame(players, maxHeight, results);
    }


    public Lines lines() {
        return lines;
    }

    public Players players() {
        return players;
    }


    public Results results() {
        return results;
    }

    public String findResult(Player player) {
        int startPoint = players.indexOf(player);
        int endPoint = lines.findEndPoint(startPoint);

        return results.findByIndex(endPoint);
    }


}
