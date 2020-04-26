package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Lines 테스트")
class LinesTest {

    @Test
    @DisplayName("플레이어 수와 PointGenerator로 Lines객체를 생성한다")
    void testConstructor() {
        final Lines lines = Lines.of(5, new RandomPointGenerator(new Random(System.currentTimeMillis())));

        assertThat(lines)
                .isNotNull();
    }


}