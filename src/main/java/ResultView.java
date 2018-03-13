public class ResultView {
    static void printResult(LadderGame ladderGame) {
        LadderLine[] ladderLine = ladderGame.getLadderLine();
        for (LadderLine line : ladderLine) {
            System.out.println(line.getLine());
        }
    }
}
