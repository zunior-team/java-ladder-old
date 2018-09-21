package laddergame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultView {
    static final String RADDER = "-----";
    static final String RADDER_BLANK = "     ";
    static final String BLANK = " ";
    static final int NAME_LENGTH = 5;

    public static void printResult(LadderGame ladderGame) {
        displayMembers(ladderGame.getUsers());
        displayLadder(ladderGame.getLadder());

        // System.out.println(ladderGame.getUsers().get(0).getName());
    }

    public static void displayMembers(ArrayList<User> members) {
        System.out.print(BLANK);
        for (User member : members) {
            System.out.print(BLANK);
            namesPosition(member.getName());
        }
        System.out.println(BLANK);
    }

    private static void namesPosition(String member) {
        StringBuffer sb = new StringBuffer(member);
        for (int i = member.length(); i < NAME_LENGTH; i++) {
            if (sb.length() < NAME_LENGTH) {
                sb.insert(0, BLANK);
                sb.append(BLANK);
            }
        }
        System.out.print(sb);
    }

    public static void displayLadder(ArrayList<Line> ladders) {
        for (Line ladder : ladders) {
            toStringLadder(ladder.getLine());
        }
    }

    public static String lineOrBlank(boolean isTrue) {
        String line = RADDER_BLANK;
        if (isTrue) {
            line = RADDER;
        }
        return line;
    }

    public static void toStringLadder(ArrayList<Boolean> isLadder) {
        String ladder = RADDER_BLANK;
        for (Boolean aBoolean : isLadder) {
            ladder += "l";
            ladder += lineOrBlank(aBoolean);
        }
        ladder += "l";
        System.out.println(ladder);
    }
}
