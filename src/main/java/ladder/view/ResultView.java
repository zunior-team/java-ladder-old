package ladder.view;

import ladder.domain.Line;
import ladder.domain.Players;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    private static final String SPACE_BETWEEN_NAMES = "    ";
    private static final String ONE_SHORT_LINE = "|";
    private static final String BAR_LINE = "--------";
    private static final String EMPTY_SPACE_BETWEEN_BAR = "        ";

    public void printResult(Players players, List<Line> ladder) {
        System.out.println("실행 결과");

        System.out.println(String.join(SPACE_BETWEEN_NAMES, players.names()));

        ladder.stream()
                .map(this::convertToPrintFormat)
                .forEachOrdered(System.out::println);
    }

    private String convertToPrintFormat(Line line) {
        final StringBuilder lineStringBuilder = new StringBuilder(ONE_SHORT_LINE);
        IntStream.range(0, line.playerCount())
                .forEach(index -> {
                    lineStringBuilder.append(line.hasBridge(index) ? BAR_LINE : EMPTY_SPACE_BETWEEN_BAR);
                    lineStringBuilder.append(ONE_SHORT_LINE);
                });
        return lineStringBuilder.toString();
    }
}
