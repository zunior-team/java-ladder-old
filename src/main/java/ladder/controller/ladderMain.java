package ladder.controller;

import ladder.domain.Movement;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;

public class ladderMain {
    public static void main(String[] args) {
        Movement m = new Movement();
        InputView iv = new InputView();
        ResultView rv = new ResultView();

        int temporary = iv.userInput();
        int height = iv.heightInput();
        ArrayList<ArrayList<Boolean>> user = new ArrayList<>(m.userRepetition(temporary, height));
        rv.transverse(user);
    }
}
