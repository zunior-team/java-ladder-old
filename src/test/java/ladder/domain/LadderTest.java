package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Ladder test")
class LadderTest {

    @DisplayName("사다리게임의 참여자가 1명이하이면 익셉션이 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1,0,1})
    void 참여자_1명이하_익셉션(int countOfParticipant){
        int maxHeight = 2;
        assertThatThrownBy(()-> Ladder.of(countOfParticipant,maxHeight))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("사다리의 최대 높이가 1이하이면 익셉션이 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1,0,1})
    void 높이_1이하_익셉션(int maxHeight){
        int countOfParticipant = 2;
        assertThatThrownBy(()-> Ladder.of(countOfParticipant,maxHeight))
                .isInstanceOf(IllegalArgumentException.class);
    }
    private static Stream<Arguments> ladderProvider(){
        return Stream.of(
                Arguments.of(5,3),
                Arguments.of(6,4),
                Arguments.of(7,3),
                Arguments.of(8,4)
        );
    }
    @DisplayName("참여자수와 사다리 최대 높이로 사다리를 생성한다.")
    @ParameterizedTest
    @MethodSource(value = "ladderProvider")
    void of(int countOfParticipant,int maxHeight){
        Ladder ladder = Ladder.of(countOfParticipant, maxHeight);
        assertThat(ladder).isNotNull();
    }
}