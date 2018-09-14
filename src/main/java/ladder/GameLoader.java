package ladder;

public class GameLoader {
    public static void main(String[] args) {
        InputView inputView = new InputView(System.in);
        LadderGame ladderGame = new LadderGame(inputView.getPeopleNumber(), inputView.getLadderHeight());
        ladderGame.init();
        OutputView outputView = new OutputView(ladderGame.getResult());
        outputView.printLadder();
    }
}
