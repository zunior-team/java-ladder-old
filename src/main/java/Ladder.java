import java.util.Scanner;

public class Ladder {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int column = InputView.playerNum(scan);
        int row = InputView.ladderHeight(scan);

        LadderSetting ladderSet = new LadderSetting(row, column);

        boolean[][] ladder = ladderSet.getLadder();

        OutputView printer = new OutputView();
        printer.printLadder(ladder);
    }
}


