package ladder.domain;

import spark.utils.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Results {
    private List<String> results;

    private Results(List<String> resultNames, Players players) {
        Objects.requireNonNull(players, "참여자 값이 존재하지 않습니다.");
        if (CollectionUtils.isEmpty(resultNames)) {
            throw new IllegalArgumentException("결과 값은 비어 있을 수 없습니다.");
        }
        if (resultNames.size() != players.size()) {
            throw new IllegalArgumentException("결과 갯수가 참여자 수와 다릅니다.");
        }
        this.results = Collections.unmodifiableList(resultNames);
    }

    public static Results of(List<String> resultNames, Players players) {
        return new Results(resultNames, players);
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
