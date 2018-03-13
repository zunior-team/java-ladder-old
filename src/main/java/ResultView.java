public class ResultView {
    static void printResult(LadderGame ladderGame) {
        char[][] ladderBase = ladderGame.getLadderBase();
        for (int i = 0; i < ladderBase.length; i++) {
            // System.out.println(Arrays.toString(ladderBase[i]));
            printLadderbase(i, ladderBase);
            System.out.println();
        }
    }

    static void printLadderbase(int index, char[][] ladderBase) {
        for (int i = 0; i < ladderBase[0].length; i++) {
            System.out.print(ladderBase[index][i]);
        }
    }
}
