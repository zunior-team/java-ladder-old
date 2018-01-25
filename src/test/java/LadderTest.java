import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LadderTest {
    private static final Logger logger = LoggerFactory.getLogger(LadderTest.class);
    Ladder ladder;
    LadderInput input;

    @Before
    public void setUp() {
        ladder = new Ladder();
        LadderInput input = new LadderInput();
    }

//    @Test
//    public void addLadder() {
//        Boolean add = ladder.returnAdd(6);
//        assertEquals(true, add);
//    }
//
//    @Test
//    public void notAddLadder() {
//        Boolean notAdd = ladder.returnAdd(4);
//        assertEquals(false, notAdd);
//    }

}
