package laddergame.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {

    Position p;
    int idx;
    int horizonIdx;
    int length;

    @Before
    public void setUp() {
        idx = 1;
        horizonIdx = 1;
        length = 4;

        // direction : right
        p = new Position(idx, horizonIdx, length);
    }

    @Test
    public void checkLorR() {
        assertEquals(Direction.RIGHT, Position.checkLorR(idx, horizonIdx));
    }

    @Test
    public void hasDirection() {
        assertEquals(Direction.NONE, Position.hasDirection(1,3,3));
    }

    @Test
    public void move() {
        // direction == RIGHT => idx + 1
        assertEquals(2, p.move(idx));
    }

}