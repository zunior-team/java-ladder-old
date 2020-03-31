package model.ladder;

import model.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("한 라인은")
class LineTest {

    @DisplayName("생성된다.")
    @MethodSource("providePlayers")
    @ParameterizedTest
    void ofTest(Players players) {
        // when
        final Line line = Line.of(players);

        // then
        assertNotNull(line);
    }

    @DisplayName("한 라인에 있는 디스플레이를 반환한다.")
    @MethodSource("providePlayers")
    @ParameterizedTest
    void getDisplaysTest(Players players, HashSet<String> sets) {

        // when
        final Line line = Line.of(players);

        // then
        List<String> displays = line.getDisplays();
        assertTrue(sets.contains(String.join("", displays)));
    }

    private static Stream<Arguments> providePlayers(){
        return Stream.of(
            arguments(Players.create(Arrays.asList("KIM", "PARK")),
                    new HashSet<String>()
                    {{
                        add("|-----|");
                        add("|     |"); }}),

            arguments(Players.create(Arrays.asList("KIM", "PARK", "LEE")),
                    new HashSet<String>(){{
                        add("|-----|     ");
                        add("|     |-----|");
                        add("|     |     |");
            }}),

            arguments(Players.create(Arrays.asList("KIM", "PARK", "LEE", "YUN")),
                    new HashSet<String>(){{
                        add("|-----|-----|     |");
                        add("|     |-----|-----|");
                        add("|-----|     |-----|");
                        add("|-----|     |     |");
                        add("|     |-----|     |");
                        add("|     |     |-----|");
                        add("|     |     |     |");
                    }})
        );
    }
}
