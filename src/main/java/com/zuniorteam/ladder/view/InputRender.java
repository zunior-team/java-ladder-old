package com.zuniorteam.ladder.view;

import com.zuniorteam.ladder.core.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputRender {

    private static final String USERNAME_SPLIT_TOKEN = ",";
    private static final int MIN_LADDER_HEIGHT = 1;

    public static List<User> getUsers(String usernames) {
        return Arrays.stream(usernames.split(USERNAME_SPLIT_TOKEN))
                .map(User::new)
                .collect(Collectors.toList());
    }

    public static int getLadderHeight(int ladderHeight) {
        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는" + MIN_LADDER_HEIGHT + "보다 작을 수 없습니다.");
        }

        return ladderHeight;
    }
}
