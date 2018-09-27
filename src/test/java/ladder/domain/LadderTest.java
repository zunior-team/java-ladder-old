package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class LadderTest {
    @Test
    public void makeLine(){
        Ladder ladder = new Ladder();
        ladder.makeLine();
        ladder.makeLine();
        assertThat(ladder.getLine().getLines().size()).isEqualTo(2);
    }
}
