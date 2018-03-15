package ladder;

import java.util.ArrayList;

import ladder.domain.LadderGame;
import ladder.domain.Line;
import ladder.view.ImpormationLadder;
import ladder.view.PrintLadder;

public class Ladder {
	
	public static void main(String args[]) {
		PrintLadder draw = new PrintLadder();

		ArrayList<String> names = ImpormationLadder.getNames();
		int ladderNum = ImpormationLadder.getLadderNum();

		LadderGame ride = new LadderGame(ladderNum, names);
		ArrayList<Line> ladder = ride.ladderComplete();
		draw.printNames(names, ladder);
	}
}
