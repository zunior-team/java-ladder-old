package laddergame.domain;

import java.util.ArrayList;

public class LadderGame {
    static final String SEPARATOR = ", |,";
    private int height = 0;
    private ArrayList<Line> ladder = new ArrayList<>();
    private ArrayList<User> users;
    private ArrayList<MyResult> results;

    public LadderGame() {

    }

    public LadderGame(String members, int height, String results) {
        this.users = makeUsers(members.split(SEPARATOR));
        this.height = height;
        this.results = makeResults(results.split(SEPARATOR));
    }

    private ArrayList<MyResult> makeResults(String[] results) {
        ArrayList<MyResult> myResults = new ArrayList<>();
        for (String result : results) {
            myResults.add(new MyResult(result));
        }
        return myResults;
    }

    public ArrayList<User> makeUsers(String[] names) {
        ArrayList<User> users = new ArrayList<>();
        for (String name : names) {
            users.add(new User(name));
        }
        return users;
    }

    public void makeLadder() {
        for (int i = 0; i < this.height; i++) {
            ladder.add(new Line(this.users.size()));
        }
    }

    // 유저 배열 i 값을 받아 line 이 참거짓을 판별해 userPosition 을 구한다.
    public int findResultPosition(int userPosition) {
        for (Line line : this.ladder) {
            userPosition = line.isMovePosition(userPosition);
        }
        return userPosition;
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }

    public ArrayList<Line> getLadder() {
        return this.ladder;
    }

    public ArrayList<MyResult> getResults() {
        return this.results;
    }
}
