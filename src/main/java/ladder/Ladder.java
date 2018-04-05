package ladder;

import ladder.domain.LadderSetting;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Scanner;

public class Ladder {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] playerNames = InputView.getNames(scan);
        String[] rewards = InputView.getRewards(scan);
        int row = InputView.ladderHeight(scan);

        LadderSetting ladderSet = new LadderSetting(row, playerNames, rewards);
        ladderSet.getPlayerRewards();
        OutputView.printResult(ladderSet);
        InputView.iterateGetTarget(ladderSet);
    }
}


