package ladder;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LineTest {
    @Test
    public void move_stay() {
        List<Boolean> points = Arrays.asList(Boolean.FALSE, Boolean.FALSE);
        Line line = new Line(points);
        assertThat(line.move(0), is(0));
        assertThat(line.move(1), is(1));
    }

    @Test
    public void move_right() {
        List<Boolean> points = Arrays.asList(Boolean.TRUE, Boolean.FALSE);
        Line line = new Line(points);
        assertThat(line.move(0), is(1));
    }

    @Test
    public void move_left() {
        List<Boolean> points = Arrays.asList(Boolean.TRUE, Boolean.FALSE);
        Line line = new Line(points);
        assertThat(line.move(1), is(0));
    }
}
