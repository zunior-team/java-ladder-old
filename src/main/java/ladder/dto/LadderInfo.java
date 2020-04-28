package ladder.dto;

import ladder.domain.LadderDifficulty;
import ladder.domain.Players;
import ladder.domain.Results;

public class LadderInfo {
    private final Players players;
    private final LadderDifficulty ladderDifficulty;
    private final Results results;

    public LadderInfo(Players players, LadderDifficulty ladderDifficulty, Results results) {
        this.players = players;
        this.ladderDifficulty = ladderDifficulty;
        this.results = results;
    }

    public Players getPlayers() {
        return players;
    }

    public LadderDifficulty getLadderDifficulty() {
        return ladderDifficulty;
    }

    public Results getResults() {
        return results;
    }
}
