package com.zuniorteam.ladder;

import com.zuniorteam.ladder.core.Line;
import com.zuniorteam.ladder.core.User;
import com.zuniorteam.ladder.core.generator.LadderGenerator;
import com.zuniorteam.ladder.core.generator.LineGenerator;
import com.zuniorteam.ladder.view.InputRender;
import com.zuniorteam.ladder.view.console.InputConsole;
import com.zuniorteam.ladder.view.console.OutputConsole;

import java.util.List;

public class GameBoard {

    private final InputConsole inputConsole = new InputConsole();
    private final OutputConsole outputConsole = new OutputConsole();

    public void playGame() {
        final List<User> users = getUsers(inputConsole);
        final int height = getHeight(inputConsole);

        final LadderGenerator ladderGenerator = new LadderGenerator(new LineGenerator());

        final List<Line> ladder = ladderGenerator.generate(users.size(), height);

        outputConsole.drawResult(users, ladder);


    }

    private List<User> getUsers(InputConsole inputConsole) {
        return InputRender.getUsers(inputConsole.getUsernames());
    }

    private int getHeight(InputConsole inputConsole) {
        return InputRender.getHeight(inputConsole.getHeight());
    }


}
