package ladder;

import ladder.domain.*;
import ladder.dto.LadderGameResultDto;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class ConsoleMain {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final ResultView resultView = new ResultView();

        final List<String> names = inputView.inputNames();
        final List<String> resultNames = inputView.inputResults();
        final int maxHeight = inputView.inputMaxHeight();

        final Players players = Players.of(names);
        final Results results = Results.of(resultNames, players.size());
        final LadderGame ladderGame = LadderGame.of(players, maxHeight, results);

        resultView.printLadder(new LadderGameResultDto(ladderGame));

        ResultPlayer playerToPrintResults = new ResultPlayer(players, inputView.inputPlayerWhoWantResult());
        final Map<Player, String> matchedResults = players.stream()
                .collect(toMap(player -> player, ladderGame::findResult));
        resultView.printResultOfEachPlayer(matchedResults, playerToPrintResults);

    }
}
