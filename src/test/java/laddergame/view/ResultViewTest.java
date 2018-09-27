package laddergame.view;

import laddergame.domain.Position;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ResultViewTest {

    List<Position> line;

    @Before
    public void setUp() {
        int horizonIdx = 1;
        int length = 3;
        line = new ArrayList<Position>();

        line.add(new Position(0, horizonIdx, length));
        line.add(new Position(1, horizonIdx, length));
        line.add(new Position(2, horizonIdx, length));
    }

    @Test
    public void drawLine() {
        assertEquals("|     |-----|", ResultView.drawLine(line));
    }


}