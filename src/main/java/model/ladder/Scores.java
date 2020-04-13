package model.ladder;

import exception.LadderResultCreateException;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Scores {

    private List<Score> scores = new ArrayList<>();

    private Scores(final List<String> results) {
        validate(results);
        this.scores = results.stream()
                .map(Score::new)
                .collect(Collectors.toList());
    }

    public static Scores create(List<String> results) {
        return new Scores(results);
    }

    private void validate(List<String> results) {
        if(CollectionUtils.isEmpty(results)){
            throw new LadderResultCreateException("사다리의 결과를 만들 수 없습니다.");
        }
    }

    public List<String> getScores(){
        return Collections.unmodifiableList(
                scores.stream()
                        .map(Score::getValue)
                        .collect(Collectors.toList()));
    }

    public int getScoreCount(){
        return scores.size();
    }

    public Score getScoreByIndex(int index){
        return scores.get(index);
    }
}
