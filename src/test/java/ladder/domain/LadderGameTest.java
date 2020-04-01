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
    void constructTest() {
        //given
        List<String> names = Lists.newArrayList("junwoo");
        int maxHeight = 5;


        //then
        assertThrows(IllegalArgumentException.class,
                //when
                () -> LadderGame.of(names, maxHeight));
    }

    @Test
    @DisplayName("최대 높이는 1이상이어야 한다")
    void constructTest() {
        //given
        List<String> names = Lists.newArrayList("junwoo", "wonoh", "changoo", "sungdong");
        int maxHeight = 1;


        //then
        assertThrows(IllegalArgumentException.class,
                //when
                () -> LadderGame.of(names, maxHeight));
    }
}