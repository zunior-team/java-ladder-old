package laddergame;

import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    @Test
    public void isTrue() {
        for (int i = 0; i < 5; i++) {
            boolean random = LadderGame.isTrue();
            System.out.println(random);
        }
    }

    @Test
    public void makeLine() {
        ArrayList<Boolean> line  = LadderGame.getOneLine(5);
        for (int i=0; i < line.size(); i++) {
            System.out.println(line.get(i));
        }
        assertThat(line.get(0)).isEqualTo(true);
    }

    @Test
    public void isLine() {
        String line = LadderGame.lineOrBlank(true);

        assertThat(line).isEqualTo("-");
    }
    @Test
    public void isBlank() {
        String line = LadderGame.lineOrBlank(false);

        assertThat(line).isEqualTo(" ");
    }

    @Test
    public void ladder() {
        ArrayList<Boolean> line  = LadderGame.getOneLine(5);
        LadderGame.toStringLadder(line);
    }

    @Test
    public void getHeight() {
        LadderGame.getHeight(3,4);
    }

    @Test
    public void display() {
        ArrayList<ArrayList<Boolean>> ladders = LadderGame.getHeight(3,4);
        LadderGame.displayLadder(ladders);

    }
}
