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

    public Map<String, String> matchUserAndPrize(Ladder ladder) {
        List<Integer> ladderResults = ladder.takeLadders();

        // atomic integer를 이용하는 방법도 있지만 가독성이 떨어진다.
        return users.getUsers()
                .stream()
                .collect(Collectors.toMap(User::getName, user -> getPrize(user, ladderResults)));
    }

    private String getPrize(User user, List<Integer> ladderResults) {
        // 사다리 타기를 했을때 마지막 줄에서의 user 위치
        int usersResultPosition = ladderResults.get(user.getOrder());

        // 해당 위치에서의 당첨 결과
        return prizes.getPrize(usersResultPosition);
    }

    public int width() {
        return users.numOfUsers();
    }
}
