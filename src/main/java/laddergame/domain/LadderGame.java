package laddergame.domain;

import laddergame.util.Util;

import java.util.ArrayList;

public class LadderGame {
    private String[] players;
    private ArrayList<Line> lines = new ArrayList<>();

    public ArrayList<Line> getLines() {
        return this.lines;
    }

    public String[] getPlayers() {
        return this.players;
    }

    public void playGame(String names, int maxHeight) {
        players = names.split(Util.COMMA);

        for (int i = 0; i < maxHeight; i++) {
            Line line = new Line(players.length);
            lines.add(line);
        }
    }
}
