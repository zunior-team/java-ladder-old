package ladder.dto;

import ladder.Block;
import ladder.user.User;

import java.util.List;
import java.util.stream.Collectors;

public class LadderResult {
    private List<String> userNames;
    private List<BlockDto> blockDto;

    public LadderResult(List<User> users, List<Block> blocks) {
        this.userNames = users.stream()
                .map(User::getName)
                .collect(Collectors.toList());

        this.blockDto = blocks.stream()
                .map(BlockDto::of)
                .collect(Collectors.toList());
    }

    public List<String> getUserNames() {
        return userNames;
    }

    public List<BlockDto> getBlockDto() {
        return blockDto;
    }
}
