package laddergame.view;

import laddergame.domain.*;
import laddergame.utils.MyStringUtil;

import java.util.ArrayList;

public class ResultView {
    private static final String BLANK = " ";
    private LadderGame ladderGame;

    public ResultView(LadderGame ladderGame) {
        this.ladderGame = ladderGame;
    }

    public void printResult() {
        displayMembers(this.ladderGame.getUsers());
        displayLadder(this.ladderGame.getLadder());
        displayMyResult(this.ladderGame.getResults());
    }

    private void displayMyResult(ArrayList<MyResult> results) {
        System.out.print(BLANK + BLANK);
        for (MyResult result : results) {
            System.out.print(BLANK + MyStringUtil.displayPosition(result.getResult()));
        }
        System.out.println();
    }

    private void displayMembers(ArrayList<User> members) {
        System.out.print(BLANK + BLANK);
        for (User member : members) {
            System.out.print(BLANK + MyStringUtil.displayPosition(member.getName()));
        }
        System.out.println();
    }

    private void displayLadder(ArrayList<Line> ladders) {
        for (Line ladder : ladders) {
            System.out.println(MyStringUtil.toStringLadder(ladder.getLine()));
        }
    }

    public void RunNameResult() {
        String nameResult = "";
        while (!(nameResult.equals("all"))) {
            nameResult = InputView.getNameResult();
            isAll(nameResult);
        }
    }

    // all 이면 다 출력 아니면 값찾기
    public void isAll(String result) {
        System.out.println("실행 값");
        if (result.equals("all")) {
            displayNameResult();
            return;
        }
        isSingleResult(result);
    }

    // all 출력
    public void displayNameResult() {
        for (int i = 0; i < this.ladderGame.getUsers().size(); i++) {
            System.out.println(MyStringUtil.nameResultToString(this.ladderGame, i));
        }
    }

    // 하나 출력
    public void isSingleResult(String result) {
        if (this.ladderGame.getUsers().contains(new User(result))) {
            System.out.println(MyStringUtil.nameResultToString(this.ladderGame, findNamePosition(result)));
        }
    }

    public int findNamePosition(String result) {
        return this.ladderGame.getUsers().indexOf(new User(result));
    }
}
