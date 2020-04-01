package ladder.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("사다리게임 객체 테스트")
class LadderGameTest {

    @Test
    @DisplayName("참여자의 이름과 최대높이를 가지고 사다리 게임을 생성한다")
    void constructTest() {
        //given
        List<String> names = Lists.newArrayList("junwoo", "wonoh", "changoo", "sungdong");
        int maxHeight = 5;

        //when
        final LadderGame ladderGame = LadderGame.of(names, maxHeight);

        //then
        assertThat(ladderGame).isNotNull();
    }

    @Test
    @DisplayName("참여자는 두명 이상이어야 한다")
    void constructParticipantsTest() {
        //givens
        List<String> names = Lists.newArrayList("junwoo");
        int maxHeight = 5;


        //then
        assertThrows(IllegalArgumentException.class,
                //when
                () -> LadderGame.of(names, maxHeight));
    }

    @Test
    @DisplayName("최대 높이는 1이상이어야 한다")
    void constructMaxHeightTest() {
        //given
        List<String> names = Lists.newArrayList("junwoo", "wonoh", "changoo", "sungdong");
        int maxHeight = 0;


        //then
        assertThrows(IllegalArgumentException.class,
                //when
                () -> LadderGame.of(names, maxHeight));
    }

    @Test
    @DisplayName("사다리 게임으로부 사다리를 받아올 수 있다.")
    void getLadderTest() {
        //given
        List<String> names = Lists.newArrayList("junwoo", "wonoh", "changoo", "sungdong");
        int maxHeight = 5;
        final LadderGame ladderGame = LadderGame.of(names, maxHeight);

        //when
        final Ladder ladder = ladderGame.ladder();

        //then
        assertThat(ladder).isNotNull();
    }
}