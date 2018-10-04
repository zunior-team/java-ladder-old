import java.util.List;

public class PrintView {
    public static void totalPrint(Ladder ladder, int people) {
        List<Line> ladders = ladder.getLadders();
        printResult(ladders, people);
    }

    public static void printBar(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("|");
        }
    }

    public static void printResult(List<Line> ladders, int people) {
        for (int i = 0; i < ladders.size(); i++) {
            for (int j = 0; j < people; j++) {
                printBar(ladders.get(i).barPosition);
                printDash(ladders, i, j);
            }
            System.out.println("");
        }
    }

    private static void printDash(List<Line> ladders, int i, int j) {
        if (ladders.get(i).getPoints().get(j)) {
            System.out.print("-");
        } else {
            System.out.print(" ");
        }
    }
}