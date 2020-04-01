package ladder.domain;

import spark.utils.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ladder.domain.LadderGame.MINIMUM_PARTICIPANTS;

public class Ladder {

    private Map<String, Line> ladder;

    private Ladder(List<String> names, List<Line> lines) {
        validateParameters(names, lines);
        final HashMap<String, Line> ladder = new HashMap<>();
        for (int i = 0; i < names.size(); i++) {
            ladder.put(names.get(i), lines.get(i));
        }

        this.ladder = Collections.unmodifiableMap(ladder);
    }

    public Map<String, Line> getLadderMap() {
        return ladder;
    }

    private void validateParameters(List<String> names, List<Line> lines) {
        validateNames(names);
        validateLines(lines);
        validateEachSize(names, lines);
    }

    private void validateEachSize(List<String> names, List<Line> lines) {
        if (names.size() != lines.size()) {
            throw new IllegalArgumentException("참여자 수와 라인 수는 다를 수 없습니다");
        }
    }

    private void validateLines(List<Line> lines) {
        if (CollectionUtils.isEmpty(lines)) {
            throw new IllegalArgumentException("lines 은 비거나 NULL 일 수 없습니다.");
        }
    }

    private void validateNames(List<String> names) {
        if (CollectionUtils.isEmpty(names) || names.size() < MINIMUM_PARTICIPANTS) {
            throw new IllegalArgumentException("참여자 수는 최소 " + MINIMUM_PARTICIPANTS + "명 이상이어야 합니다.");
        }
    }


    public static Ladder of(List<String> names, List<Line> lines) {
        return new Ladder(names, lines);
    }
}
