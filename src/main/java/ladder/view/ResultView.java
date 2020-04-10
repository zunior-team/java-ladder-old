package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Participants;

import java.util.List;

public class ResultView {

    private static final String VERTICAL_LINE = "|";
    private static final String LINE = "-----";
    private static final String BLANK = "     ";



    public static void printLadderResult(Participants participants, Ladder ladder){
        participants.getParticipants()
                .forEach(participant -> System.out.print(participant+BLANK));
        System.out.println();
        List<Line> lines = ladder.getLines();
        lines.stream()
                .map(Line::getPoints)
                .forEach(points -> {
                    points.forEach(point -> {
                        System.out.print(VERTICAL_LINE);
                        if (point) {
                            System.out.print(LINE);
                        } else {
                            System.out.print(BLANK);
                        }
                    });
                System.out.print(VERTICAL_LINE);
                System.out.println();
                });
    }
}
