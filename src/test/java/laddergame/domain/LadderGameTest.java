package laddergame.domain;

import laddergame.domain.LadderGame;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    @Test
    public void 사다리_생성_개수_확인() {
        LadderGame lg = new LadderGame();
        lg.playGame("a,b,c", 4);
        assertThat(lg.getLines().size()).isEqualTo(4);
    }
}
