package model.ladder;

import exception.LadderResultCreateException;
import org.apache.commons.lang3.StringUtils;

public class Result {

    private int score;
    private ResultType type;

    private enum ResultType{
        POINT, END;
    }

    public Result(String result) {
        validate(result);

        try{
            score = Integer.parseInt(result);
            type = ResultType.POINT;
        } catch(NumberFormatException e) {
            score = 0;
            type = ResultType.END;
        }

        validateNegative();
    }

    private void validate(String result) {
        if(StringUtils.isEmpty(result)) {
            throw new LadderResultCreateException("사다리의 결과가 없기 때문에 사다리를 만들 수 없습니다.");
        }
    }

    private void validateNegative(){
        if(score < 0){
            throw new LadderResultCreateException("들어온 점수가 음수이기 때문에 사다리를 만들 수 없습니다.");
        }
    }
}
