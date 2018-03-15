import java.util.Random;

public class LadderSetting {

    private boolean[][] ladder;

    LadderSetting(int row, int column) {
        ladder = new boolean[row][column];
        setRowLadder(row,column);
    }

    boolean randomGenerator() {
        Random random = new Random();
        return random.nextBoolean();
    }

    void setRowLadder(int row, int column) {
        for (int i = 0; i < row; i++) {
            setColumnLadder(i, column);
        }
    }

    void setColumnLadder(int i, int column) {
        for (int j = 0; j < column-2; j++) {
            ladder[i][j] = randomGenerator();
            sameResultStopper(i, j);
        }
    }

    void sameResultStopper(int i, int j) {
        if (ladder[i][j] == ladder[i][j+2]) {
            boolean makeOppValue = ladder[i][j];
            ladder[i][j+2] = !makeOppValue;
        }
    }

    boolean[][] getLadder() {
        return ladder;
    }
}


