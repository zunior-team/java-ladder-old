package ladder;

public class GameLoader {
    public static void main(String[] args) {
        InputView inputView = new InputView(System.in);
        LadderGame ladderGame = new LadderGame(inputView.getPeopleName(), inputView.getLadderHeight());
        OutputView.printPeopleName(ladderGame.getPeopleName());
        OutputView.printLadder(ladderGame.getLadder());
    }
}
