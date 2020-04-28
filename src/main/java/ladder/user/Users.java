package ladder.user;

import spark.utils.CollectionUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Users {
    private final List<User> users;

    public Users(List<String> users) {
        validateUsers(users);

        AtomicInteger order = new AtomicInteger(0);
        this.users = users.stream()
                .map(user -> new User(user, order.getAndAdd(1)))
                .collect(Collectors.toList());
    }

    private void validateUsers(List<String> users) {
        if(CollectionUtils.isEmpty(users)) {
            throw new IllegalArgumentException("User is not exist");
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public int numOfUsers() {
        return users.size();
    }
}
