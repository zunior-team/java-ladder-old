package ladder.view;

import ladder.domain.Line;

import java.util.ArrayList;

public class OutputView {

    public void printNames(ArrayList<String> names, ArrayList<Line> ladder) {
        for (String name : names) {
            System.out.printf("%5s ", name);
        }
        System.out.println();
        printLadder(ladder);
    }

    public void printLadder(ArrayList<Line> ladder) {
        for (Line ladderLine : ladder) {
            System.out.print("  ");
            drawLadder(ladderLine);
        }
    }

    public void drawLadder(Line ladder) {
        ArrayList<Boolean> allLadder = ladder.getLine();
        for (int j = 0; j < allLadder.size(); j++) {
            System.out.print("|");
            System.out.print(isTrue(allLadder.get(j)));
        }
        System.out.println("|");
    }

    public String isTrue(boolean ladder) {
        if (ladder) {
            return "-----";
        }
        return "     ";
    }
}
