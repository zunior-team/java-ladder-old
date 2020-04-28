package ladder.dto;

import ladder.Block;

import java.util.List;

public class BlockDto {
    private List<Boolean> polls;

    private BlockDto() {}

    public static BlockDto of(Block block) {
        BlockDto blockDto = new BlockDto();

        blockDto.polls = block.getPollInfos();

        return blockDto;
    }

    public List<Boolean> getPolls() {
        return polls;
    }
}
