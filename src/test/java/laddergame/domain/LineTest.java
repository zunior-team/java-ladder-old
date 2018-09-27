package laddergame.domain;

import laddergame.domain.Line;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LineTest {
    @Test
    public void Line_생성자() {
        Line line = new Line(3);
        assertThat(line.getLines().size()).isEqualTo(2);
    }

    @Test
    public void 연속된_라인_생성_방지() {
        boolean preresult = true;
        boolean result = Line.isMakeLine(preresult);
        assertThat(result).isFalse();
    }
}
