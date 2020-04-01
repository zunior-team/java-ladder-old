package ladder.domain;

import spark.utils.CollectionUtils;

import java.util.List;

public class LadderGame {
    public static final int MINIMUM_MAX_HEIGHT = 1;
    public static final int MINIMUM_PARTICIPANTS = 2;
    private List<Line> lines;

    private LadderGame(List<String> names, int maxHeight) {
        validateInputs(names, maxHeight);
        //TODO : Line 객체 생성해서 lines 초기화
    }

    private void validateInputs(List<String> names, int maxHeight) {
        validateNames(names);
        validateMaxHeight(maxHeight);
    }

    private void validateMaxHeight(int maxHeight) {
        if (maxHeight < MINIMUM_MAX_HEIGHT) {
            throw new IllegalArgumentException("최대 사다리 높이는 " + MINIMUM_MAX_HEIGHT + " 이상 이어야 합니다.");
        }
    }

    private void validateNames(List<String> names) {
        if (CollectionUtils.isEmpty(names) || names.size() < MINIMUM_PARTICIPANTS) {
            throw new IllegalArgumentException("참여자 수는 최소 " + MINIMUM_PARTICIPANTS + "명 이상이어야 합니다.");
        }
    }

    public static LadderGame of(List<String> names, int maxHeight) {
        return new LadderGame(names, maxHeight);
    }

}
