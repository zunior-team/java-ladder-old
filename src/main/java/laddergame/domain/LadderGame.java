package laddergame.domain;

import laddergame.dto.LadderGameDto;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private List<String> names;
    private List<String> results;
    private Ladder ladder;

    public LadderGame(List<String> names, List<String> results, int height) {
        this.names = names;
        this.results = results;
        initLadder(height);
    }

    private void initLadder(int height) {
        int numberOfFoothold = names.size() - 1;
        ladder = new Ladder(numberOfFoothold, height);
    }

    public void makeLadder() {
        ladder.makeLadder();
    }

    public LadderGameDto getLadderGameResultDto() {
        return new LadderGameDto(names, results, ladder, getFinalNamePosition());
    }

    private List<String> getFinalNamePosition() {
        List<String> finalNamePosition = new ArrayList<>(names);
        ladder.getFinalNamePosition(finalNamePosition);
        return finalNamePosition;
    }
}
