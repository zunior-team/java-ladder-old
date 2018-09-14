package ladder;

public class OutputView {
    private static final String VERTICAL_BAR = "|";
    private static final String HORIZONTAL_BAR = "-";
    private static final String BLANK = " ";
    private Ladder ladder;

    public OutputView(Ladder ladder) {
        this.ladder = ladder;
    }

    public void printLadder(){
        System.out.println(makeLadder());
    }

    private String makeLadder() {
        StringBuilder sb = new StringBuilder();
        for (int h = 0; h < ladder.getLadderHeight(); h++) {
            makeFoothold(sb, h);
        }
        return sb.toString();
    }

    private void makeFoothold(StringBuilder sb, int h) {
        for (int w = 0; w < ladder.getNumberOfFoothold(); w++) {
            sb.append(VERTICAL_BAR);
            sb.append(ladder.isFoothold(h, w) ? HORIZONTAL_BAR : BLANK);
        }
        sb.append(VERTICAL_BAR);
        sb.append(System.lineSeparator());
    }
}
