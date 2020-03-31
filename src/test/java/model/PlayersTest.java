package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("플레이어는")
class PlayersTest {

    @DisplayName("생성된다")
    @ParameterizedTest
    @MethodSource("provideNames")
    void createTest(List<String> names, int expectedSize) {

        // when
        Players players = Players.create(names);

        // then
        
    }

    private static Stream<Arguments> provideNames(){
        return Stream.of(
            arguments(Arrays.asList("PARK", "KIM", "JUN", "HO"), 4),
            arguments(Arrays.asList("PARK", "JIN", "OH"), 3)
        );
    }
}
