package dto;

import model.ladder.Ladder;
import model.player.Players;

import java.util.List;

public class LadderResultDto {
    private final List<String> names;
    private final List<List<String>> lines;

    public LadderResultDto(Players players, Ladder ladder) {
        names = players.toNames();
        lines = ladder.toLines();
    }

    public List<String> getNames() {
        return names;
    }

    public List<List<String>> getLines(){
        return lines;
    }
}
