package console;

import model.Players;
import util.Preprocessor;

import java.util.Arrays;
import java.util.List;

public class LadderGame {

    public static void play(){
        final String line = InputView.inputPersonNames();
        final Players players = Players.create(Preprocessor
                .splitLineBySeparator(line, Preprocessor.COMMA));

    }
}
