package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class RandomPointGeneratorTest {

    @ParameterizedTest
    @DisplayName("라인의 이웃하는 포인트가 연속으로 true 일수는 없다")
    @ValueSource(ints = {3, 4, 5})
    void testPoint(int countOfPerson) {
        //when
        RandomPointGenerator randomPointGenerator = new RandomPointGenerator(new Random());

        //when
        final List<Boolean> points = randomPointGenerator.generate(countOfPerson);

        //then
        assertThat(points).doesNotContainSequence(true, true);
    }
}