package model.ladder;

import exception.LadderCreateException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int ZERO_HEIGHT = 0;
    private final List<Line> lines;

    private Ladder(int height){
        lines = IntStream.rangeClosed(1, height)
                .mapToObj(Line::of)
                .collect(Collectors.toList());
    }

    public static Ladder of(int height) {
        validate(height);
        return new Ladder(height);
    }

    private static void validate(int height){
        if(height <= ZERO_HEIGHT){
            throw new LadderCreateException("높이가 0 이하이기 때문에 사다리를 만들지 못합니다.");
        }
    }
}
