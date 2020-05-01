package ladder.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

import static ladder.constant.LadderConstants.*;
import static ladder.constant.ParticipantConstants.INPUT_SPLIT_TOKEN;

public enum LadderDifficulty {

    HARD(LADDER_DIFFICULTY_HARD,LADDER_DIFFICULTY_HARD_HEIGHT),
    NORMAL(LADDER_DIFFICULTY_NORMAL,LADDER_DIFFICULTY_NORMAL_HEIGHT),
    EASY(LADDER_DIFFICULTY_EASY,LADDER_DIFFICULTY_EASY_HEIGHT);

    private final String difficulty;
    private final int height;

    LadderDifficulty(String difficulty,int height){
        this.difficulty = difficulty;
        this.height = height;
    }
    public static LadderDifficulty of(String difficulty){
        return Arrays.stream(values())
                .filter(ladderDifficulty -> ladderDifficulty.difficulty.equals(difficulty))
                .findAny()
                .orElseThrow(()->new IllegalArgumentException("난이도는"+makeExceptionMessage()+"로만 입력해주세요."));
    }
    private static String makeExceptionMessage(){
        return Arrays.stream(values())
                .map(LadderDifficulty::getDifficulty)
                .collect(Collectors.joining(INPUT_SPLIT_TOKEN));
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
