package laddergame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LadderTest {
    Ladder ladder;

    @Before
    public void setUp() {
        this.ladder = new Ladder(2, 3);
    }

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