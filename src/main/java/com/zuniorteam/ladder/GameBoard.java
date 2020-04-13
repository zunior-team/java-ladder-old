package com.zuniorteam.ladder;

import com.zuniorteam.ladder.core.Ladder;
import com.zuniorteam.ladder.core.User;
import com.zuniorteam.ladder.core.generator.LadderGenerator;
import com.zuniorteam.ladder.core.generator.LineGenerator;
import com.zuniorteam.ladder.view.InputRender;
import com.zuniorteam.ladder.view.console.InputConsole;
import com.zuniorteam.ladder.view.console.OutputConsole;
import com.zuniorteam.ladder.view.console.OutputDrawer;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class GameBoard {

    private final InputConsole inputConsole = new InputConsole();
    private final OutputConsole outputConsole = new OutputConsole();

    public void playGame() {
        final List<User> users = InputRender.getUsers(inputConsole.readUsernames());
        final List<String> results = InputRender.getResults(inputConsole.readResults(), users.size());
        final int ladderHeight = InputRender.getLadderHeight(inputConsole.readLadderHeight());

        final LadderGenerator ladderGenerator = new LadderGenerator(new LineGenerator(new Random()));
        final Ladder ladder = ladderGenerator.generate(users.size(), ladderHeight);

        final String drawUsers = OutputDrawer.drawUsers(users, User.MAX_USERNAME_LENGTH);
        final String drawLadder = OutputDrawer.drawLadder(ladder, User.MAX_USERNAME_LENGTH);
        final String drawResults = OutputDrawer.drawResults(results, User.MAX_USERNAME_LENGTH);

        outputConsole.writeRadder(drawUsers, drawLadder, drawResults);

        final Map<User, String> userToResult = ladder.play(users, results);
        checkResults(userToResult, users);
    }

    private void checkResults(Map<User, String> userToResult, List<User> users) {
        final User userForCheck = InputRender.getUserForCheck(inputConsole.readUsernameForCheck(), users);

        if (userForCheck.equals(User.ALL_USERS)) {
            outputConsole.writeAllUserToResults(OutputDrawer.drawAllUserToResults(users, userToResult));
            return;
        }

        outputConsole.writeUserToResult(OutputDrawer.drawUserToResult(userForCheck, userToResult.get(userForCheck)));
        checkResults(userToResult, users);
    }
}
