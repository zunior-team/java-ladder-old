import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LadderTest {
    private static final Logger logger = LoggerFactory.getLogger(LadderTest.class);
    Ladder ladder;
    // class area
    LadderInput input;

    @Before
    public void setUp() {
        ladder = new Ladder();
        LadderInput input = new LadderInput();
    }

    @Test
    public void peopleInput() {
        int people = ladder.peopleInput("3");
        assertEquals(3, people);
    }

    @Test
    public void ladderInput() {
        int height = ladder.peopleInput("5");
        assertEquals(5, height);
    }

    @Test
    public void addLadder() {
        String add = ladder.add(6);
        assertEquals("-", add);
    }

    @Test
    public void notAddLadder() {
        String notAdd = ladder.add(4);
        assertEquals(" ", notAdd);
    }
}
