package model.ladder;

import exception.LadderResultCreateException;
import org.apache.commons.lang3.StringUtils;

public class Score {
    private String value;
    private ScoreType scoreType;
    public Score(final String result) {
        validate(result);
        this.scoreType = ScoreType.getMyScoreType(result);
        this.value = result;
    }

    private void validate(String result) {
        if(StringUtils.isEmpty(result)) {
            throw new LadderResultCreateException("사다리의 결과가 없기 때문에 사다리를 만들 수 없습니다.");
        }
    }

    public String getMyType(){
        return scoreType.getType();
    }

    public String getValue() {
        return value;
    }
}