package dto;

import exception.LadderCreateException;
import model.ladder.Scores;
import model.player.Players;

public class LadderCreateDto {

    private static final int ZERO_HEIGHT = 0;
    private final Scores scores;
    private final Players players;
    private final int height;

    public LadderCreateDto(final Players players,
                           final Scores scores,
                           final int height){
        validate(players, scores, height);
        this.players = players;
        this.scores = scores;
        this.height = height;
    }

    private void validate(final Players players, final Scores scores, final int height){
        if(height <= ZERO_HEIGHT){
            throw new LadderCreateException("높이가 0 이하이기 때문에 사다리를 만들 수 없습니다.");
        }

        if(players == null){
            throw new LadderCreateException("사디리게임을 하기위한 플레이어가 없기 때문에 사다리를 만들 수 없습니다.");
        }

        if(scores == null) {
            throw new LadderCreateException("사디리게임의 결과가 없기 때문에 사다리를 만들 수 없습니다.");
        }
    }

    public Scores getScores(){
        return scores;
    }

    public Players getPlayers(){
        return players;
    }

    public int getHeight() {
        return height;
    }
}
