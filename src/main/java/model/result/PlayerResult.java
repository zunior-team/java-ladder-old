package model.result;

import model.ladder.Score;
import model.player.Player;

public class PlayerResult {
    private Player player;
    private Score score;

    public PlayerResult(Player player, Score score){
        this.player = player;
        this.score = score;
    }

    public String getPlayerName(){
        return player.name();
    }

    public String getPlayerScore(){
        return score.get();
    }
}
