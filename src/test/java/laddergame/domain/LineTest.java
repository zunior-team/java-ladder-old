package laddergame.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LineTest {

    Line line;

    @Before
    public void setUp() {
        line = new Line();
        line.makeLine(3, 1);
    }

    @Test
    public void checkHorizon() {
        assertEquals(1, line.move(2));
    }


}