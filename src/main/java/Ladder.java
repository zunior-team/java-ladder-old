import java.util.ArrayList;
import java.util.Scanner;

public class Ladder {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ArrayList<String> playerNames = InputView.getNames(scan);

        Names forSize = new Names();
        int column = forSize.sizeForRealCol();
        int row = InputView.ladderHeight(scan);

        LadderSetting ladderSet = new LadderSetting(row, column);

        boolean[][] ladder = ladderSet.getLadder();

        OutputView printer = new OutputView();
        printer.printNames(playerNames);
        printer.printLadder(ladder);
    }
}


