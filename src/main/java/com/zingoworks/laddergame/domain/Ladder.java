package com.zingoworks.laddergame.domain;

import java.util.ArrayList;

public class Ladder {
    private ArrayList<StringBuilder> user;
    private ArrayList<StringBuilder> result;
    private int ladderHeight;
    private ArrayList<Line> line = new ArrayList<>();

    public Ladder (ArrayList<StringBuilder> user, ArrayList<StringBuilder> result, int ladderHeight) {
        this.user = user;
        this.result = result;
        this.ladderHeight = ladderHeight;
        generateLine();
    }

    public ArrayList<StringBuilder> getUser () {
        return this.user;
    }

    public ArrayList<StringBuilder> getResult () {
        return this.result;
    }

    public ArrayList<Line> getLine () {
        return this.line;
    }

    public int getLadderHeight () {
        return this.ladderHeight;
    }

    private void generateLine () {
        for (int i = 0; i < this.ladderHeight; i++) {
            this.line.add(new Line(this.user.size()));
        }
    }
}
