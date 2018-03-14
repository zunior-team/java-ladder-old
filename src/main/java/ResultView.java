import java.util.ArrayList;

public class ResultView {
    static void printResult(LadderGame ladderGame) {
        LadderLine[] ladderLine = ladderGame.getLadderLine();

        printNames(ladderGame);
        System.out.println();

        for (LadderLine line : ladderLine) {
            printLine(line);
            System.out.println();
        }
    }

    static void printNames(LadderGame ladderGame) {
        for (String name : ladderGame.getNamesOfPersons()) {
            System.out.printf(name + " ");
        }
    }

    static void printLine(LadderLine line) {
        ArrayList<Boolean> points;
        points = line.getLine();
        int width = points.size() + (points.size() - 1);

        for (int i = 0; i < width; i++) {
//            System.out.print(i);
            printElements(points, i);
        }
    }

    private static void printElements(ArrayList<Boolean> points, int i) {
        if (i % 2 == 1) {
            int portion = i / 2; // 몫. points에서의 index와 사다리 전체의 width 인덱스와의 차이를 구하려고.
            printBridge(points.get(portion)); // points는 bridge만 담고 있어서 pipe의 인덱스 -1을 해줘야 한다.
        }
        if (i % 2 == 0) {
            printPipe();
        }
    }

    static void printPipe() {
        System.out.print("|");
    }

    static void printBridge(Boolean bridge) {
        if (bridge) {
            System.out.print("-----");
            return;
        }
        System.out.print("     ");
    }
}
