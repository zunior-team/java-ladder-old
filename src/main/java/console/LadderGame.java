package console;

import model.player.Players;
import util.Preprocessor;

public class LadderGame {

    public static void play(){
        final String line = InputView.inputPersonNames();
        final Players players = Players.create(Preprocessor
                .splitLineBySeparator(line, Preprocessor.COMMA));
        final int height = InputView.inputLadderHeight();


    }
}
