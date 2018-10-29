package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Movement;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.ArrayList;

public class LadderMain {
    public static void main(String[] args) {
        Movement m = new Movement();

        String inputName = InputView.userInput();
        String[] name = new String[0];
        try {
            name = m.nameCut(inputName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            inputName = InputView.userInput();
        }

        int height = InputView.heightInput();
        ResultView.nameOutput(name);
        ResultView.transverse(m.ladderObject(height, inputName));
    }
}