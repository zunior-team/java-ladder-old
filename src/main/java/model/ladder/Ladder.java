package model.ladder;

import exception.LadderCreateException;
import model.player.Players;
import model.result.PlayerResult;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int ZERO_HEIGHT = 0;
    private final Scores scores;
    private final Players players;
    private final List<Line> lines;

    private Ladder(Players players, Scores scores, int height){
        validate(players, scores, height);
        this.scores = scores;
        this.players = players;
        this.lines = IntStream.rangeClosed(1, height)
                .mapToObj(i -> Line.of(players))
                .collect(Collectors.toList());
    }

    public static Ladder of(Players players, Scores scores, int height) {
        return new Ladder(players, scores, height);
    }

    private static void validate(Players players, Scores scores, int height){
        if(height <= ZERO_HEIGHT){
            throw new LadderCreateException("높이가 0 이하이기 때문에 사다리를 만들 수 없습니다.");
        }

        if(players == null){
            throw new LadderCreateException("사디리게임을 하기위한 플레이어가 없기 때문에 사다리를 만들 수 없습니다.");
        }

        if(scores == null) {
            throw new LadderCreateException("사디리게임의 결과가 없기 때문에 사다리를 만들 수 없습니다.");
        }

        if(players.getPlayerCount() != scores.getScoreCount()){
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
