package ladder;

public class PrintLadder {
	public void printOneLadder(boolean[][] ladder, int i) {
		for (int j = 0; j < ladder[i].length; j++) {
			System.out.print("ㅣ");
			isTruePrint(ladder[i][j]);
		}
		System.out.println("ㅣ");
	}

	public void printLadder(boolean[][] ladder) {
		for (int i = 0; i < ladder.length; i++) {
			printOneLadder(ladder, i);
		}
	}

	public void isTruePrint(boolean ladder) { // true면 "-" false면 " "모양을 출력한다.
		if (ladder) {
			System.out.print("-");
			return;
		}
		System.out.print("  ");
	}
}
