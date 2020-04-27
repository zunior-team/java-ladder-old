package ladder.dto;

import ladder.domain.Players;
import ladder.domain.Results;

public class LadderInfo {
    private final Players players;
    private final int maxHeight;
    private final Results results;

    public LadderInfo(Players players, int maxHeight, Results results) {
        this.players = players;
        this.maxHeight = maxHeight;
        this.results = results;
    }

    public Players getPlayers() {
        return players;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public Results getResults() {
        return results;
    }
}
