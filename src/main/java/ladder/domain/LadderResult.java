package ladder.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class LadderResult {

    private Map<Participant,Result> ladderResult;

    public LadderResult(Map<Participant,Result> ladderResult){
        validateLadderResult(ladderResult);
        this.ladderResult = ladderResult;
    }

    private void validateLadderResult(Map<Participant, Result> ladderResult) {
        if(Objects.isNull(ladderResult)){
            throw new IllegalArgumentException("결과는 널일수 없습니다.");
        }
    }
    public Result getResultByParticipant(Participant participant){
        return ladderResult.get(participant);
    }

    public Map<Participant, Result> getLadderResult() {
        return Collections.unmodifiableMap(ladderResult);
    }
}
