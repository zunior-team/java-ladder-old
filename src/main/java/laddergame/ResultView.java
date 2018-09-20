package laddergame;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    public static void printResult(LadderGame ladderGame) {
        displayLadder(ladderGame.getLadder());
    }

    public static void displayLadder(List<ArrayList> ladders) {
        for (ArrayList<Boolean> ladder : ladders) {
            toStringLadder(ladder);
        }
    }

    public static String lineOrBlank(boolean isTrue) {
        String line = " ";
        if (isTrue) {
            line = "-";
        }
        return line;
    }

    public static void toStringLadder(ArrayList<Boolean> isLadder) {
        String ladder = "";
        for (Boolean aBoolean : isLadder) {
            ladder += "l";
            ladder += lineOrBlank(aBoolean);
        }
        ladder += "l";
        System.out.println(ladder);
    }
}
