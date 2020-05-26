package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("Line test")
class LineTest {

    @DisplayName("라인의 width 값으로 한 라인을 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {3,4,5})
    void of(int width) {
        int percentage = 30;
        Line line = Line.of(width,percentage);
        assertThat(line).isNotNull();
    }
    @DisplayName("라인의 width 값이 1이하일 경우 익셉션이 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1,0,1})
    void width_1이하_익셉션(int width) {
        int percentage = 30;
        assertThatThrownBy(()-> Line.of(width,percentage))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("생성된 라인은 겹치는 경우가 없다.")
    @ParameterizedTest
    @ValueSource(ints = {3,4,5})
    void 옆라인_겹치지않음(int width) {
        int percentage = 30;
        Line line = Line.of(width,percentage);
        List<Boolean> points = line.getPoints();
        for (int i = 1; i < points.size(); i++) {
            Boolean previousPoint = points.get(i-1);
            Boolean currentPoint = points.get(i);
            if(previousPoint && currentPoint){
                fail();
            }
        }
    }
}