package ladder.init;

import ladder.strategy.PollCreateStrategy;
import ladder.user.User;
import spark.utils.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

public class InitInfo {
    private List<User> users;
    private int length;
    private PollCreateStrategy pollCreateStrategy;

    public InitInfo(final List<String> users, final int length, final PollCreateStrategy pollCreateStrategy) {
        validate(users, length, pollCreateStrategy);

        this.users = users.stream()
                .map(User::new)
                .collect(Collectors.toList());
        this.length = length;
        this.pollCreateStrategy = pollCreateStrategy;
    }

    private void validate(final List<String> users, final int length, PollCreateStrategy pollCreateStrategy) {
        validateUsers(users);
        validateLength(length);
        validateStrategy(pollCreateStrategy);
    }

    private void validateStrategy(PollCreateStrategy pollCreateStrategy) {
        if(pollCreateStrategy == null) {
            throw new IllegalArgumentException("PollCreateStrategy can't be a null");
        }
    }

    private void validateLength(int length) {
        if(length < 1) {
            throw new IllegalArgumentException("Ladder can't be created with length : " + length);
        }
    }

    private void validateUsers(List<String> users) {
        if(CollectionUtils.isEmpty(users)) {
            throw new IllegalArgumentException("User is not exist");
        }
    }

    public int numOfUsers() {
        return users.size();
    }

    public PollCreateStrategy getPollCreateStrategy() {
        return pollCreateStrategy;
    }

    public int getLength() {
        return length;
    }

    public List<User> getUsers() {
        return this.users;
    }
}
