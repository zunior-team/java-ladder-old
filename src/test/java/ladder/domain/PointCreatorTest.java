package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("PointCreator test")
class PointCreatorTest {

    @DisplayName("랜덤포인트를 생성한다.")
    @Test
    void createRandomPoint() {
        boolean randomPoint = PointCreator.createRandomPoint();
        assertThat(randomPoint).isNotNull();
    }
}