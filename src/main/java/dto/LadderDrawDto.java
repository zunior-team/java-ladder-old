package dto;

import model.ladder.Ladder;
import model.player.Players;

import java.util.List;

public class LadderDrawDto {
    private final List<String> names;
    private final List<List<String>> lines;
    private final List<String> scores;

    public LadderDrawDto(Players players, Ladder ladder) {
        names = players.getNames();
        lines = ladder.getLines();
        scores = ladder.getScores();
    }

    public List<String> getNames() {
        return names;
    }

    public List<List<String>> getLines(){
        return lines;
    }

    public List<String> getScores() {
        return scores;
    }
}
