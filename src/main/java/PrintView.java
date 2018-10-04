import java.util.List;

public class PrintView {
    static StringBuilder stringBuilder = new StringBuilder();

    public static void totalPrint(Ladder ladder, int people) {
        List<Line> ladders = ladder.getLadders();
        printResult(ladders, people);
        System.out.println(stringBuilder);
    }

    public static void printResult(List<Line> ladders, int people) {
        for (int i = 0; i < ladders.size(); i++) {
            insidePrintResult(ladders, people, i);
            stringBuilder.append("\n");
        }
    }

    private static void insidePrintResult(List<Line> ladders, int people, int i) {
        for (int j = 0; j < people; j++) {
            printBar();
            stringBuilder.append(printDash(ladders, i, j));
        }
    }

    public static void printBar() {
        stringBuilder.append("|");
    }

    private static String printDash(List<Line> ladders, int i, int j) {
        if (ladders.get(i).getPoints().get(j)) {
            return "-";
        }
        return " ";
    }
}