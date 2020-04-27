package ladder.domain;

import spark.utils.CollectionUtils;

import java.util.Collections;
import java.util.List;

public class Results {
    private final List<String> results;

    private Results(List<String> resultNames, int playerCount) {
        if (CollectionUtils.isEmpty(resultNames)) {
            throw new IllegalArgumentException("결과 값은 비어 있을 수 없습니다.");
        }
        if (resultNames.size() != playerCount) {
            throw new IllegalArgumentException("결과 갯수가 참여자 수와 다릅니다.");
        }
        this.results = Collections.unmodifiableList(resultNames);
    }

    public static Results of(List<String> resultNames, int playerCount) {
        return new Results(resultNames, playerCount);
    }

    public String findByIndex(int index) {
        if (index < 0 || index >= results.size()) {
            throw new IllegalArgumentException("유효하지 않은 index : [" + index + "] 입니다. ");
        }
        return results.get(index);
    }

    public List<String> names() {
        return Collections.unmodifiableList(results);
    }
}
