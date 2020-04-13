package ladder.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

    @Test
    @DisplayName("Players 에서 참여자 이름으로 Player객체를 찾을 수 있다")
    void testFindByName() {
        //given
        final Players players = Players.of(Lists.newArrayList("junwoo", "hello"));

        //when
        final Player playerByName = players.findByName("junwoo");

        //then
        assertThat(playerByName).isNotNull();
        assertThat(playerByName.getName())
                .isEqualTo("junwoo");
    }

    @Test
    @DisplayName("Players 에서 존재하지 않는 참여자 이름으로 Player객체를 찾으려 하면 Exception을 던진다")
    void testFindByNameNotExists() {
        //given
        final Players players = Players.of(Lists.newArrayList("junwoo", "hello"));

        //then
        assertThrows(IllegalArgumentException.class,
                //when
                () -> players.findByName("junwoo123"));
    }
}