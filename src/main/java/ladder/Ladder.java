package ladder;

import ladder.domain.LadderSetting;
import ladder.domain.Line;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.ArrayList;
import java.util.Scanner;

public class Ladder {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ArrayList<String> playerNames = InputView.getNames(scan);
        int row = InputView.ladderHeight(scan);

        LadderSetting ladderSet = new LadderSetting(row, playerNames);
        ArrayList<Line> ladder = ladderSet.makeAllLine();

        OutputView print = new OutputView();
        print.printNames(playerNames,ladder);
    }
}


