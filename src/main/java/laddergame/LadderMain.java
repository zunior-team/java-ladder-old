package laddergame;

import laddergame.domain.LadderGame;
import laddergame.view.InputView;
import laddergame.view.ResultView;

public class LadderMain {
    public static void main(String[] args) {
        String names = InputView.getNames();
        int maxHeight = InputView.getMaxHeight();

        LadderGame ladderGame = new LadderGame();
        ladderGame.playGame(names, maxHeight);

        ResultView.printResult(ladderGame);
    }
}