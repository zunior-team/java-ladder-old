package laddergame;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private int person = 0;
    private int height = 0;
    private List<ArrayList> ladder = new ArrayList<>();

    public LadderGame(int person, int height) {
        this.person = person;
        this.height = height;
    }

    public void run() {
        ladder = Ladder.getHeight(this.person, this.height);
    }

    public List<ArrayList> getLadder() {
        return ladder;
    }

    // 유저명 , 우승자 등등 나중에 구현
}
