package com.zuniorteam.ladder.core.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CollectionUtilsTest {


    @DisplayName("isFirstIndex, 첫번째 index 인가")
    @Test
    void testIsFirstIndex() {
        assertThat(CollectionUtils.isFirstIndex(0)).isTrue();
        assertThat(CollectionUtils.isFirstIndex(1)).isFalse();
    }

    @DisplayName("getBefore, 이전값 가져오기, 0보다 작을 때")
    @Test
    void testGetBefore01() {
        final List<Integer> integers = Arrays.asList(1, 2);

        assertThrows(IllegalArgumentException.class, () -> CollectionUtils.getBefore(integers, 0));
    }

    @DisplayName("getBefore")
    @Test
    void testGetBefore02() {
        final List<Integer> integers = Arrays.asList(1, 2);
        assertThat(CollectionUtils.getBefore(integers, 1)).isEqualTo(1);
    }
}
