package model.player;

import exception.PlayersCreateException;
import model.ladder.Line;
import model.ladder.Score;
import model.ladder.Scores;
import model.result.PlayerResult;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {

    private final List<Player> players;

    private Players(final List<String> names){
        this.players = names.stream()
                .map(Player::create)
                .collect(Collectors.toList());
    }

    public static Players create(final List<String> names) {
        validate(names);
        return new Players(names);
    }

    private static void validate(final List<String> names){
        if(CollectionUtils.isEmpty(names)) {
            throw new PlayersCreateException("플레이어를 생성하지 못합니다.");
        }
    }

    public int getPlayerCount(){
        return this.players.size();
    }

    public List<String> toNames(){
        return Collections.unmodifiableList(
                players.stream()
                .map(Player::name)
                .collect(Collectors.toList()));
    }

    public List<PlayerResult> getLadderGameResults(List<Line> lines, Scores scores){
        return IntStream.range(0, getPlayerCount())
                .mapToObj(playerIndex -> {
                    Player player = players.get(playerIndex);
                    int scoreIndex = getResultIndexByOnePlayer(lines, playerIndex);
                    Score score = scores.getScoreByIndex(scoreIndex);
                    return new PlayerResult(player, score);
                }).collect(Collectors.toList());
    }

    private int getResultIndexByOnePlayer(List<Line> lines, int playerIndex){
        int currentPosition = lines.get(0).convertPlayerIndexToPosition(playerIndex);
        for(Line line : lines){
            currentPosition = line.getPosition(currentPosition);
        }
        return lines.get(lines.size() - 1)
                .convertPositionToPlayerIndex(currentPosition);
    }
}
