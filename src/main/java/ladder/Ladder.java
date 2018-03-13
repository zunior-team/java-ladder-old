package ladder;

import java.util.ArrayList;

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
