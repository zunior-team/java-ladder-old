package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovementTest {
    Movement mt = new Movement();

    @Test(expected = IllegalArgumentException.class)
    public void 익셉션확인() {
        String a = "a,b,cdefghi";
        mt.nameCut(a);
    }

    // alt + insert
    @Test
    public void 객체값확인() {
        String name = "a,b,c,d";
        int b = 3;
        assertThat(mt.ladderObject(b, name).size()).isEqualTo(3);
    }
}
