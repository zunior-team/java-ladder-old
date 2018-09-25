package laddergame;

import java.util.ArrayList;

public class ResultView {
    private static final String VERTICAL_BAR = "|";
    private static final String DASHS = "-----";
    private static final String EMPTY_SPACE = "     ";

    public static void printResult(LadderGame ladderGame) {
        ArrayList<Line> lines;
        lines = ladderGame.getLines();

        System.out.println("\n실행결과\n");
        printPlayerName(ladderGame.getPlayers());
        for(int i = 0; i < lines.size(); i++) {
            printLine(lines.get(i).getLines());
        }
    }

    public static void printLine(ArrayList<Boolean> line) {
        for(int i = 0; i < line.size(); i++) {

            System.out.print(VERTICAL_BAR);
            System.out.print(printDash(line.get(i)));
        }
        System.out.println(VERTICAL_BAR);
    }

    public static String printDash(boolean isLine) {
        String line = EMPTY_SPACE;
        if(isLine == true) {
            line = DASHS;
        }
        return line;
    }

    public static void printPlayerName(String[] names) {
        for (String name : names) {
            System.out.print(String.format("%-6s", name));
        }
        System.out.println();
    }
}
