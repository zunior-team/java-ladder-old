package laddergame.view;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ResultViewTest {
    @Test
    public void 라인_출력_확인() {
        String result = ResultView.printHyphen(true);
        assertThat(result).isEqualTo("-----");
    }

    @Test
    public void 공백_출력_확인() {
        String result = ResultView.printHyphen(false);
        assertThat(result).isEqualTo("     ");
    }
}
