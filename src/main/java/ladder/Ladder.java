package ladder;

import ladder.dto.LadderResult;
import ladder.init.InitInfo;
import ladder.user.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private List<User> users;
    private List<Block> blocks;

    public Ladder(InitInfo initInfo) {
        this.users = initInfo.getUsers();
        this.blocks = IntStream.rangeClosed(0, initInfo.getHeight())
                .mapToObj(i -> new Block(initInfo))
                .collect(Collectors.toList());
    }

    public LadderResult getResult() {
        return new LadderResult(users, blocks);
    }
}
