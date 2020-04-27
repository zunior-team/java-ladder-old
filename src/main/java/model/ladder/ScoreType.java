package model.ladder;

import exception.LadderResultCreateException;
import org.apache.commons.lang3.StringUtils;

public enum ScoreType {

    POINT(StringUtils.EMPTY),
    FAIL("꽝");

    private String name;

    ScoreType(String name){
        this.name = name;
    }

    public static ScoreType getMyScoreType(final String result){
        if(isSameToFail(result)){
            return FAIL;
        }

        validateHangul(result);
        validateNegative(result);

        return POINT;
    }

    private static void validateHangul(String result){
        try {
            Integer.parseInt(result);
        } catch(NumberFormatException e){
            throw new LadderResultCreateException("꽝 대신 다른 예약어가 들어왔기 때문에 점수를 확인할 수 없습니다.");
        }
    }

    private static void validateNegative(String result) {
        if(Integer.parseInt(result) < 0){
            throw new LadderResultCreateException("점수가 음수로 들어왔기 때문에 점수를 확인할 수 없습니다.");
        }
    }

    private static boolean isSameToFail(String result){
        return result.equals(FAIL.name);
    }

    public String getType(){
        return this.name;
    }
}
