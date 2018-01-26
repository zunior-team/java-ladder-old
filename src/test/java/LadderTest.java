import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;

public class LadderTest {
    private static final Logger logger = LoggerFactory.getLogger(LadderTest.class);
    Ladder ladder;
    ArrayList<Line> lines;
    @Before
    public void setUp() {
        Line line = new Line();
        ladder = new Ladder();
        lines = ladder.createLines(5, 3);
    }

    @Test
    public void createLinesTest(){
        lines = ladder.createLines(5,3);
        assertEquals(lines.size(),3);
    }
    
    @Test
    public void addLadder() {
        Boolean add = ladder.returnAdd(6);
        assertEquals(true, add);
    }

    @Test
    public void notAddLadder() {
        Boolean notAdd = ladder.returnAdd(4);
        assertEquals(false, notAdd);
    }
}
