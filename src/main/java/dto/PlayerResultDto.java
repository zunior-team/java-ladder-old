package dto;

import model.result.PlayerResult;

public class PlayerResultDto {
    private String name;
    private String score;

    public PlayerResultDto(PlayerResult playerResult){
        this.name = playerResult.getPlayerName();
        this.score = playerResult.getPlayerScore();
    }

    public String getName(){
        return name;
    }

    public String getScore(){
        return score;
    }
}
