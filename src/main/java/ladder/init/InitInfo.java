package ladder.init;

import ladder.strategy.PollCreateStrategy;

import java.util.List;

public class InitInfo {
    private List<String> userNames;
    private PollCreateStrategy pollCreateStrategy;

    public InitInfo(List<String> userNames, PollCreateStrategy pollCreateStrategy) {
        this.userNames = userNames;
        this.pollCreateStrategy = pollCreateStrategy;
    }

    public int numOfUsers() {
        return userNames.size();
    }

    public List<String> getUserNames() {
        return userNames;
    }

    public PollCreateStrategy getPollCreateStrategy() {
        return pollCreateStrategy;
    }
}
