package laddergame.view;

import laddergame.domain.*;
import laddergame.utils.StringUtil;

import java.util.ArrayList;

public class ResultView {
    private  static final String BLANK = " ";

    public static void printResult(LadderGame ladderGame) {
        displayMembers(ladderGame.getUsers());
        displayLadder(ladderGame.getLadder());
    }

    public static void displayMembers(ArrayList<User> members) {
        System.out.print(BLANK);
        System.out.print(BLANK);
        for (User member : members) {
            System.out.print(BLANK);
            System.out.print(StringUtil.namesPosition(member.getName()));
        }
        System.out.println();
    }

    public static void displayLadder(ArrayList<Line> ladders) {
        for (Line ladder : ladders) {
            System.out.println(StringUtil.toStringLadder(ladder.getLine()));
        }
    }
}
