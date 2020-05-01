package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("PointCreator test")
class PointCreatorTest {

    @DisplayName("랜덤포인트를 생성한다.")
    @Test
    void createRandomPoint() {
        boolean randomPoint = PointCreator.createRandomPoint();
        assertThat(randomPoint).isNotNull();
    }
    @DisplayName("확률에 따라 랜덤포인트를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {10,20,30,40,50})
    void createRandomPointByPercentage(int percentage){
        boolean randomPoint = PointCreator.createRandomPointByPercentage(percentage);
        assertThat(randomPoint).isNotNull();
    }
}