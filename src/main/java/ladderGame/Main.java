package ladderGame;

import ladderGame.domain.LadderGame;
import ladderGame.view.InputView;

public class Main {
    public static void main(String[] args) {
        LadderGame.goGame(InputView.inputNamesOfPlayer(), InputView.inputHeightOfLadder());
    }
}
