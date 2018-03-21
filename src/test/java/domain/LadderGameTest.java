package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LadderGameTest {
    LadderGame ladderGame;
    String[] newNames = {"kbs", "sbs", "mbc"};
    String[] rewards = {"o", "x", "x"};
    final int HEIGHT = 5;

    @Before
    public void setup() {
        String[] oldNames = {"kbs", "sbs"};
        ladderGame = new LadderGame(oldNames, rewards, HEIGHT);
    }

    @Test
    public void countOfPlayers() {
        ArrayList<Player> players = ladderGame.makePlayers(newNames);
        assertThat(3, is(players.size()));
    }

    @Test
    public void countOfLadderLines() {
        ArrayList<LadderLine> ladderLines = Ladder.makeLadderLines(newNames, HEIGHT);
        System.out.println(ladderLines);
        assertThat(ladderLines.size(), is(5));
    }
}
