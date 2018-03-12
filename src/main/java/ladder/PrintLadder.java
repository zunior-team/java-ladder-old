package ladder;

public class PrintLadder {
	public void printOneLadder(LadderLine ladder) {
		boolean[] laprint = ladder.getLine();
		for (int j = 0; j < laprint.length; j++) {
			System.out.print("|");
			isTruePrint(laprint[j]);
		}
		System.out.println("|");
	}

	public void printLadder(LadderLine[] ladder) {
		for (int i = 0; i < ladder.length; i++) {
			printOneLadder(ladder[i]);
		}
	}

	public void isTruePrint(boolean ladder) { // true면 "-" false면 " "모양을 출력한다.
		if (ladder) {
			System.out.print("-");
			return;
		}
		System.out.print(" ");
	}
}
