import static org.assertj.core.api.Assertions.assertThat;

import ladder.Line;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class LineTest {
    Line line;

    @Before
    public void setup() {
        line = new Line();
    }

    // Line 객체에서 선을 그릴 수 있는지 여부를 판단하는 로직에 대한 단위 테스트를 반드시 추가한다.
    // ArrayList를 사용하며 add 와 get만 많이 써보았지만, 다른 방법들을 많이 사용하지 않았기 때문에,
    // 테스트 코드로 set도 한번 사용해보았다.
    @Test
    public void checkNextLine() {
        ArrayList<Boolean> points = new ArrayList();
        points.set(0, true);
        points.set(1, false);
        assertThat(points.get(1)).isEqualTo(false);
    }


    @After
    public void teardrop() {
    }
}