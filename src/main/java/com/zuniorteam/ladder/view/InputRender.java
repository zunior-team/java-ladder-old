package com.zuniorteam.ladder.view;

import com.zuniorteam.ladder.core.User;
import com.zuniorteam.ladder.core.util.StringUtils;

import java.util.Arrays;
import java.util.List;

import static com.zuniorteam.ladder.core.User.ALL_USERS;
import static com.zuniorteam.ladder.core.User.ALL_USERS_KEYWORD;
import static java.util.stream.Collectors.toList;

public class InputRender {

    private static final String USERNAME_SPLIT_TOKEN = ",";
    private static final String RESULTS_SPLIT_TOKEN = ",";

    private static final int MIN_LADDER_HEIGHT = 1;
    public static final String ALL_USERNAME = "all";

    public static List<User> getUsers(String usernames) {
        return Arrays.stream(usernames.split(USERNAME_SPLIT_TOKEN))
                .map(User::new)
                .collect(toList());
    }

    public static List<String> getResults(String resultStr, int numberOfUsers) {
        List<String> results = Arrays.stream(resultStr.split(RESULTS_SPLIT_TOKEN))
                .collect(toList());

        if (results.size() != numberOfUsers) {
            throw new IllegalArgumentException("참여인원과 결과들의 개수가 다릅니다.");
        }

        return results;
    }

    public static int getLadderHeight(int ladderHeight) {
        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는" + MIN_LADDER_HEIGHT + "보다 작을 수 없습니다.");
        }

        return ladderHeight;
    }

    public static User getUserForCheck(String inputUsername, List<User> users) {
        if (StringUtils.isEmpty(inputUsername)) {
            throw new IllegalArgumentException("사용자이름을 입력해주세요");
        }

        if (ALL_USERS_KEYWORD.equals(inputUsername)) {
            return ALL_USERS;
        }

        return users.stream()
                .filter(user -> user.eqUsername(inputUsername))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("찾을 수 없는 사용자 입니다 : " + inputUsername));

    }
}
