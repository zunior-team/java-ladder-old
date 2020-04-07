package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class PlayersTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    @DisplayName("참여자 수는 최소 2 이상이다")
    void testMinimumCountOfPerson(int countOfPerson) {
        //given
        List<String> names = mock(ArrayList.class);
        given(names.size()).willReturn(countOfPerson);

        //then
        assertThrows(IllegalArgumentException.class,
                //when
                () -> Players.of(names));
    }

}