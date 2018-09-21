package laddergame.domain;

import java.util.ArrayList;

public class LadderGame {
    static final String SEPARATOR = ",";
    private int person = 0;
    private int height = 0;
    private ArrayList<Line> ladder = new ArrayList<>();
    private ArrayList<User> users;

    public LadderGame(String members, int height) {
        this.users = makeUsers(members.split(SEPARATOR));
        this.person = users.size();
        this.height = height;
    }

    private ArrayList<User> makeUsers(String[] names) {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            users.add(new User(names[i], i));
        }
        return users;
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }

    public void run() {
        for (int i = 0; i < this.height; i++) {
            ladder.add(new Line(this.person));
        }
    }

    public ArrayList<Line> getLadder() {
        return ladder;
    }

}
