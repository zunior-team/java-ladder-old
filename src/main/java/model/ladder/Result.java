package model.ladder;

import exception.LadderResultCreateException;
import org.apache.commons.lang3.StringUtils;

public class Result {

    private int winnerPrice;
    private ResultType type;

    private enum ResultType{
        MONEY, END;
    }

    public Result(String result) {
        validate(result);

        try{
            winnerPrice = Integer.parseInt(result);
        } catch(NumberFormatException) {

        }
        type = ResultType.getMyType(result);
    }

    private void validate(String result) {
        if(StringUtils.isEmpty(result)) {
            throw new LadderResultCreateException("사다리의 결과가 없기 때문에 사다리를 만들 수 없습니다.");
        }
    }
}
