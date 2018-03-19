package ladder.domain;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LineTest {

    @Test
    public void checkPreIndexThenPutFalseOrTrue() {
        Line test = new Line(2);
        boolean tester = test.getLine().get(0);
        boolean oppTester = !tester;
        boolean tester2 = test.getLine().get(1);
        assertEquals(oppTester, tester2);
    }

}