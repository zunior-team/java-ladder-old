package model.ladder;

import exception.LadderResultCreateException;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

public class LadderResults {

    private List<Result> results;

    private LadderResults(List<String> results) {
        validate(results);
        this.results = results.stream()
                .map(Result::new)
                .collect(Collectors.toList());
    }

    public static LadderResults create(List<String> results) {
        return new LadderResults(results);
    }

    private void validate(List<String> results) {
        if(CollectionUtils.isEmpty(results)){
            throw new LadderResultCreateException("사다리의 결과를 만들 수 없습니다.");
        }
    }
}
