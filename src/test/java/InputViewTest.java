import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import view.InputView;

public class InputViewTest {
    InputView input;

    @Before
    public void setup() {
        input = new InputView();
    }

    //    사다리 결과를 출력할 때 최대 5 글자를 정확히 출력하는지 처리하는 로직에 대한 테스트를 추가한다.
    @Test
    public void namesNum() {
        String[] names = new String[]{"dae"};
        boolean n = input.namesNum(names);
        assertThat(n).isEqualTo(false);
    }

    @After
    public void teardrop() {
    }

}
