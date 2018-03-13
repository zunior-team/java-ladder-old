import java.util.Random;

public class LadderGame {
    private char[][] ladderBase;

    public LadderGame(int peopleCount, int height) {
        int row = height;
        int column = peopleCount + (peopleCount - 1);
        this.ladderBase = new char[row][column];
    }

    public void drawLadderLine() {
        int columnCount = getColumns();
        for (int i = 1; i < columnCount; i += 2) {
            inputDash(i);
        }

        for (int i = 0; i <= columnCount; i += 2) {
            inputPipe(i);
        }
    }

    public char[][] getLadderBase() {
        return this.ladderBase;
    }

    public void inputDash(int colIndex) {
        int rowCount = getRows();
        for (int j = 0; j < rowCount; j++) {
            ladderBase[j][colIndex] = getDash(j, colIndex);
        }
    }

    public void inputPipe(int colIndex) {
        int rowCount = getRows();
        for (int j = 0; j < rowCount; j++) {
            ladderBase[j][colIndex] = '|';
        }
    }

    public boolean isOverlap(int row, int col) {
        if (!(col == 1) && ladderBase[row][col - 2] == '-') {
            return true;
        }
        return false;
    }

    public char getDash(int row, int col) {
        if (!isOverlap(row, col) && getRandomNo() == 1) {
            return '-';
        }
        return ' ';
    }

    public int getRandomNo() {
        Random random = new Random();
        return random.nextInt(2);
    }

    public int getColumns() {
        return ladderBase[0].length;
    }

    public int getRows() {
        return ladderBase.length;
    }
}
