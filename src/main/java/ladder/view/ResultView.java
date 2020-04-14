package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ResultView {

    private static final String VERTICAL_LINE = "|";
    private static final String LINE = "-----";
    private static final String BLANK = "     ";

    public static void printLadder(Participants participants, Ladder ladder, Results results){
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
        results.getResults().forEach(
                result -> System.out.print(result+BLANK));
        System.out.println();
    }
    public static void printLadderResult(Participant participant, LadderResult ladderResult){
        System.out.println("실행 결과");
        if(Objects.isNull(participant)){
            ladderResult.getLadderResult()
                    .forEach((name,result)->{
                        System.out.print(name+" : "+ result);
                        System.out.println();
                    });
            return;
        }
        Result result = ladderResult.getResultByParticipant(participant);
        System.out.println(result);
    }
}
