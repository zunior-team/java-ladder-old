package laddergame;

import java.util.ArrayList;

public class ResultView {
    private static final String VERTICAL_BAR = "|";
    private static final String DASH = "-";
    private static final String EMPTY_SPACE = " ";

    public static void printResult(LadderGame ladderGame) {
        ArrayList<Ladder> ladders;
        ladders = ladderGame.getLadders();

        for(int i = 0; i < ladders.size(); i++) {
            printLine(ladders.get(i).getLines());
        }
    }

    public static void printLine(boolean[] lines) {
        for(int i = 0; i < lines.length; i++) {
            System.out.print(VERTICAL_BAR);
            System.out.print(printDash(lines[i]));
        }
        System.out.println(VERTICAL_BAR);
    }

    public static String printDash(boolean isLine) {
        String line = EMPTY_SPACE;
        if(isLine == true) {
            line = DASH;
        }
        return line;
    }
}
