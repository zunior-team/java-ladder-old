package ladder.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@DisplayName("사다리 객체 테스트")
class LadderTest {

    @Test
    @DisplayName("참여자 이름과 라인들을 가지고 사다리 객체를 생성한다.")
    void testCreateLadder() {
        //given
        final int countOfPerson = 5;
        List<String> names = Lists.newArrayList("junwoo", "wonoh", "changoo");
        List<Line> lines = Lists.newArrayList(Line.of(countOfPerson));

        //when
        final Ladder ladder = Ladder.of(names, lines);

        //then
        assertThat(ladder).isNotNull();
    }

    @ParameterizedTest
    @CsvSource({"0,0", "-1,-1", "1,1", "4,5"})
    @DisplayName("참여자 이름과 라인들을 가지고 사다리 객체를 생성한다.")
    void testValidateCreateLadder(int sizeOfNames, int sizeOfLines) {
        //given
        List<String> names = Mockito.anyList();
        List<Line> lines = Mockito.anyList();
        given(names.size()).willReturn(sizeOfNames);
        given(lines.size()).willReturn(sizeOfLines);

        //then
        assertThrows(IllegalArgumentException.class,
                //when
                () -> Ladder.of(names, lines));
    }

    @Test
    @DisplayName("사다리 객체로 사다리 Map 객체를 받아올 수 있다.")
    void testGetLadderMap() {
        //given
        final int countOfPerson = 5;
        List<String> names = Lists.newArrayList("junwoo", "wonoh", "changoo");
        List<Line> lines = Lists.newArrayList(Line.of(countOfPerson));
        final Ladder ladder = Ladder.of(names, lines);

        //when
        final Map<String, Line> ladderMap = ladder.getLadderMap();

        //then
        assertThat(ladderMap).isNotNull()
                .isNotEmpty();
    }
}