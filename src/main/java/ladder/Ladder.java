package ladder;

public class Ladder {
	public static void main(String args[]) {
		PrintLadder draw = new PrintLadder();

		int manNum = ImpormationLadder.getManNum();
		int ladderNum = ImpormationLadder.getLadderNum();

		LadderRiding ride = new LadderRiding(ladderNum, manNum);
		boolean[][] ladder = ride.makeAllLadder(ladderNum, manNum);
		draw.printLadder(ladder);
	}
}
