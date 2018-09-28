package com.zingoworks.laddergame;

import com.zingoworks.laddergame.domain.DestinationIndex;
import com.zingoworks.laddergame.domain.Ladder;
import com.zingoworks.laddergame.view.InputView;
import com.zingoworks.laddergame.view.ResultView;

import java.util.ArrayList;

public class LadderMain {
    public static void main(String[] args) {
        ArrayList<StringBuilder> user = InputView.inputUser();
        ArrayList<StringBuilder> result = InputView.inputResult();
        int ladderHeight = InputView.inputLadderHeight();

        Ladder ladder = new Ladder(user, result, ladderHeight);
        ResultView.print(ladder);

        DestinationIndex index = new DestinationIndex(ladder);
        String userToCheck = InputView.inputUserToCheck();
        ResultView.printCheckResult(ladder, index, userToCheck);
    }
}