package ladder.view;

import ladder.domain.Line;
import ladder.domain.Players;

import java.util.List;

public class ResultView {

    private static final String SPACE_BETWEEN_NAMES = "    ";
    private static final String ONE_SHORT_LINE = "|";
    private static final String BAR_LINE = "--------";
    private static final String EMPTY_SPACE_BETWEEN_BAR = "        ";

    public void printResult(Players players, List<Line> ladder) {
        System.out.println("실행 결과");

        System.out.println(String.join(SPACE_BETWEEN_NAMES, players.names()));

        for (Line line : ladder) {
            printLine(line);
        }

    }

    private void printLine(Line line) {
        final List<Boolean> points = line.points();
        final StringBuilder lineStringBuilder = new StringBuilder(ONE_SHORT_LINE);
        for (Boolean point : points) {
            lineStringBuilder.append(point ? BAR_LINE : EMPTY_SPACE_BETWEEN_BAR);
            lineStringBuilder.append(ONE_SHORT_LINE);
        }

        System.out.println(lineStringBuilder.toString());
    }
}
