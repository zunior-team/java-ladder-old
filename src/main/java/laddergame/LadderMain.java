package laddergame;

public class LadderMain {
    public static void main(String[] args) {
        int person = InputView.getPerson();
        int height = InputView.getHeight();
        LadderGame ladderGame = new LadderGame(person, height);
        ladderGame.run();
        ResultView.printResult(ladderGame);
    }
}
