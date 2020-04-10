package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Participant test")
class ParticipantTest {

    @DisplayName("이름으로 참여자를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"지원오","박성동","김광현","최준우","이찬구"})
    void of(String name) {
        Participant participant = Participant.of(name);
        assertThat(participant).isNotNull();
    }
    @DisplayName("이름이 비어있으면 익셉션이 발생한다.")
    @EmptySource
    @ParameterizedTest
    void 이름비어있음_익셉션(String name){
        assertThatThrownBy(()-> Participant.of(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("이름이 5글자를 초과하면 익셉션이 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"지원오입니다","박성동입니다","김광현입니다","최준우입니다","이찬구입니다"})
    void 이름_5글자초과_익셉션(String name) {
        assertThatThrownBy(()-> Participant.of(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}