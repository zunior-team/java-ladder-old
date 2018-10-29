package ladder.view;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {
    @Test
    public void name() {
        System.out.println(String.format("%s, %s", "KOREA", "JAPAN"));
        System.out.println(String.format("%10s", "KOREA"));
        System.out.println(String.format("%-10s", "KOREA"));
    }

    @Test
    public void 출력결과확인_참_step4() {

        String result = ResultView.process(true);
        assertThat(result).isEqualTo("-----");

    }@Test
    public void 출력결과확인_거짓_step4() {

        String result = ResultView.process(false);
        assertThat(result).isEqualTo("     ");
    }
}
