package laddergame;

import java.util.ArrayList;

public class LadderGame {
    private static final String COMMA = ",";
    String[] players;
    ArrayList<Line> lines = new ArrayList<>();

    public ArrayList<Line> getLines() {
        return this.lines;
    }

    public String[] getPlayers() {
        return this.players;
    }

    public void playGame(String names, int maxHeight) {
        players = splitName(names);

        for(int i = 0; i < maxHeight; i++) {
            Line line = new Line(players.length);
            lines.add(line);
        }
    }

    public String[] splitName(String names){
        return names.split(COMMA);
    }
}
