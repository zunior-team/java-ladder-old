package com.zuniorteam.ladder.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("사다리 테스트")
class LadderTest {

    @DisplayName("생성")
    @Test
    void testNewInstance01() {
        final Line line = new Line(Collections.emptyList());
        assertDoesNotThrow(() -> new Ladder(Collections.singletonList(line)));
    }

    @DisplayName("생성, null 값 일때")
    @Test
    void testNewInstance02() {
        assertThrows(AssertionError.class, () -> new Ladder(null));
    }

    @DisplayName("생성, 라인 개수가 1보다 작을 때")
    @Test
    void testNewInstance03() {
        assertThrows(IllegalArgumentException.class, () -> new Ladder(Collections.emptyList()));
    }

    @DisplayName("get 라인")
    @Test
    void testGetLines() {
        //given - line
        final Line lineA = new Line(Collections.singletonList(true));
        final Line lineB = new Line(Collections.singletonList(false));
        final List<Line> lines = asList(lineA, lineB);

        //when
        final Ladder ladder = new Ladder(lines);

        //then
        final List<Line> actualLines = ladder.getLines();
        assertThat(actualLines.size()).isEqualTo(lines.size());
        assertThat(actualLines).containsExactly(lineA, lineB);
    }

    @DisplayName("play")
    @ParameterizedTest()
    @MethodSource("givenForTestPlay")
    void testPlay01(Line lineA, Line lineB, List<Integer> expectResultIndex) {
        //given
        final List<User> users = Stream.of("a", "b", "c", "d")
                .map(User::new)
                .collect(toList());

        final List<String> results = asList("@", "|", "#", "&");
        final Ladder ladder = new Ladder(asList(lineA, lineB));

        //when
        final Map<User, String> userToResult = ladder.play(users, results);

        //then
        assertThat(userToResult).containsKeys(users.toArray(new User[0]));
        assertThat(userToResult.values()).containsOnlyOnce(results.toArray(new String[0]));
        IntStream.range(0, userToResult.size())
                .forEach(i -> assertThat(userToResult.get(users.get(i)))
                        .isEqualTo(results.get(expectResultIndex.get(i)))
                );
    }

    private static Stream<Arguments> givenForTestPlay() {
        return Stream.of(
                Arguments.of(new Line(asList(true, false, true)), new Line(asList(false, true, false)), Arrays.asList(2, 0, 3, 1)),
                Arguments.of(new Line(asList(true, false, false)), new Line(asList(false, false, false)), Arrays.asList(1, 0, 2, 3)),
                Arguments.of(new Line(asList(false, false, false)), new Line(asList(false, false, false)), Arrays.asList(0, 1, 2, 3)),
                Arguments.of(new Line(asList(false, true, false)), new Line(asList(false, true, false)), Arrays.asList(0, 1, 2, 3)),
                Arguments.of(new Line(asList(false, true, false)), new Line(asList(true, false, true)), Arrays.asList(1, 3, 0, 2))
        );
    }
}