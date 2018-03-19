package ladder.view;

import java.util.ArrayList;
import ladder.domain.Line;
import java.util.List;

public class PrintLadder {

	public void printStart(List<String> names, List<Line> ladder, List<String> inputResult) {
		printNames(names, ladder);
		printLadder(ladder);
		printInputResult(inputResult);
	}

	public void printNames(List<String> names, List<Line> ladder) { // 이름을 출력한다.
		for (String name : names) {
			System.out.printf("%5s ", name);
		}
		System.out.println();
	}

	public void printOneLadder(Line ladder) { // Ladder Line 하나를 출력한다.
		List<Boolean> points = ladder.getLine();
		for (Boolean point : points) {
			System.out.print("|");
			System.out.print(isTruePrint(point));
		}
		System.out.println("|");
	}

	public void printLadder(List<Line> ladder) { // Ladder Line 전부를 출력한다.
		for (Line ladderLine : ladder) {
			System.out.print("  ");
			printOneLadder(ladderLine);
		}
	}

	public String isTruePrint(boolean ladder) { // true면 "-----" false면 " "모양을 출력한다.
		if (ladder) {
			return "-----";
		}
		return "     ";
	}

	public void printInputResult(List<String> inputResult) { // 결과를 출력한다.
		for (String name : inputResult) {
			System.out.printf("%5s ", name);
		}
		System.out.println();
	}

	// 마지막 결과값을 출력하는 메소드
	public static void printAllResult(List<String> finalResult, List<String> inputResult) {
		System.out.println("실행결과");
		for (int i = 0; i < finalResult.size(); i++) {
			System.out.println(finalResult.get(i) + " : " + inputResult.get(i));
		}
	}

	public static void printOneResult(int finalOneMan, List<String> inputResult, String inputName) {
		System.out.println("실행결과");
		System.out.println(inputResult.get(finalOneMan));
	}
}
