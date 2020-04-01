package ladder;

import ladder.domain.LadderGame;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final ResultView resultView = new ResultView();

        final List<String> names = inputView.inputNames();
        final int maxHeight = inputView.inputMaxHeight();

        final LadderGame ladderGame = LadderGame.of(names, maxHeight);

        resultView.printResult(names, ladderGame.lines());


    }
}
