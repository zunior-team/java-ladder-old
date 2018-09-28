package com.zingoworks.laddergame.view;

import com.zingoworks.laddergame.domain.DestinationIndex;
import com.zingoworks.laddergame.utilities.Utilities;
import com.zingoworks.laddergame.domain.Ladder;

public class ResultView {
    static final String HORIZON = "|";
    static final String LINE_DASH = "-----";
    static final String LINE_BLANK = "     ";

    public static void print (Ladder ladder) {
        System.out.println("사다리 결과");
        printUserName(ladder);
        printLadder(ladder);
        convertLengthToDefault(ladder);
        printResult(ladder);
    }

    public static void printCheckResult (Ladder ladder, DestinationIndex index, String userToCheck) {
        System.out.println("실행결과");

        if (userToCheck.equals("all")) {
            printAll(ladder, index);
            return;
        }
        for (int i = 0; i < ladder.getUser().size(); i++) {
            printOne(ladder, index, userToCheck, i);
        }
    }

    private static void printAll(Ladder ladder, DestinationIndex index) {
        for (int i = 0; i < ladder.getUser().size(); i++) {
            System.out.println(ladder.getUser().get(i) + " : " + index.getDestination().get(i));
        }
    }

    private static void printOne(Ladder ladder, DestinationIndex index, String userToCheck, int i) {
        if (userToCheck.equals(ladder.getUser().get(i).toString())) {
            System.out.println(index.getDestination().get(i));
        }
    }

    private static void convertLengthToDefault (Ladder ladder) {
        for (int i = 0; i < ladder.getUser().size(); i++) {
            Utilities.convertLengthToDefault(ladder.getUser()).get(i);
        }
    }

    private static void printUserName (Ladder ladder) {
        for (int i = 0; i < ladder.getUser().size(); i++) {
            System.out.print(Utilities.convertLengthToLimit(ladder.getUser()).get(i));
        }
        System.out.println("");
    }

    private static void printLadder (Ladder ladder) {
        for (int i = 0; i < ladder.getLadderHeight(); i++) {
            System.out.print(LINE_BLANK);
            System.out.print(HORIZON);
            drawLine(ladder, i);
        }
    }

    private static void drawLine(Ladder ladder, int i) {
        for (int j = 0; j < ladder.getUser().size() - 1; j++) {
            drawRung(ladder.getLine().get(i).getRungExistence(j));
            System.out.print(HORIZON);
        }
        System.out.println("");
    }

    private static void drawRung(Boolean b) {
        if (b == true) {
            System.out.print(LINE_DASH);
            return;
        }
        System.out.print(LINE_BLANK);
    }

    private static void printResult (Ladder ladder) {
        for (int i = 0; i < ladder.getUser().size(); i++) {
            System.out.print(Utilities.convertLengthToLimit(ladder.getResult()).get(i));
        }
        System.out.println("");
    }
}
