package laddergame;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    @Test
    public void checkName_5초과일때() {
        String input = "aaaaaa,b,c,d";
        boolean result = InputView.checkName(input);
        assertThat(result).isFalse();
    }

    @Test
    public void checkName_5이하일때() {
        String input = "a,b,c,d,e";
        boolean result = InputView.checkName(input);
        assertThat(result).isTrue();
    }
}
