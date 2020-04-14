package ladder.init;

import ladder.strategy.PollCreateStrategy;
import ladder.user.Users;

public class InitInfo {
    private LadderInitInfo ladderInitInfo;
    private PollCreateStrategy pollCreateStrategy;

    public InitInfo(final LadderInitInfo ladderInitInfo, final PollCreateStrategy pollCreateStrategy) {
        assert ladderInitInfo != null;

        this.ladderInitInfo = ladderInitInfo;
        this.pollCreateStrategy = pollCreateStrategy;
    }

    public PollCreateStrategy getPollCreateStrategy() {
        return pollCreateStrategy;
    }

    public int getHeight() {
        return ladderInitInfo.getHeight();
    }
}
