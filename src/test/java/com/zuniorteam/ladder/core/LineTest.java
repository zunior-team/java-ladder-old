package com.zuniorteam.ladder.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Line Test")
class LineTest {

    @DisplayName("생성, 성공")
    @Test
    void testNewInstance01() {
        assertDoesNotThrow(() -> new Line(new ArrayList<>()));
    }

    @DisplayName("생성, 실패, points null")
    @Test
    void testNewInstance02() {
        assertThrows(AssertionError.class, () -> new Line(null));
    }

    @DisplayName("생성, 실패, 이어지는 bridge가 있는 경우")
    @Test
    void testNewInstance03(){
        //given
        final List<Boolean> points = new ArrayList<>();
        points.add(true);
        points.add(true);
        points.add(true);
        points.add(false);

        //when, then
        assertThrows(IllegalArgumentException.class, () -> new Line(points));
    }

    @DisplayName("getLength()")
    @Test
    void testGetLength(){
        final List<Boolean> points = new ArrayList<>();
        points.add(true);
        points.add(false);
        points.add(false);

        final Line line = new Line(points);

        assertThat(line.getLength()).isEqualTo(points.size());
    }

    @DisplayName("hasBridge(), index 0 일 때")
    @Test
    void testHasBridge01(){
        //given
        final List<Boolean> points = new ArrayList<>();
        points.add(true);

        //when
        final Line line = new Line(points);

        //then
        assertThat(line.hasBridge(0)).isFalse();
    }

    @DisplayName("hasBridge(), point 가 이어 질 때")
    @Test
    void testHasBridge02(){
        //given
        final List<Boolean> points = new ArrayList<>();
        points.add(true);
        points.add(true);
        points.add(false);
        points.add(false);

        //when
        final Line line = new Line(points);

        //then
        assertThat(line.hasBridge(1)).isTrue();
        assertThat(line.hasBridge(2)).isFalse();
        assertThat(line.hasBridge(3)).isFalse();
    }

}
