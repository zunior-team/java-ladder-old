package ladder;

public class LadderGame {

	public static void main(String[] args) {

		PrintManager prManager = new PrintManager();
		LadderManager ldManager = new LadderManager();
		int joinUser = prManager.joinUser();
		int maxLadder = prManager.maxLadder();

		ldManager.makeLadder(joinUser, maxLadder);
		ldManager.addMatchBranch(maxLadder);
		prManager.printLadder(ldManager.sortLadder());
	}
}
