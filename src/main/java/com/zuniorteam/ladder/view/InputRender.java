package com.zuniorteam.ladder.view;

import com.zuniorteam.ladder.core.LadderLevel;
import com.zuniorteam.ladder.core.User;
import com.zuniorteam.ladder.core.util.CollectionUtil;
import com.zuniorteam.ladder.core.util.StringUtil;
import com.zuniorteam.ladder.view.mapper.LadderLevelParser;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public final class InputRender {

    private static final String USERNAME_SPLIT_TOKEN = ",";
    private static final String RESULTS_SPLIT_TOKEN = ",";

    private InputRender() {
    }

    public static List<User> getUsers(String usernamesLine) {
        final List<String> usernames = Arrays.asList(usernamesLine.split(USERNAME_SPLIT_TOKEN));

        if (!CollectionUtil.isUnique(usernames)) {
            throw new IllegalArgumentException(" 사용자 이름이 중복됩니다" + usernames);
        }

        return usernames.stream()
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

    public static User getCheckUser(String inputUsername, List<User> users) {
        if (StringUtil.isEmpty(inputUsername)) {
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

    public static LadderLevel getLadderLevel(String ladderLevelKeyword) {
        return LadderLevelParser.parse(ladderLevelKeyword);
    }
}
