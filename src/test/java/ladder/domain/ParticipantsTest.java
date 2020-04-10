package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Participants test")
class ParticipantsTest {

    @DisplayName("참여자이름을 , 로 구분하여 참여자들을 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = "지원오,박성동,김광현,최준우,이찬구")
    void of(String participantNames) {
        Participants participants = Participants.of(participantNames);
        assertThat(participants).isNotNull();
    }
    @DisplayName("참여자들 이름이 비어있으면 익셉션이 발생한다.")
    @EmptySource
    @ParameterizedTest
    void 참여자들_이름_비어있으면_익셉션(String participantNames){
        assertThatThrownBy(()-> Participants.of(participantNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}