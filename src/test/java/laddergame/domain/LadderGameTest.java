package laddergame.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    @Test
    public void 사다리_생성_개수_확인() {
        LadderGame lg = new LadderGame("a,b,c,", "1,2,3");
        lg.makeLadder(4);
        assertThat(lg.getLines().size()).isEqualTo(4);
    }
}
