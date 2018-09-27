package ladder.view;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class InputViewTest {
    @Test
    public void makeNames(){
        String s = "choising,seungmin,osing";
        List<String> list = InputView.doSplit(s);
        assertEquals(3, list.size());
        assertThat(list.get(0)).isEqualTo("choising");
        assertThat(list.get(1)).isEqualTo("seungmin");
        assertThat(list.get(2)).isEqualTo("osing");
    }
}
