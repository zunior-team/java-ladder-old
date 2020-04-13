package ladder.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ResultsTest {

    @Test
    @DisplayName("결과 이름과 Players 객체로 Results객체를 생성한다")
    void testConstructResults() {
        //given
        final Players players = Players.of(Lists.newArrayList("junwoo", "hello", "hihih", "messi"));
        final ArrayList<String> resultNames = Lists.newArrayList("꽝", "3000", "꽝", "꽝");

        //when
        final Results results = Results.of(resultNames, players);

        //then
        assertThat(results).isNotNull();
    }

    @Test
    @DisplayName("Players 객체가 NULL 이면 NPE를 던진다.")
    void testNullPlayers() {
        //given
        final ArrayList<String> resultNames = Lists.newArrayList("꽝", "3000", "꽝", "꽝");

        //then
        assertThrows(NullPointerException.class, () ->
                //when
                Results.of(resultNames, null));
    }

    @Test
    @DisplayName("Players의 사이즈가 입력받은 결과의 수랑 다르면 Exception을 던진다.")
    void testSize() {
        //given
        final Players players = Players.of(Lists.newArrayList("junwoo", "hello", "hihih", "messi"));
        final ArrayList<String> resultNames = Lists.newArrayList("꽝", "3000", "꽝");

        //then
        assertThrows(IllegalArgumentException.class, () ->
                //when
                Results.of(resultNames, players));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력받은 결과들이 비어있거나 NULL이면 Exception을 던진다.")
    void testResultsInput(List<String> inputResults) {
        //given
        final Players players = Players.of(Lists.newArrayList("junwoo", "hello", "hihih", "messi"));

        //then
        assertThrows(IllegalArgumentException.class, () ->
                //when
                Results.of(inputResults, players));
    }

    @Test
    @DisplayName("names는 unmodifiableList를 리턴한다")
    void testUnmodifiableList() {
        //when
        final Players players = Players.of(Lists.newArrayList("junwoo", "hello", "hihih", "messi"));
        final ArrayList<String> resultNames = Lists.newArrayList("꽝", "3000", "꽝", "꽝");

        //when
        final Results results = Results.of(resultNames, players);
        final List<String> names = results.names();

        //then
        assertThrows(UnsupportedOperationException.class,
                () -> names.set(0, "hello world"));
    }


    @Test
    @DisplayName("index값으로 해당 위치의 결과 이름을 리턴한다")
    void testFindIndex() {
        //when
        final Players players = Players.of(Lists.newArrayList("junwoo", "hello", "hihih", "messi"));
        final ArrayList<String> resultNames = Lists.newArrayList("꽝", "3000", "꽝", "꽝");

        //when
        final Results results = Results.of(resultNames, players);
        final String byIndex = results.findByIndex(0);

        //then
        assertThat(byIndex).isEqualToIgnoringCase("꽝");
    }
}