package laddergame;

import laddergame.domain.LadderGame;
import laddergame.view.*;

public class LadderMain {
    public static void main(String[] args) {
        String person = InputView.getName();
        String result = InputView.getResult();
        int height = InputView.getLadder();

        LadderGame ladderGame = new LadderGame(person, height, result);
        ladderGame.makeLadder();

        ResultView resultView = new ResultView(ladderGame);
        resultView.printResult();
        resultView.RunNameResult();
    }
}
