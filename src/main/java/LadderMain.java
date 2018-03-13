public class LadderMain {
    public static void main(String[] args) {
        int peopleCount = InputView.getPeopleCount();
        int height = InputView.getHeight();

        LadderGame ladderGame = new LadderGame(peopleCount, height);
        ladderGame.drawLadderLine();
        ResultView.printResult(ladderGame);
    }
}
