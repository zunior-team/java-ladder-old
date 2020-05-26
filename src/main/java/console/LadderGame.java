package console;

import dto.LadderCreateDto;
import dto.LadderDrawDto;
import dto.LadderResultDto;
import model.ladder.Ladder;
import model.ladder.Scores;
import model.level.Level;
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

        final Level level = Level.getLevelByString(InputView.inputLevel());

        final Ladder ladder = Ladder.of(new LadderCreateDto(players, scores, level));

        ResultView.printLadderResult(new LadderDrawDto(players, ladder));

        LadderGameStarter.run(new LadderResultDto(ladder.getResults()));
    }
}
