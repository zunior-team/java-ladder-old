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
}
