package view;

import domain.LadderGame;
import domain.LadderLine;

import java.util.ArrayList;

public class ResultView {
    private static final String dashLine = "-----";
    private static final String spaceLine = "     ";
    private static final String pipe = "|";

    public static void printResult(LadderGame ladderGame) {
        LadderLine[] ladderLine = ladderGame.getLadderLine();

        printNames(ladderGame);
        for (LadderLine line : ladderLine) {
            printLine(line);
        }
    }

    static void printNames(LadderGame ladderGame) {
        for (String name : ladderGame.getNamesOfPersons()) {
            System.out.print(String.format("%-6s", name));
        }
        System.out.println();
    }

    static void printLine(LadderLine line) {
        ArrayList<Boolean> points;
        points = line.getLine();
        int width = points.size() + (points.size() + 1);

        for (int i = 0; i < width; i++) {
            printElements(points, i);
        }
        System.out.println();
    }

    private static void printElements(ArrayList<Boolean> points, int i) {
        if (i % 2 == 1) {
            int portion = i / 2;
            printBridge(points.get(portion));
        }
        if (i % 2 == 0) {
            printPipe();
        }
    }

    private static void printPipe() {
        System.out.print(pipe);
    }

    private static void printBridge(Boolean bridge) {
        if (bridge) {
            System.out.print(dashLine);
            return;
        }
        System.out.print(spaceLine);
    }
}
