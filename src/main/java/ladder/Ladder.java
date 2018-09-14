package ladder;

public class Ladder {
    private boolean[][] ladder;

    public Ladder(int ladderHeight, int numberOfFoothold) {
        ladder = new boolean[ladderHeight][numberOfFoothold];
    }

    public int getLadderHeight() {
        return ladder.length;
    }

    public int getNumberOfFoothold() {
        return ladder[0].length;
    }

    public boolean isFoothold(int height, int NumberOfFoothold) {
        return ladder[height][NumberOfFoothold];
    }

    public void makeLadder() {
        makeFirstLineFoothold();
        makeExtraFoothold();
    }

    private void makeFirstLineFoothold() {
        for (int i = 0; i < ladder.length; i++) {
            ladder[i][0] = MyRandom.get();
        }
    }

    private void makeExtraFoothold() {
        for (int w = 1; w < ladder[0].length; w++) {
            makeAFoothold(w);
        }
    }

    private void makeAFoothold(int w) {
        for (int h = 0; h < ladder.length; h++) {
            ladder[h][w] = !ladder[h][w - 1] && MyRandom.get();
        }
    }
}
