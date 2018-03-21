package domain;

import view.InputView;
import view.ResultView;

public class LadderMain {
    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(InputView.getNames(), InputView.getRewards(), InputView.getHeight());
        LadderMatch ladderMatch = new LadderMatch(ladderGame);
        ladderGame.getPlayerRewards(); // for all player Rewards
        ResultView.printResult(ladderGame);
        InputView.iterateGetTarget(ladderGame);
    }
}
