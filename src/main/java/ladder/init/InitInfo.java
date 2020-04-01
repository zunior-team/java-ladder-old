package ladder.init;

import ladder.strategy.PollCreateStrategy;
import ladder.user.User;

import java.util.List;

public class InitInfo {
    private List<User> users;
    private PollCreateStrategy pollCreateStrategy;

    public InitInfo(List<User> users, PollCreateStrategy pollCreateStrategy) {
        this.users = users;
        this.pollCreateStrategy = pollCreateStrategy;
    }

    public int numOfUsers() {
        return users.size();
    }

    public PollCreateStrategy getPollCreateStrategy() {
        return pollCreateStrategy;
    }
}
