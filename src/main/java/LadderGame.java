public class LadderGame {
    private LadderLine[] ladderLine;
    // width, height 인스턴스 변수를 만들어야 할까?
    // 만약 LadderGame 코드 중에서 width, height를 쓸 일이 많이 늘면 고려하기.

    public LadderGame(int peopleCount, int height) {
        int width = peopleCount + (peopleCount - 1);
        this.ladderLine = new LadderLine[width];
        getLines(width, height);
    }

    public void getLines(int width, int height) {
        for (int i = 0; i < height; i++) {
            this.ladderLine[i] = new LadderLine(width);
        }
    }

    public LadderLine[] getLadderLine() {
        return this.ladderLine;
    }
}