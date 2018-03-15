public class OutputView {

    void printLadder(boolean[][] ladder) {
        for (int i = 0; i < ladder.length; i++) {
            drawLadder(ladder, i);
        }
    }

    void drawLadder(boolean[][] ladder, int i) {
        for (int j = 0; j < ladder[i].length; j++) {
            colLineController(ladder, i, j);
        }
        System.out.println();
    }

    void colLineController(boolean[][] ladder, int i, int j) {
        if (j % 2 == 0 && j != 1) {
            System.out.print(" | ");
        }

        if (j % 2 == 1) {
            isTrue(ladder[i][j]);
        }
    }

    void isTrue(boolean ladder) {
        if (ladder == true) {
            System.out.print("-");
        } else {
            System.out.print(" ");
        }
    }

}
