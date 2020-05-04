package com.zuniorteam.ladder.core;

import com.zuniorteam.ladder.core.util.StringUtil;

public class User {

    public static final int MAX_USERNAME_LENGTH = 5;
    public static final String ALL_USERS_KEYWORD = "all";
    public static final User ALL_USERS = new User();

    private final String username;

    private User(){this.username = "";}

    public User(String username) {
        validate(username);

        this.username = username;
    }

    private void validate(String username) {
        if (StringUtil.isEmpty(username)) {
            throw new IllegalArgumentException("사용자 명이 없습니다.");
        }

        if (username.equals(ALL_USERS_KEYWORD)) {
            throw new IllegalArgumentException(username + "은 사용자이름으로 사용할 수 없습니다, 예약어 입니다.");
        }

        if (username.length() > MAX_USERNAME_LENGTH) {
            throw new IllegalArgumentException("사용자 이름 길이가 " + MAX_USERNAME_LENGTH + " 를 초과합니다");
        }
    }

    public String getUsername() {
        return username;
    }

    public boolean eqUsername(String username) {
        return this.getUsername().equals(username);
    }
}

