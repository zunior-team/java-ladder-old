package ladder;

public class GameOutput {

	private String[][] ladder;

	public GameOutput(String[][] ladder) {
		this.ladder = ladder;
	}

	public void printLadder(String[][] ladder) {
		for (int i = 0; i < ladder.length; i++) {
			printColumn(i);
			System.out.println();
		}
	}

	public void printColumn(int i) {
		for (int k = 0; k < ladder[0].length; k++) {
			System.out.print("|");
			printBranch(i, k);
		}
	}

	public void printBranch(int i, int k) {
		if (k < ladder[0].length - 1) {
			System.out.print(ladder[i][k]);
		}
	}
}
