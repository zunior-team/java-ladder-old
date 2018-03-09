package ladder;

public class LadderGame {
	public static void main(String[] args) {

		UserInput input = new UserInput();
		int joinUser = input.joinUser();
		int height = input.maxLadder();

		LadderManager ldManager = new LadderManager();
		String[][] ladderInfo = ldManager.makeLadder(height, joinUser);

		GameOutput gameOutput = new GameOutput(ladderInfo);
		gameOutput.printLadder(ladderInfo);

	}
}
