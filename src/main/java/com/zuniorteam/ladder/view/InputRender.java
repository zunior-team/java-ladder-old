package com.zuniorteam.ladder.view;

import com.zuniorteam.ladder.core.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputRender {

    private static final String USERNAME_SPLIT_TOKEN = ",";

    public static List<User> getUsers(String usernames) {
        return Arrays.stream(usernames.split(USERNAME_SPLIT_TOKEN))
                .map(User::new)
                .collect(Collectors.toList());
    }

    public static int getLadderHeight(int ladderHeight) {
        if (ladderHeight < 0) {
            throw new IllegalArgumentException("사다리 높이는 0보다 작을 수 없습니다.");
        }

        return ladderHeight;
    }
}
