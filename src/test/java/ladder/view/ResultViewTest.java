package ladder.view;

import org.junit.Test;

public class ResultViewTest {
    @Test
    public void name() {
        System.out.println(String.format("%s, %s", "KOREA", "JAPAN"));
        System.out.println(String.format("%10s", "KOREA"));
        System.out.println(String.format("%-10s", "KOREA"));
    }
}
