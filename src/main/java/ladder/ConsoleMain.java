package ladder;

import ladder.domain.LadderGame;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final ResultView resultView = new ResultView();

        final List<String> names = inputView.inputNames();
        final List<String> resultNames = inputView.inputResults();
        final int maxHeight = inputView.inputMaxHeight();

        final Players players = Players.of(names);
        final Results results = Results.of(resultNames, players);
        final LadderGame ladderGame = LadderGame.of(players, maxHeight, results);

        resultView.printLadder(players, ladderGame.lines());

        Player player = players.findByName(inputView.inputPlayerWhoWantResult());

    }
}
