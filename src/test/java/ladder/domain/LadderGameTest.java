package ladder.domain;

import ladder.dto.LadderInfo;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리게임 객체 테스트")
class LadderGameTest {

    @Test
    @DisplayName("참여자의 이름과 난이도를 가지고 사다리 게임을 생성한다")
    void constructTest() {
        //given
        final Players players = Players.of(Lists.newArrayList("junwoo", "wonoh", "changoo", "sungdong"));
        final Results results = Results.of(Lists.newArrayList("꽝", "꽝", "3000", "꽝"), players.size());
        int maxHeight = 5;

        //when
        final LadderGame ladderGame = LadderGame.of(new LadderInfo(players, LadderDifficulty.MEDIUM, results));

        //then
        assertThat(ladderGame).isNotNull();
    }


    @Test
    @DisplayName("사다리 게임으로부터 사다리를 받아올 수 있다.")
    void getLadderTest() {
        //given
        final Players players = Players.of(Lists.newArrayList("junwoo", "wonoh", "changoo", "sungdong"));
        final Results results = Results.of(Lists.newArrayList("꽝", "꽝", "3000", "꽝"), players.size());

        int maxHeight = 5;
        final LadderGame ladderGame = LadderGame.of(new LadderInfo(players, LadderDifficulty.MEDIUM, results));

        //when
        final Lines lines = ladderGame.lines();

        //then
        assertThat(lines).isNotNull();
        assertThat(lines.stream()).hasSize(LadderDifficulty.MEDIUM.getHeight());
    }

    @Test
    @DisplayName("사다리 게임의 결과를 리턴한다")
    void testFindResults() {
        //given
        final Players players = Players.of(Lists.newArrayList("junwoo", "wonoh", "changoo", "sungdong"));
        final ArrayList<String> resultNames = Lists.newArrayList("꽝", "꽝", "3000", "꽝");
        final Results results = Results.of(resultNames, players.size());
        int maxHeight = 5;

        //when
        final LadderGame ladderGame = LadderGame.of(new LadderInfo(players, LadderDifficulty.MEDIUM, results));
        final String result = ladderGame.findResult(new Player("junwoo"));

        //then
        assertThat(result).isNotNull()
                .isIn(resultNames);
    }
}