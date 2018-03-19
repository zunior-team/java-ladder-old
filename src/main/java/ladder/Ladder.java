package ladder;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.LadderGame;
import ladder.domain.Line;
import ladder.view.ImpormationLadder;
import ladder.view.PrintLadder;

public class Ladder {

	public static void main(String args[]) {
		gameStart();
	}

	public static void gameStart() {
		PrintLadder draw = new PrintLadder();

		List<String> names = ImpormationLadder.getNames();
		List<String> inputResult = ImpormationLadder.getResult();
		int ladderNum = ImpormationLadder.getLadderNum();

		LadderGame ride = new LadderGame(ladderNum, names);
		List<Line> ladder = ride.ladderComplete();
		draw.printStart(names, ladder, inputResult);
		do {
		} while (CheckOneOrAll(ladder, inputResult, ride)); // all을 입력할때까지 실행한다.
	}

	public static boolean CheckOneOrAll(List<Line> ladder, List<String> inputResult, LadderGame ride) {
		String inputName = ImpormationLadder.getLadderResult();
		if (inputName.equals("all")) {
			List<String> finalResult = ride.createResult(ladder);
			PrintLadder.printAllResult(finalResult, inputResult);
			return false;
		}
		try {
			int finalOneMan = ride.resultOneMan(ladder, inputName);
			PrintLadder.printOneResult(finalOneMan, inputResult, inputName);
		} catch (RuntimeException e) {
			System.out.println("이름이 다릅니다. 다시 입력해주세요.");
			CheckOneOrAll(ladder, inputResult, ride);
		}
		return true;
	}
}
