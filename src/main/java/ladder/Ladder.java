package ladder;

import ladder.dto.BlockDto;
import ladder.dto.LadderResult;
import ladder.init.InitInfo;
import ladder.user.User;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Block> blocks;

    public Ladder(InitInfo initInfo) {
        this.blocks = IntStream.rangeClosed(0, initInfo.getHeight())
                .mapToObj(i -> new Block(initInfo))
                .collect(Collectors.toList());
    }

    public LadderResult takeLadders(UserAndPrize userAndPrize) {
        Map<String, String> prizeMatch = userAndPrize.getUsers()
                .stream()
                .collect(Collectors.toMap(User::getName, user -> userAndPrize.getPrize(takeLadder(user))));

        return new LadderResult(prizeMatch);
    }

    private int takeLadder(User user) {
        return blocks.stream()
                .reduce(user.getPosition(), (byPosition, block) -> block.takeLadder(byPosition),
                        (x, y) -> {throw new RuntimeException("Parallel operation is not allowed at this logic");}
                );
    }

    public List<BlockDto> toBlockDtos() {
        return blocks.stream()
                .map(Block::toDto)
                .collect(Collectors.toList());
    }
}
