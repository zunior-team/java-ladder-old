package laddergame.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LadderTest {
    Ladder ladder;

    @Before
    public void setUp() {
        this.ladder = new Ladder(2, 3);
    }

    // get 메소드로 꺼낸 list에 값 삽입이 안되는지 확인하는 테스트
    @Test
    public void getLadder() {
        boolean exceptionThrown = false;

        try {
            ladder.getLadder().add(new Line(4));
        } catch (UnsupportedOperationException ex) {
            ex.printStackTrace();
            exceptionThrown = true;
        }

        assertTrue(exceptionThrown);
    }

}