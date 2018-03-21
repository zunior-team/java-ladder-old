package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class LadderLineTest {
    @Test
    public void init() {
        int sizeOfPerson = 5;
        LadderLine ladderLine = LadderLine.init(sizeOfPerson);
        List<Point> points = ladderLine.getPoints();
        assertThat(5, is(points.size()));
    }
}