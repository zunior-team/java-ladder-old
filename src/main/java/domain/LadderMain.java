package domain;

import view.InputView;
import view.ResultView;

public class LadderMain {
    public static void main(String[] args) {
        String[] namesOfPersons = InputView.getNamesOfPersons();
        int height = InputView.getHeight();

        LadderGame ladderGame = new LadderGame(namesOfPersons, height);
        ResultView.printResult(ladderGame);
    }
}
