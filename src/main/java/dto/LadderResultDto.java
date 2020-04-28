package dto;

import model.result.PlayerResult;

import java.util.List;
import java.util.stream.Collectors;

public class LadderResultDto {

    List<PlayerResultDto> playerResultDtos;

    public LadderResultDto(List<PlayerResult> playerResults){
        this.playerResultDtos = playerResults.stream()
                .map(PlayerResultDto::new)
                .collect(Collectors.toList());
    }

    public String getScoreByName(String name){
        return playerResultDtos.stream()
                .filter(playerResultDto -> playerResultDto.getName().equalsIgnoreCase(name))
                .findFirst()
                .map(PlayerResultDto::getScore)
                .orElse("[warning] : 해당 플레이어는 사다리 게임을 수행하지 않았습니다.");
    }

    public List<PlayerResultDto> getPlayerResultDtos(){
        return this.playerResultDtos;
    }
}
