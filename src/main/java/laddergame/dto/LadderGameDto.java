package laddergame.dto;

import laddergame.domain.Ladder;

import java.util.List;

public class LadderGameDto {
    private List<String> names;
    private List<String> results;
    private Ladder ladder;
    private List<String> finalNamePosition;

    public LadderGameDto(List<String> names, List<String> results, Ladder ladder, List<String> finalNamePosition) {
        this.names = names;
        this.results = results;
        this.ladder = ladder;
        this.finalNamePosition = finalNamePosition;
    }

    public List<String> getNames() {
        return names;
    }

    public List<String> getResults() {
        return results;
    }

    public Ladder getLadder(){
        return ladder;
    }

    public List<String> getFinalNamePosition() {
        return finalNamePosition;
    }
}
