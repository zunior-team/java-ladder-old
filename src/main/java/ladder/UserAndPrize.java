package ladder;

import ladder.prize.Prizes;
import ladder.user.User;
import ladder.user.Users;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserAndPrize {
    private final Users users;
    private final Prizes prizes;

    public UserAndPrize(Users users, Prizes prizes) {
        assert users != null;
        assert prizes != null;

        this.users = users;
        this.prizes = prizes;
    }

    public int width() {
        return users.numOfUsers();
    }

    public List<User> getUsers() {
        return users.getUsers();
    }

    public String getPrize(int position) {
        return prizes.getPrize(position);
    }

    public List<String> getPrizes() {
        return prizes.getPrizes();
    }
}
