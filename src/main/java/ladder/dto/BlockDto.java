package ladder.dto;

import ladder.Block;

import java.util.List;

public class BlockDto {
    private List<Boolean> polls;

    private BlockDto() {}

    // 외부에서 dto를 생성하면 해당 entity에 getter가 생기게 되는데.. 흠...
    public static BlockDto of(Block block) {
        BlockDto blockDto = new BlockDto();

//        blockDto.polls = block.getPolls();

        return blockDto;
    }

    public BlockDto(List<Boolean> polls) {
        this.polls = polls;
    }

    public List<Boolean> getPolls() {
        return polls;
    }
}
