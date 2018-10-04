public class Main {
    public static void main(String[] args) {
        int people = InputView.humans();
        int height = InputView.height();
        Ladder ladder = new Ladder(height);
        ladder.makeLadders(people, height);
        PrintView.totalPrint(ladder, people);
    }
}
