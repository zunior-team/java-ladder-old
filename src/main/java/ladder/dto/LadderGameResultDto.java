package ladder.dto;

import ladder.domain.*;

public class LadderGameResultDto {
    private final Players players;
    private final Lines lines;
    private final Results results;

    public LadderGameResultDto(LadderGame ladderGame) {
        this.players = ladderGame.players();
        this.lines = ladderGame.lines();
        this.results = ladderGame.results();
    }

    public Players getPlayers() {
        return players;
    }

    public Lines getLines() {
        return lines;
    }

    public Results getResults() {
        return results;
    }

}
