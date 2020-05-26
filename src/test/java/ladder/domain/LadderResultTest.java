package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LadderResult test")
class LadderResultTest {

    private LadderGame ladderGame;
    private Participants participants;

    @BeforeEach
    void initLadderGame(){
        participants = Participants.of("a,b,c,d,e");
        ladderGame = new LadderGame(Ladder.of(5,LadderDifficulty.EASY)
                ,participants
                ,new Results("1,200,300,꽝,꽝"));
    }
    @DisplayName("생성")
    @Test
    void 생성(){
        LadderResult ladderResult = ladderGame.play();
        assertThat(ladderResult).isNotNull();
    }
    @DisplayName("참여자를 입력받아 참여자의 결과를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a","b","c"})
    void getResultByParticipant(String participantName){
        LadderResult ladderResult = ladderGame.play();
        Participant participant = participants.getParticipantByName(participantName);
        System.out.println(ladderResult.getLadderResult());
        Result result = ladderResult.getResultByParticipant(participant);
        assertThat(result).isNotNull();
    }
}