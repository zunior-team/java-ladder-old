package com.zuniorteam.ladder.view.console;

import java.util.List;

public class OutputConsole {

    public void writeRadder(String drawUsers, String drawLadder, String drawResults) {
        System.out.println("=============== 사다리게임 ==============");
        System.out.println();
        System.out.println(drawUsers);
        System.out.println(drawLadder);
        System.out.println(drawResults);
    }

    public void writeUserToResult(String drawUserToResult) {
        System.out.println("실행 결과");
        System.out.println(drawUserToResult);
    }

    public void writeAllUserToResults(List<String> drawAllUserToResults) {
        System.out.println("실행 결과");
        drawAllUserToResults.forEach(System.out::println);
    }
}
