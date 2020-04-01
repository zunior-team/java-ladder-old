package com.zuniorteam.ladder;

import com.zuniorteam.ladder.core.Line;
import com.zuniorteam.ladder.core.User;
import com.zuniorteam.ladder.core.generator.LadderGenerator;
import com.zuniorteam.ladder.core.generator.LineGenerator;
import com.zuniorteam.ladder.view.InputRender;
import com.zuniorteam.ladder.view.console.InputConsole;
import com.zuniorteam.ladder.view.console.OutputConsole;
import com.zuniorteam.ladder.view.console.OutputDrawer;

import java.util.List;
import java.util.Random;

public class GameBoard {

    private final InputConsole inputConsole = new InputConsole();
    private final OutputConsole outputConsole = new OutputConsole();

    public void playGame() {
        final List<User> users = InputRender.getUsers(inputConsole.readUsernames());
        final int ladderHeight = InputRender.getLadderHeight(inputConsole.readLadderHeight());

        final LadderGenerator ladderGenerator = new LadderGenerator(new LineGenerator(new Random()));
        final List<Line> ladder = ladderGenerator.generate(users.size(), ladderHeight);

        final String drawUser = OutputDrawer.drawUsers(users, User.MAX_USERNAME_LENGTH);
        final String drawLadder = OutputDrawer.drawLadder(ladder, User.MAX_USERNAME_LENGTH);

        outputConsole.writeResult(drawUser, drawLadder);
    }

}
