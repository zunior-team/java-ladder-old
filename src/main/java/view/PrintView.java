package view;

import ladder.Ladder;
import ladder.Line;

import java.util.List;

public class PrintView {
    static StringBuilder stringBuilder = new StringBuilder();

    public static void totalPrint(Ladder ladder, String[] people) {
        List<Line> ladders = ladder.getLadders();
        printResult(ladders, people);
        System.out.println(String.valueOf(stringBuilder));
    }

    public static void printResult(List<Line> ladders, String[] people) {
        for (int i = 0; i < people.length; i++) {
            stringBuilder.append(String.format("%6s", people[i]));
        }
        stringBuilder.append("\n");
        for (int i = 0; i < ladders.size(); i++) {
            insidePrintResult(ladders, people, i);
            stringBuilder.append("\n");
        }
    }

    private static void insidePrintResult(List<Line> ladders, String[] people, int i) {
        for (int j = 0; j < people.length; j++) {
            stringBuilder.append(printDash(ladders, i, j));
            printBar();
        }
    }

    public static void printBar() {
        stringBuilder.append("|");
    }

    private static String printDash(List<Line> ladders, int i, int j) {
        if (ladders.get(i).getPoints().get(j)) {
            return "-----";
        }
        return "     ";
    }
}