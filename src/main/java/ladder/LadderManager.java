package ladder;
import java.util.Random;

public class LadderManager {

	private String[][] ladderInfo;

	public String[][] makeLadder(int height, int joinUser) {
		ladderInfo = new String[height][joinUser];
		for (int k = 0; k < height; k++) {
			makeBranch(k);
		}
		return ladderInfo;
	}

	public void makeBranch(int k) {
		for (int i = 0; i < ladderInfo[0].length; i++) {
			ladderInfo[k][i] = makeBranch(k, i);
		}
	}

	public String makeBranch(int k, int i) {
		Random rand = new Random();
		if (rand.nextInt(2) == 1) {
			return "-";
		}
		return " ";
	}

}
