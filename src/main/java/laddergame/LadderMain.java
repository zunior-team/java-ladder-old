package laddergame;

import laddergame.domain.LadderGame;
import laddergame.util.Util;
import laddergame.view.InputView;
import laddergame.view.ResultView;

public class LadderMain {
    public static void main(String[] args) {
        String names = InputView.getNames();
        String results= InputView.getResult((names.split(Util.COMMA).length));

        LadderGame ladderGame = new LadderGame(names, results);
        ladderGame.makeLadder(InputView.getMaxHeight());
        ladderGame.playGame();

        ResultView.printLadderGameResult(ladderGame);

        boolean isFinish = false;
        while(!isFinish) {
            String resultForName = InputView.getNameForTheResult();
            isFinish = ResultView.printResultForName(ladderGame, resultForName);
        }
    }
}