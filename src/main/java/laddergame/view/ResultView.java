package laddergame.view;

import laddergame.domain.Direction;
import laddergame.domain.Ladder;
import laddergame.domain.Line;
import laddergame.domain.Position;

import java.util.List;

public class ResultView {

    static final String NONE = "     ";
    static final String HORIZONTAL = "-----";
    static final String VERTICAL = "|";

    static final int TEXTLENLIMIT = 6;

    public static void printLadder(String[] people, List<Line> ladder, String[] results) {
        printText(people);
        for (Line line : ladder) {
            System.out.println(drawLine(line.getLine()));
        }
        printText(results);
    }

    public static void printText(String[] texts) {
        for (int i = 0; i < texts.length; i++) {
            System.out.print(makeIndent(texts[i]));
        }
        System.out.print("\n");
    }

    public static String makeIndent(String name) {
        StringBuilder sb = new StringBuilder(name);
        int indentLen = TEXTLENLIMIT - name.length();

        for (int i = 0; i < indentLen; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static String drawLine(List<Position> line) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < (line.size() * 2) - 1; i++) {
            sb.append(checkPoint(i, line));
        }
        return sb.toString();
    }

    public static String checkPoint(int point, List<Position> line) {
        if (point % 2 == 0) {
            return VERTICAL;
        }
        return checkHorizon(point, line);
    }

    public static String checkHorizon(int point, List<Position> line) {
        if (line.get((point - 1) / 2).getDirection().isRight()) {
            return HORIZONTAL;
        }
        return NONE;
    }

    public static String printGameResult(int searchIdx, Ladder ladder, String[] results, String[] people) {
        System.out.println("실행 결과");
        if (searchIdx == InputView.ALL) {
            return allGameResult(ladder, results, people);
        }
        return singleGameResult(searchIdx, ladder, results);
    }

    public static int runResultIdx(int searchIdx, Ladder ladder) {
        return ladder.runGame(searchIdx);
    }

    public static String allGameResult(Ladder ladder, String[] results, String[] people) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < people.length; i++) {
            sb.append(makeNameAndResult(people[i], singleGameResult(i, ladder, results)));
        }
        return sb.toString();
    }

    public static String makeNameAndResult(String name, String result) {
        StringBuilder sb = new StringBuilder();

        sb.append(name);
        sb.append(" : ");
        sb.append(result);
        sb.append("\n");

        return sb.toString();
    }

    public static String singleGameResult(int searchIdx, Ladder ladder, String[] results) {
        return results[runResultIdx(searchIdx, ladder)];
    }

}