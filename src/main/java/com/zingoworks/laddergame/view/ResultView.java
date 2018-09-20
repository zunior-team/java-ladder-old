package com.zingoworks.laddergame.view;

import com.zingoworks.laddergame.domain.Ladder;

public class ResultView {
    static final String HORIZON = "|";
    static final String DASH = "-";
    static final String BLANK = " ";

    public static void printResult (Ladder[] l) {
        for (int i = 0; i < l.length; i++) {
            printOneLadder(l[0].numOfPeople, l[i]);
        }
    }

    private static void printOneLadder(int numOfPeople, Ladder ladder) {
        printHorizon();
        for (int j = 0; j < numOfPeople - 1; j++) {
            printOneSet(ladder.ladderValue[j]);
        }
        System.out.println("");
    }

    private static void printOneSet(Boolean b) {
        printVertical(b);
        printHorizon();
    }

    private static void printHorizon () {
        System.out.print(HORIZON);
    }

    private static void printVertical (Boolean b) {
        if (b == true) {
            System.out.print(DASH);
            return;
        }
        System.out.print(BLANK);
    }
}
