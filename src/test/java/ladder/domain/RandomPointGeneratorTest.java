package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RandomPointGeneratorTest {

    @ParameterizedTest
    @DisplayName("라인의 이웃하는 포인트가 연속으로 true 일수는 없다")
    @ValueSource(ints = {3, 4, 5})
    void testPoint(int countOfPerson) {
        //when
        RandomPointGenerator randomPointGenerator = new RandomPointGenerator(50);

        //when
        final List<Boolean> points = randomPointGenerator.generate(countOfPerson);

        //then
        assertThat(points).doesNotContainSequence(true, true);
    }

    @ParameterizedTest
    @DisplayName("랜덤 포인트 생성자의 확률은 0보다 크고 100보다 작아야 한다.")
    @ValueSource(ints = {-1, -5, 101, 1000})
    void testRandomPercentageValidate(int randomPercentage) {
        //then
        assertThrows(IllegalArgumentException.class, () ->
                //when
                new RandomPointGenerator(randomPercentage));
    }
}