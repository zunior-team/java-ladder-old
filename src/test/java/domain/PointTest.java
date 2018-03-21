package domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PointTest {
    Point point;
    Direction direction;

    @Before
    public void setup() {

    }

    @Test
    public void moveRight() {
        direction = Direction.of(false, true);
        point = new Point(0, direction);
        assertThat(point.move(), is(1));
    }

    @Test
    public void moveLeft() {
        direction = Direction.of(true, false);
        point = new Point(1, direction);
        assertThat(point.move(), is(0));
    }
}
