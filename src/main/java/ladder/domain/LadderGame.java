package ladder.domain;

import ladder.dto.LadderInfo;

import java.util.Objects;
import java.util.Random;

public class LadderGame {
    public static final int MINIMUM_MAX_HEIGHT = 1;
    private final Lines lines;
    private final Players players;
    private final Results results;

    private LadderGame(LadderInfo ladderInfo) {
        final int maxHeight = ladderInfo.getMaxHeight();
        final Players players = ladderInfo.getPlayers();
        final Results results = ladderInfo.getResults();

        Objects.requireNonNull(players);
        Objects.requireNonNull(results);
        validateMaxHeight(maxHeight);

        this.players = players;
        this.results = results;

        final int countOfPerson = this.players.size();
        final PointGenerator pointGenerator = new RandomPointGenerator(new Random());

        this.lines = Lines.of(countOfPerson, pointGenerator);
    }


    private void validateMaxHeight(int maxHeight) {
        if (maxHeight < MINIMUM_MAX_HEIGHT) {
            throw new IllegalArgumentException("최대 사다리 높이는 " + MINIMUM_MAX_HEIGHT + " 이상 이어야 합니다.");
        }
    }

    public static LadderGame of(LadderInfo ladderInfo) {
        return new LadderGame(ladderInfo);
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
