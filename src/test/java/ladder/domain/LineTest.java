package ladder.domain;

import ladder.domian.Line;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

import java.util.List;

public class LineTest {
    @Test
    public void duplicateTest(){
        Line line = new Line(100);
        List<Boolean> points = line.getPoints();
        for (int i = 1; i < points.size(); i++) {
            assertFalse(points.get(i - 1) && points.get(i));
        }
    }
}
