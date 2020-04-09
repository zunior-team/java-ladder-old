package model.ladder;

import exception.LadderCreateException;
import model.player.Players;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int ZERO_HEIGHT = 0;
    private final LadderResults ladderResults;
    private final List<Line> lines;

    private Ladder(Players players, LadderResults ladderResults, int height){
        validate(players, ladderResults, height);
        this.ladderResults = ladderResults;
        this.lines = IntStream.rangeClosed(1, height)
                .mapToObj(i -> Line.of(players))
                .collect(Collectors.toList());
    }

    public static Ladder of(Players players, LadderResults ladderResults, int height) {
        return new Ladder(players, ladderResults, height);
    }

    private static void validate(Players players, LadderResults ladderResults, int height){
        if(height <= ZERO_HEIGHT){
            throw new LadderCreateException("높이가 0 이하이기 때문에 사다리를 만들 수 없습니다.");
        }

        if(players == null){
            throw new LadderCreateException("사디리게임을 하기위한 플레이어가 없기 때문에 사다리를 만들 수 없습니다.");
        }

        if(ladderResults == null) {
            throw new LadderCreateException("사디리게임의 결과가 없기 때문에 사다리를 만들 수 없습니다.");
        }

        if(players.getPlayerCount() != ladderResults.getScoreCount()){
            throw new LadderCreateException("플레이어의 수와 결과의 개수가 서로 다르기 때문에 사다리를 만들 수 없습니다.");
        }
    }

    public List<List<String>> toLines(){
        return Collections.unmodifiableList(
                lines.stream()
                .map(Line::toDisplays)
                .collect(Collectors.toList()));
    }

    public List<String> toScores(){
        return ladderResults.getScores();
    }
}
