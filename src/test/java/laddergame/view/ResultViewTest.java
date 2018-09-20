package laddergame.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ResultViewTest {

    List<Boolean> line;

    @Before
    public void setUp(){
        line = new ArrayList<Boolean>();
        line.add(true);
        line.add(false);
    }

    @Test
    public void drawLine(){
        assertEquals("|     |-----|", ResultView.drawLine(line));
    }


}