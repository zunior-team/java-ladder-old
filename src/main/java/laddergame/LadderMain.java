package laddergame;

public class LadderMain {
    public static void main(String[] args) {
        int people = InputView.getPeople();
        int maxHeight = InputView.getMaxHeight();

        LadderGame ladderGame = new LadderGame();
        ladderGame.playGame(people, maxHeight);

        ResultView.printResult(ladderGame);
    }
}