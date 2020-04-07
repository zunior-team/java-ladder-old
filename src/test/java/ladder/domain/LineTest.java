package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("라인 객체 테스")
class LineTest {

    @Test
    @DisplayName("참여자 수로 라인 객체를 생성한다")
    void createWithCountOfPerson() {
        //given
        int countOfPerson = 5;

        //when
        final Line line = Line.of(countOfPerson, new Random());

        //then
        assertThat(line).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    @DisplayName("참여자 수는 최소 2 이상이다")
    void testMinimumCountOfPerson(int countOfPerson) {
        //then
        assertThrows(IllegalArgumentException.class,
                //when
                () -> Line.of(countOfPerson, new Random()));
    }

    @ParameterizedTest
    @DisplayName("라인의 이웃하는 포인트가 연속으로 true 일수는 없다")
    @ValueSource(ints = {3, 4, 5})
    void testPoint(int countOfPerson) {
        //when
        final Line line = Line.of(countOfPerson, new Random());

        //then
        final List<Boolean> points = line.points();
        assertThat(points).doesNotContainSequence(true, true);
    }
}