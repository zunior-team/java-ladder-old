package ladder;

import ladder.strategy.PollCreateStrategy;

public class Poll {
    private boolean exist;

    private Poll() {}

    public static Poll init(PollCreateStrategy pollCreateStrategy) {
        Poll poll = new Poll();

        poll.exist = pollCreateStrategy.decideCreateOrNot();

        return poll;
    }

    public boolean isExist() {
        return exist;
    }
}
