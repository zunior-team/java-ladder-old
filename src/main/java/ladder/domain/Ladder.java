package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ladder.constant.LadderConstants.LADDER_MIN_HEIGHT;
import static ladder.constant.ParticipantConstants.PARTICIPANT_MIN_COUNT;

public class Ladder {

    private List<Line> lines;

    private Ladder(int countOfParticipant,int maxHeight){
        validateParticipantAndMaxHeight(countOfParticipant,maxHeight);

        int lineWidth = countOfParticipant - 1;
        this.lines = IntStream.range(0, maxHeight)
                .mapToObj(i -> Line.of(lineWidth))
                .collect(Collectors.toList());
    }

    public static Ladder of(int countOfParticipant,int maxHeight){
        return new Ladder(countOfParticipant,maxHeight);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    private static void validateParticipantAndMaxHeight(int countOfParticipant,int maxHeight){
        if(countOfParticipant < PARTICIPANT_MIN_COUNT){
            throw new IllegalArgumentException("참여자는"+PARTICIPANT_MIN_COUNT+"이상 이어야 합니다.");
        }
        if(maxHeight < LADDER_MIN_HEIGHT){
            throw new IllegalArgumentException("사다리 높이는"+LADDER_MIN_HEIGHT+"이상 이어야 합니다.");
        }

    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                '}';
    }
}
