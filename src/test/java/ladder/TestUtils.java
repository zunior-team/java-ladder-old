package ladder;

import ladder.user.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestUtils {
    public static List<User> arrayToUser(String... userNames) {
        return Arrays.stream(userNames)
                .map(User::new)
                .collect(Collectors.toList());
    }
}
