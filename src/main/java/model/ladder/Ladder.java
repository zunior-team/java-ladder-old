package model.ladder;

import dto.LadderCreateDto;
import exception.LadderCreateException;
import model.player.Players;
import model.result.PlayerResult;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final Scores scores;
    private final Players players;
    private final List<Line> lines;

    private Ladder(LadderCreateDto createDto){
        validate(createDto);
        this.scores = createDto.getScores();
        this.players = createDto.getPlayers();
        this.lines = IntStream.rangeClosed(1, createDto.getHeight())
                .mapToObj(i -> Line.of(players))
                .collect(Collectors.toList());
    }

    public static Ladder of(LadderCreateDto createDto) {
        return new Ladder(createDto);
    }


    private static void validate(LadderCreateDto createDto){
        assert createDto != null;
        if(createDto.getPlayers().getPlayerCount()
                != createDto.getScores().getScoreCount()){
            throw new LadderCreateException("플레이어의 수와 결과의 개수가 서로 다르기 때문에 사다리를 만들 수 없습니다.");
        }
    }

    public List<List<String>> getLines(){
        return Collections.unmodifiableList(
                lines.stream()
                .map(Line::toDisplays)
                .collect(Collectors.toList()));
    }

    public List<String> getScores(){
        return Collections.unmodifiableList(scores.getScores());
    }

    public List<PlayerResult> getResults(){
        return Collections.unmodifiableList(players.getLadderGameResults(lines, scores));
    }
}
