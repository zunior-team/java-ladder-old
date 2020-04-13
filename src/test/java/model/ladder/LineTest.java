package model.ladder;

import model.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
        List<String> displays = line.toDisplays();
        assertTrue(sets.contains(String.join("", displays)));
    }

    @DisplayName("라인을 생성하고 해당 플레이어는 한 라인에서 이동한 뒤 현재 Point 를 반환한다.")
    @MethodSource("provideOnePlayers")
    @ParameterizedTest
    void moveTest(Players players){

        // when
        final Line line = Line.of(players);

        // then
        for(int index = 0; index < players.getPlayerCount(); index++){
            int pos = line.convertPlayerIndexToPosition(index);
            assertThat(pos).isEqualTo(index * 5);
        }
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
                        add("|-----|     |");
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

    private static Stream<Arguments> provideOnePlayers() {
        return Stream.of(
                arguments(Players.create(Arrays.asList("PARK", "SUNG", "DONG")))
        );
    }
}
