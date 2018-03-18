package ladder;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PositionTest {
    private static final int MAX = 3;

    @Test
    public void isFirst() {
        Position position = new Position(0, MAX);
        assertThat(position.isFirst(), is(true));
    }

    @Test
    public void isLast() {
        Position position = new Position(MAX - 1, MAX);
        assertThat(position.isLast(), is(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void underZero() {
        new Position(-1, MAX);
    }

    @Test(expected = IllegalArgumentException.class)
    public void overMax() {
        new Position(MAX, MAX);
    }

    @Test
    public void moveNext() {
        assertThat(new Position(0, MAX).moveNext(), is(new Position(1, MAX)));
    }

    @Test
    public void movePrevious() {
        assertThat(new Position(1, MAX).movePrevious(), is(new Position(0, MAX)));
    }
}
