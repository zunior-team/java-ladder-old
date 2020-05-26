package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ladder.constant.LadderConstants.LADDER_MIN_HEIGHT;
import static ladder.constant.ParticipantConstants.PARTICIPANT_MIN_COUNT;

public class Ladder {

    private List<Line> lines;
    private int lineWidth;

    private Ladder(int countOfParticipant, LadderDifficulty ladderDifficulty){
        validateLadderDifficulty(ladderDifficulty);
        int height = ladderDifficulty.getHeight();
        int percentage = ladderDifficulty.getPercentage();
        validateParticipantAndMaxHeight(countOfParticipant,height);

        this.lineWidth = countOfParticipant - 1;
        this.lines = IntStream.range(0, height)
                .mapToObj(i -> Line.of(lineWidth,percentage))
                .collect(Collectors.toList());
    }

    private void validateLadderDifficulty(LadderDifficulty ladderDifficulty) {
        if(Objects.isNull(ladderDifficulty)){
            throw new IllegalArgumentException("난이도는 널일 수 없습니다.");
        }
    }

    public static Ladder of(int countOfParticipant,LadderDifficulty ladderDifficulty){
        return new Ladder(countOfParticipant,ladderDifficulty);
    }

    private static void validateParticipantAndMaxHeight(int countOfParticipant,int maxHeight){
        if(countOfParticipant < PARTICIPANT_MIN_COUNT){
            throw new IllegalArgumentException("참여자는"+PARTICIPANT_MIN_COUNT+"이상 이어야 합니다.");
        }
        if(maxHeight < LADDER_MIN_HEIGHT){
            throw new IllegalArgumentException("사다리 높이는"+LADDER_MIN_HEIGHT+"이상 이어야 합니다.");
        }

    }
    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
    public int getLineWidth() {
        return lineWidth;
    }
    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                '}';
    }
}
