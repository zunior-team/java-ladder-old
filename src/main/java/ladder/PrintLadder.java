package ladder;

import java.util.ArrayList;

public class PrintLadder {

	public void printNames(ArrayList<String> names, ArrayList<Line> ladder) { // 이름을 출력한다.
		for (String name : names) {
			System.out.printf("%5s ", name);
		}
		System.out.println();
		printLadder(ladder);
	}

	public void printOneLadder(Line ladder) { // Ladder Line 하나를 출력한다.
		ArrayList<Boolean> allLadder = ladder.getLine();
		for (int j = 0; j < allLadder.size(); j++) {
			System.out.print("|");
			isTruePrint(allLadder.get(j));
		}
		System.out.println("|");
	}

	public void printLadder(ArrayList<Line> ladder) { // Ladder Line 전부를 출력한다.
		for (Line ladderLine : ladder) {
			System.out.print("  ");
			printOneLadder(ladderLine);
		}
	}

	public void isTruePrint(boolean ladder) { // true면 "-----" false면 " "모양을 출력한다.
		if (ladder) {
			System.out.print("-----");
			return;
		}
		System.out.print("     ");
	}
}
