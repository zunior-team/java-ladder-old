package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LadderGame test")
class LadderGameTest {

    private static Stream<Arguments> ladderGameProvider(){
        return Stream.of(
                Arguments.of(Ladder.of(5,5),
                        Participants.of("a,b,c,d,e"),
                        new Results("1,200,300,꽝,꽝")),
                Arguments.of(Ladder.of(4,3),
                        Participants.of("a,b,c,d"),
                        new Results("1,300,꽝,꽝"))
        );
    }

    @DisplayName("게임을 실행하면 결과를 반환한다.")
    @ParameterizedTest
    @MethodSource(value = "ladderGameProvider")
    void play(Ladder ladder,Participants participants,Results results){
        LadderGame ladderGame = new LadderGame(ladder,participants,results);
        assertThat(ladderGame).isNotNull();
        LadderResult ladderResult = ladderGame.play();
        assertThat(ladderResult).isNotNull();
    }

}