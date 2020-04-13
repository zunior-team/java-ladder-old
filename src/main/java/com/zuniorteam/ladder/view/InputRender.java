package com.zuniorteam.ladder.view;

import com.zuniorteam.ladder.core.User;
import com.zuniorteam.ladder.core.util.StringUtils;
import com.zuniorteam.ladder.view.console.OutputDrawer;

import java.util.Arrays;
import java.util.List;

import static com.zuniorteam.ladder.core.Ladder.MIN_LADDER_HEIGHT;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public final class InputRender {

    private static final String USERNAME_SPLIT_TOKEN = ",";
    private static final String RESULTS_SPLIT_TOKEN = ",";

    private InputRender() {}

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

    public static User getCheckUser(String inputUsername, List<User> users) {
        if (StringUtils.isEmpty(inputUsername)) {
            throw new IllegalArgumentException("사용자이름을 입력해주세요");
        }

        if (inputUsername.equals(User.ALL_USERS_KEYWORD)) {
            return User.ALL_USERS;
        }

        return users.stream()
                .filter(user -> user.eqUsername(inputUsername))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("찾을 수 없는 사용자 입니다 : " + inputUsername));

    }
}
