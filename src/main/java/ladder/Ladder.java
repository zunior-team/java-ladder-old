package ladder;

public class Ladder {
	public static void main(String args[]) {
		PrintLadder draw = new PrintLadder();

		int manNum = ImpormationLadder.getManNum();
		int ladderNum = ImpormationLadder.getLadderNum();

		LadderRiding ride = new LadderRiding(ladderNum, manNum);
		LadderLine[] ladder = ride.ladderComplete();
		draw.printLadder(ladder);
	}
}
