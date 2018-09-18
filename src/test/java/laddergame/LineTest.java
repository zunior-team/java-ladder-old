package laddergame;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LineTest {

    List<Integer> line;

    @Before
    public void setUp() {
        this.line = new ArrayList<Integer>();
        line.add(Line.VERTICAL);
        line.add(Line.NONE);
        line.add(Line.VERTICAL);
//        line.add(Line.HORIZONTAL);
//        line.add(Line.VERTICAL);
    }

    @Test
    public void checkHorizon() {
        assertEquals(2, Line.checkHorizon(1, line));
    }

    @Test
    public void checkLine() {
        assertEquals(1, Line.checkLine(2, line));
    }

}