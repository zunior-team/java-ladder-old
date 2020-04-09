package console;

import dto.LadderResultDto;
import model.ladder.Ladder;
import model.ladder.Scores;
import model.player.Players;
import util.Preprocessor;

public class LadderGame {

    public static void play(){

        final String names = InputView.inputPersonNames();
        final Players players = Players.create(Preprocessor
                .splitLineBySeparator(names, Preprocessor.COMMA));

        final String results = InputView.inputLadderResults();
        final Scores scores = Scores.create(Preprocessor
                .splitLineBySeparator(results, Preprocessor.COMMA));

        final int height = InputView.inputLadderHeight();
        final Ladder ladder = Ladder.of(players, scores, height);

        ResultView.printLadderResult(new LadderResultDto(players, ladder));

//        LadderGameStarter.run();
    }
}
