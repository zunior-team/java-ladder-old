package laddergame.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DirectionTest {
    Direction d1;
    Direction d2;
    Direction d3;

    @Before
    public void setUp() {
        d1 = new Direction(Direction.RIGHT); // 오른쪽
        d2 = new Direction(Direction.NONE); // 없음
        d3 = new Direction(Direction.LEFT); // 왼쪽
    }

    @Test
    public void isRight() {
        assertEquals(Boolean.TRUE, d1.isRight());
        assertEquals(Boolean.FALSE, d2.isRight());
        assertEquals(Boolean.FALSE, d3.isRight());
    }

    @Test
    public void isLeft() {
        assertEquals(Boolean.FALSE, d1.isLeft());
        assertEquals(Boolean.FALSE, d2.isLeft());
        assertEquals(Boolean.TRUE, d3.isLeft());
    }

}