package laddergame.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LineTest {

    List<Boolean> line;

    @Before
    public void setUp() {
        this.line = new ArrayList<>();
        line.add(true);
        line.add(false);
        line.add(false);
//        line.add(Line.HORIZONTAL);
//        line.add(Line.VERTICAL);
    }

    @Test
    public void checkHorizon() {
        assertEquals(false, Line.checkHorizon(true, line));
    }


}