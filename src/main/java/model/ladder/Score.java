package model.ladder;

import exception.LadderResultCreateException;
import org.apache.commons.lang3.StringUtils;

public class Score {

    private ScoreType scoreType;

    public Score(String result) {
        validate(result);
        this.scoreType = ScoreType.getMyScoreType(result);
    }

    private void validate(String result) {
        if(StringUtils.isEmpty(result)) {
            throw new LadderResultCreateException("사다리의 결과가 없기 때문에 사다리를 만들 수 없습니다.");
        }
    }
}
