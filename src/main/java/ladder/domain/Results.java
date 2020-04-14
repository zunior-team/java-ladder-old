package ladder.domain;

import spark.utils.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static ladder.constant.ParticipantConstants.INPUT_SPLIT_TOKEN;

public class Results {

    private List<Result> results;

    public Results(String inputResults){
        validateInputResults(inputResults);
        this.results = Arrays.stream(inputResults.split(INPUT_SPLIT_TOKEN))
                .map(Result::new)
                .collect(Collectors.toList());
    }

    private void validateInputResults(String inputResults) {
        if(StringUtils.isEmpty(inputResults)){
            throw new IllegalArgumentException("결과는 비어있을수 없습니다.");
        }
    }
    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }

}
