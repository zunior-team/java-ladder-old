package laddergame.domain;

import laddergame.util.Util;

import java.util.ArrayList;

public class LadderGame {
    private ArrayList<Player> players = new ArrayList<>();
    private String[] results;

    private ArrayList<Line> lines = new ArrayList<>();

    public LadderGame(String names, String result) {
        String[] name = names.split(Util.COMMA);
        for (int i = 0; i < name.length; i++) {
            players.add(new Player(name[i], i));
        }
        results = result.split(Util.COMMA);
    }

    public ArrayList<Line> getLines() {
        return this.lines;
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public void makeLadder(int maxHeight) {
        for (int i = 0; i < maxHeight; i++) {
            Line line = new Line(players.size());
            lines.add(line);
        }
    }

    public void playGame() {
        for (Player player : players) {
            move(player);
        }
    }

    public String[] getResults() {
        return results;
    }

    public void move(Player player) {
        for (Line line : lines) {
            line.move(player);
        }
    }
}
