package laddergame.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LadderTest {

    private Ladder ladder;

    @Before
    public void before(){
        ladder = new Ladder(3,4);
    }

    @Test
    public void initLadder(){
        assertThat(ladder).isNotNull();
    }

    @Test
    public void size(){
        assertThat(ladder.size()).isEqualTo(4);
    }
}
