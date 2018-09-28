package laddergame.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private Line line;

    @Before
    public void before() {
        line = new Line(4);
    }

    @Test
    public void initLadder() {
        assertThat(line).isNotNull();
    }

    @Test
    public void getLine() {
        for (int i = 0; i < 4; i++) {
            assertThat(line.get(i)).isFalse();
        }
    }

    @Test
    public void makeLine() {
        line.makeLine();
        for (int i = 1; i < line.size(); i++) {
            assertThat(line.get(i - 1) && line.get(i)).isFalse();
        }
    }

    @Test
    public void swap() {
        List<String> names = Arrays.asList("1", "2", "3", "4", "5");
        line.set(0, true);
        line.set(1, false);
        line.set(2, true);
        line.set(3, false);
        line.swap(names);
        assertThat(names).isEqualTo(Arrays.asList("2", "1", "4", "3", "5"));
    }
}
