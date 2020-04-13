package com.zuniorteam.ladder.core;

import com.zuniorteam.ladder.core.util.StringUtils;

public class User {

    public static final String ALL_USERS_KEYWORD = "all";
    public static final User ALL_USERS = new User(ALL_USERS_KEYWORD);
    public static final int MAX_USERNAME_LENGTH = 5;

    private final String username;

    public User(String username) {
        validate(username);

        this.username = username;
    }

    private void validate(String username) {
        if (StringUtils.isEmpty(username)) {
            throw new IllegalArgumentException("사용자 명이 없습니다.");
        }

        if (username.length() > MAX_USERNAME_LENGTH) {
            throw new IllegalArgumentException("사용자 이름 길이가 " + MAX_USERNAME_LENGTH + " 를 초과합니다");
        }
    }

    public String getUsername(){
        return username;
    }

    public boolean eqUsername(String username) {
        return this.getUsername().equals(username);
    }
}

