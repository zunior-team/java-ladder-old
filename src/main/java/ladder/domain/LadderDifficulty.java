package ladder.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static ladder.constant.LadderConstants.*;
import static ladder.constant.ParticipantConstants.INPUT_SPLIT_TOKEN;

public enum LadderDifficulty {

    HARD(LADDER_DIFFICULTY_HARD,LADDER_DIFFICULTY_HARD_HEIGHT),
    NORMAL(LADDER_DIFFICULTY_NORMAL,LADDER_DIFFICULTY_NORMAL_HEIGHT),
    EASY(LADDER_DIFFICULTY_EASY,LADDER_DIFFICULTY_EASY_HEIGHT);

    private final String difficulty;
    private final int height;

    private static final Map<String,LadderDifficulty> ladderDifficulties =
            Arrays.stream(values())
            .collect(Collectors.toMap(LadderDifficulty::getDifficulty, Function.identity()));

    LadderDifficulty(String difficulty,int height){
        this.difficulty = difficulty;
        this.height = height;
    }

    public static LadderDifficulty findLadderDifficulty(String difficulty){
        if(!ladderDifficulties.containsKey(difficulty)){
            throw new IllegalArgumentException("난이도는"+makeExceptionMessage()+"로만 입력해주세요.");
        }
        return ladderDifficulties.get(difficulty);
    }

    private static String makeExceptionMessage(){
        return String.join(INPUT_SPLIT_TOKEN, ladderDifficulties.keySet());
    }

    public int getPercentage(){
        return height * LADDER_HEIGHT_PERCENTAGE_MULTIPLY;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getHeight() {
        return height;
    }
}
