public class LadderGame {
    private LadderLine[] ladderLine;
    private String[] namesOfPersons;
    // width, height 인스턴스 변수를 만들어야 할까?
    // 만약 LadderGame 코드 중에서 width, height를 쓸 일이 많이 늘면 고려하기.

    public LadderGame(String[] namesOfPersons, int height) {
        int countOfPersons = namesOfPersons.length;

        this.ladderLine = new LadderLine[height];
        this.namesOfPersons = namesOfPersons;
        getLines(countOfPersons, height);
    }

    public String[] getNamesOfPersons() {
        return this.namesOfPersons;
    }

    public void getLines(int countOfPersons, int height) {
        for (int i = 0; i < height; i++) {
            this.ladderLine[i] = new LadderLine(countOfPersons);
        }
    }

    public LadderLine[] getLadderLine() {
        return this.ladderLine;
    }
}