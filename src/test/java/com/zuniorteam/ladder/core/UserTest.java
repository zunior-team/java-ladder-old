package com.zuniorteam.ladder.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("사용자 테스트")
class UserTest {


    @DisplayName("사용자 이름이 null 이거나, empty 일때")
    @NullAndEmptySource
    @ParameterizedTest
    void testNewInstance01(String username){
        assertThrows(IllegalArgumentException.class, () -> new User(username));
    }

    @DisplayName("사용자 이름이 최대 글자를 넘겼을때")
    @ValueSource(strings = {"abcdef            gh", "최대글자 초과아아 초과아아아"})
    @ParameterizedTest
    void testNewInstance02(String username){
        assertThrows(IllegalArgumentException.class, () -> new User(username));
    }

}
