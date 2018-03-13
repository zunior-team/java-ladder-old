public class LadderMain {
    public static void main(String[] args) {
        int peopleCount = InputView.getPeopleCount();
        int height = InputView.getHeight();

        LadderGame ladderGame = new LadderGame(peopleCount, height);
        ResultView.printResult(ladderGame);
    }
}
