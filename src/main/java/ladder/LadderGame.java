package ladder;

public class LadderGame {
    private Ladder ladder;

    public LadderGame(int peopleNumber, int ladderHeight) {
        int numberOfFoothold = peopleNumber - 1;
        ladder = new Ladder(ladderHeight, numberOfFoothold);
    }

    public void init() {
        ladder.makeLadder();
    }

    public Ladder getResult() {
        return ladder;
    }
}
