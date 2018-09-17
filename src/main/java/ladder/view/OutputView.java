package ladder.view;

import ladder.domian.Ladder;
import ladder.domian.Line;

import java.util.List;

public class OutputView {
    private final static String FORMAT = "%-6s";
    private static final String VERTICAL_BAR = "|";
    private static final String HORIZONTAL_BAR = "-----";
    private static final String BLANK = "     ";

    public static void printPeopleName(List<String> peopleName) {
        StringBuilder sb = new StringBuilder();
        for (String name : peopleName) {
            sb.append(String.format(FORMAT, name));
        }
        System.out.println(sb.toString());
    }

    public static void printLadder(Ladder ladder) {
        System.out.println(stringifyLines(ladder.getLines()));
    }

    private static String stringifyLines(List<Line> lines) {
        StringBuilder sb = new StringBuilder();
        for (Line l : lines) {
            sb.append(stringifyPoints(l.getPoints()));
        }
        return sb.toString();
    }

    private static String stringifyPoints(List<Boolean> points) {
        StringBuilder sb = new StringBuilder();
        sb.append((VERTICAL_BAR));
        for (Boolean point : points) {
            sb.append(point ? HORIZONTAL_BAR : BLANK);
            sb.append((VERTICAL_BAR));
        }
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}