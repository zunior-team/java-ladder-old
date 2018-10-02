package ladder;

import org.junit.Test;

public class AllLineTest {
    @Test
    public void fiveCharacter() {
        InputView.nameCheck("skulllllllll");
    }

    @Test
    public void reCallTest() {
        int cur = 0;
        for (int i = 0; i < 4; i++) {
            cur = a(cur);
            System.out.println(cur);
        }
    }
    private static int a(int cur) {
        cur++;
        return cur;
    }
}
