package laddergame.view;

import laddergame.domain.Line;

import java.util.List;

public class ResultView {

    static final String NONE = "     ";
    static final String HORIZONTAL = "-----";
    static final String VERTICAL = "|";

    static final int NAMELENLIMIT = 6;

    public static int printPeopleLength(String[] people) {
        for (int i = 0; i < people.length; i++) {
            System.out.print(makeIndent(people[i]));
        }
        System.out.print("\n");
        return people.length;
    }

    public static String makeIndent(String name) {
        StringBuilder sb = new StringBuilder(name);
        int indentLen = NAMELENLIMIT - name.length();

        for (int i = 0; i < indentLen; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void printLadder(List<Line> ladder) {
        for (Line line : ladder) {
            System.out.println(drawLine(line.getLine()));
        }
    }

    public static String drawLine(List<Boolean> line) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < (2 * line.size()) + 1; i++) {
            sb.append(checkPoint(i, line));
        }
        return sb.toString();
    }

    public static String checkHorizon(int point, List<Boolean> line) {
        if (line.get((point - 1) / 2)) {
            return HORIZONTAL;
        }
        return NONE;
    }

    public static String checkPoint(int point, List<Boolean> line) {
        if (point % 2 == 0) {
            return VERTICAL;
        }
        return checkHorizon(point, line);
    }

}