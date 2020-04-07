package ladder.init;

import ladder.strategy.PollCreateStrategy;
import ladder.user.Users;

public class InitInfo {
    private Users users;
    private LadderInitInfo ladderInitInfo;

    public InitInfo(final Users users, final LadderInitInfo ladderInitInfo) {
        assert users != null;
        assert ladderInitInfo != null;

        this.users = users;
        this.ladderInitInfo = ladderInitInfo;
    }

    public int numOfUsers() {
        return users.numOfUsers();
    }

    public PollCreateStrategy getPollCreateStrategy() {
        return ladderInitInfo.getPollCreateStrategy();
    }

    public int getHeight() {
        return ladderInitInfo.getHeight();
    }

    public Users getUsers() {
        return users;
    }
}
